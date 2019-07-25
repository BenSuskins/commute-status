package uk.co.suskins.commutestatus;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import uk.co.suskins.darwin.ALRAccessToken;
import uk.co.suskins.darwin.ALRArrayOfServiceItemsWithCallingPoints_2;
import uk.co.suskins.darwin.ALREnums;
import uk.co.suskins.darwin.ALRLDBServiceSoap;
import uk.co.suskins.darwin.ALRServiceItemWithCallingPoints_2;
import uk.co.suskins.darwin.ALRStationBoardWithDetails_2;

public class MainActivity extends AppCompatActivity {
    //Constants
    private static final String CANCELLED = "Cancelled";
    private static final String ON_TIME = "On time";
    private static final String CHANNEL_ID = "Updates";
    private ALRArrayOfServiceItemsWithCallingPoints_2 hockleyDetails;
    private ALRArrayOfServiceItemsWithCallingPoints_2 stratfordDetails;
    private Integer index = 0;
    private int notificationId = 0;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Allow network in Main Thread todo Make async requests
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Create Notification Channel
        createNotificationChannel();
        notificationManager = NotificationManagerCompat.from(this);

        //Update App Text
        refresh();
        //sendNotif();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        } else if (id == R.id.action_journeycheck) {
            Uri uriUrl = Uri.parse("https://www.journeycheck.com/greateranglia/search?from=HOC&to=SRA");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void sendNotif() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Train Time Update")
                .setContentText("The next train to Stratford is " + stratfordDetails.get(0).etd)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(notificationId++, builder.build());

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Train Time Update")
                .setContentText("The next train to Hockley is " + hockleyDetails.get(0).etd)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(notificationId++, builder.build());
    }

    private void refresh() {
        getToHockleyDetails();
        getToStratfordDetails();
        index = 0;
        update();
    }

    private void update() {
        Log.i("Update", "index is " + index);
        updateToHockley();
        updateToStratford();

    }

    private boolean detailsInvalid(ALRArrayOfServiceItemsWithCallingPoints_2 details) {
        if (details == null) {
            return true;
        }

        return (details.size() <= index);
    }

    private void getToHockleyDetails() {
        try {
            ALRLDBServiceSoap service = new ALRLDBServiceSoap();
            ALRStationBoardWithDetails_2 depBoard = service.GetDepBoardWithDetails(2, "SRA", "HOC", ALREnums.FilterType.to, 0, 0, new ALRAccessToken());
            hockleyDetails = depBoard.trainServices;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getToStratfordDetails() {
        try {
            ALRLDBServiceSoap service = new ALRLDBServiceSoap();
            ALRStationBoardWithDetails_2 depBoard = service.GetDepBoardWithDetails(2, "HOC", "SRA", ALREnums.FilterType.to, 0, 0, new ALRAccessToken());
            stratfordDetails = depBoard.trainServices;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateToStratford() {
        //Check Details Valid
        if (detailsInvalid(stratfordDetails)) {
            noTrainsStratford();
        } else {

            //Get Data
            ALRServiceItemWithCallingPoints_2 data = stratfordDetails.get(index);

            //Create Variables
            TextView stratfordTime = findViewById(R.id.stratfordTime);
            TextView stratfordStatus = findViewById(R.id.stratfordStatus);
            TextView stratfordPlatform = findViewById(R.id.stratfordPlatform);

            //Set Scheduled Time of Departure
            stratfordTime.setText(getString(R.string.text_to_stratford, data.std));

            //Set Status (Cancelled or Estimated Time of Departure)
            if (data.filterLocationCancelled) {
                stratfordStatus.setText(getString(R.string.text_status_stratford, CANCELLED));
                stratfordPlatform.setTextSize(20);
                stratfordPlatform.setText(getString(R.string.text_platform_stratford, data.cancelReason + "."));
            } else {
                stratfordStatus.setText(getString(R.string.text_status_stratford, data.etd));
                stratfordPlatform.setTextSize(55);
                if (data.platform == null) {
                    stratfordPlatform.setText(getString(R.string.text_platform_hockley, "Platform Unknown"));
                }
                stratfordPlatform.setText(getString(R.string.text_platform_stratford, "Platform " + data.platform));
            }

            //Update Background Colour
            if (stratfordStatus.getText().equals(CANCELLED)) {
                stratfordStatus.setBackgroundColor(getColor(R.color.colorCancelled));
            } else if (stratfordStatus.getText().equals(ON_TIME)) {
                stratfordStatus.setBackgroundColor(getColor(R.color.colorOnTime));
            } else {
                stratfordStatus.setBackgroundColor(getColor(R.color.colorDelayed));
            }
        }
    }

    private void noTrainsStratford() {
        //Update Stratford
        TextView stratfordTime = findViewById(R.id.stratfordTime);
        TextView stratfordStatus = findViewById(R.id.stratfordStatus);
        TextView stratfordPlatform = findViewById(R.id.stratfordPlatform);
        stratfordTime.setText(getString(R.string.text_to_stratford, "No Trains"));
        stratfordStatus.setText(getString(R.string.text_status_stratford, ""));
        stratfordPlatform.setText(getString(R.string.text_platform_stratford, ""));
    }

    private void updateToHockley() {
        //Check Details Valid
        if (detailsInvalid(hockleyDetails)) {
            noTrainsHockley();
        } else {

            //Get Data
            ALRServiceItemWithCallingPoints_2 data = hockleyDetails.get(index);

            //Create Variables
            TextView hockleyTime = findViewById(R.id.hockleyTime);
            TextView hockleyPlatform = findViewById(R.id.hockleyPlatform);
            TextView hockleyStatus = findViewById(R.id.hockleyStatus);

            //Set Scheduled Time of Departure
            hockleyTime.setText(getString(R.string.text_to_hockley, data.std));

            //Set Status (Cancelled or Estimated Time of Departure)
            if (data.filterLocationCancelled) {
                hockleyStatus.setText(getString(R.string.text_status_hockley, CANCELLED));
                hockleyPlatform.setTextSize(20);
                hockleyPlatform.setText(getString(R.string.text_platform_hockley, data.cancelReason + "."));
            } else {
                hockleyStatus.setText(getString(R.string.text_status_hockley, data.etd));
                hockleyPlatform.setTextSize(55);
                if (data.platform == null) {
                    hockleyPlatform.setText(getString(R.string.text_platform_hockley, "Platform Unknown"));
                }
                hockleyPlatform.setText(getString(R.string.text_platform_hockley, "Platform " + data.platform));
            }

            //Update Background Colour
            if (hockleyStatus.getText().equals(CANCELLED)) {
                hockleyStatus.setBackgroundColor(getColor(R.color.colorCancelled));
            } else if (hockleyStatus.getText().equals(ON_TIME)) {
                hockleyStatus.setBackgroundColor(getColor(R.color.colorOnTime));
            } else {
                hockleyStatus.setBackgroundColor(getColor(R.color.colorDelayed));
            }
        }
    }

    private void noTrainsHockley() {
        //Update Hockley
        TextView hockleyTime = findViewById(R.id.hockleyTime);
        TextView hockleyPlatform = findViewById(R.id.hockleyPlatform);
        TextView hockleyStatus = findViewById(R.id.hockleyStatus);
        hockleyTime.setText(getString(R.string.text_to_hockley, "No Trains"));
        hockleyStatus.setText(getString(R.string.text_status_hockley, ""));
        hockleyPlatform.setText(getString(R.string.text_platform_hockley, ""));
    }

    public void toggleTrains(View view) {
        Log.d("Toggle", "button press");
        if (index == 0) {
            index = 1;
            update();
        } else if (index == 1) {
            index = 0;
            update();
        }
    }
}
