package uk.co.suskins.commutestatus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
    public static final int ROWS = 4;

    //Variables
    SharedPreferences sharedPref;
    private ALRArrayOfServiceItemsWithCallingPoints_2 homeDetails;
    private ALRArrayOfServiceItemsWithCallingPoints_2 workDetails;
    private Integer index = 0;
    public String workStationCrs;
    public String homeStationCrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Allow network in Main Thread todo Make async requests
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Set Shared Preferences
        sharedPref = super.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        //Update App Text
        refresh();
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
            Uri uriUrl = Uri.parse(String.format("http://ojp.nationalrail.co.uk/service/timesandfares/%s/%s/today/0700/dep", homeStationCrs, workStationCrs));
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
            return true;
        } else if (id == R.id.action_set_home) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Set Home Station");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
            input.setText(homeStationCrs);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(getString(R.string.home_crs), input.getText().toString());
                    editor.apply();
                    refresh();
                }
            });

            builder.show();
            return true;
        } else if (id == R.id.action_set_work) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Set Work Station");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
            input.setText(workStationCrs);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(getString(R.string.work_crs), input.getText().toString());
                    editor.apply();
                    refresh();
                }
            });

            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        homeStationCrs = sharedPref.getString(getString(R.string.home_crs), "SRA");
        workStationCrs = sharedPref.getString(getString(R.string.work_crs), "LST");

        getToHomeDetails();
        getToWorkDetails();
        index = 0;
        update();
    }

    private void update() {
        updateToHome();
        updateToWork();
    }

    private boolean detailsInvalid(ALRArrayOfServiceItemsWithCallingPoints_2 details) {
        if (details == null) {
            return true;
        }

        return (details.size() <= index);
    }

    private void getToHomeDetails() {
        try {
            ALRLDBServiceSoap service = new ALRLDBServiceSoap();
            ALRStationBoardWithDetails_2 depBoard = service.GetDepBoardWithDetails(ROWS, workStationCrs, homeStationCrs, ALREnums.FilterType.to, 0, 0, new ALRAccessToken());
            homeDetails = depBoard.trainServices;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getToWorkDetails() {
        try {
            ALRLDBServiceSoap service = new ALRLDBServiceSoap();
            ALRStationBoardWithDetails_2 depBoard = service.GetDepBoardWithDetails(ROWS, homeStationCrs, workStationCrs, ALREnums.FilterType.to, 0, 0, new ALRAccessToken());
            workDetails = depBoard.trainServices;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateToWork() {
        //Check Details Valid
        if (detailsInvalid(workDetails)) {
            noTrainsStratford();
        } else {
            //Get Data
            ALRServiceItemWithCallingPoints_2 data = workDetails.get(index);

            //Create Variables
            TextView stratfordTime = findViewById(R.id.stratfordTime);
            TextView stratfordStatus = findViewById(R.id.stratfordStatus);
            TextView stratfordPlatform = findViewById(R.id.stratfordPlatform);

            //Set Scheduled Time of Departure
            stratfordTime.setText(getString(R.string.text_to_stratford, data.std));

            //Set Status (Cancelled or Estimated Time of Departure)
            if (data.filterLocationCancelled || data.isCancelled) {
                stratfordStatus.setText(getString(R.string.text_status_stratford, CANCELLED));
                stratfordPlatform.setTextSize(20);
                stratfordPlatform.setText(getString(R.string.text_platform_stratford, String.format("%s.", data.cancelReason)));
            } else {
                stratfordStatus.setText(getString(R.string.text_status_stratford, data.etd));
                stratfordPlatform.setTextSize(55);
                stratfordPlatform.setText(getString(R.string.text_platform_stratford, String.format("Platform %s", data.platform == null ? "Unknown" : data.platform)));
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
        stratfordStatus.setBackgroundColor(Color.TRANSPARENT);
        stratfordPlatform.setText(getString(R.string.text_platform_stratford, ""));
    }

    private void updateToHome() {
        //Check Details Valid
        if (detailsInvalid(homeDetails)) {
            noTrainsHockley();
        } else {
            //Get Data
            ALRServiceItemWithCallingPoints_2 data = homeDetails.get(index);

            //Create Variables
            TextView hockleyTime = findViewById(R.id.hockleyTime);
            TextView hockleyPlatform = findViewById(R.id.hockleyPlatform);
            TextView hockleyStatus = findViewById(R.id.hockleyStatus);

            //Set Scheduled Time of Departure
            hockleyTime.setText(getString(R.string.text_to_hockley, data.std));

            //Set Status (Cancelled or Estimated Time of Departure)
            if (data.filterLocationCancelled || data.isCancelled) {
                hockleyStatus.setText(getString(R.string.text_status_hockley, CANCELLED));
                hockleyPlatform.setTextSize(20);
                hockleyPlatform.setText(getString(R.string.text_platform_hockley, String.format("%s.", data.cancelReason)));
            } else {
                hockleyStatus.setText(getString(R.string.text_status_hockley, data.etd));
                hockleyPlatform.setTextSize(55);
                hockleyPlatform.setText(getString(R.string.text_platform_hockley, String.format("Platform %s", data.platform == null ? "Unknown" : data.platform)));
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
        hockleyStatus.setBackgroundColor(Color.TRANSPARENT);
        hockleyPlatform.setText(getString(R.string.text_platform_hockley, ""));
    }

    public void toggleTrains(View view) {
        index++;
        if (index >= ROWS) {
            index = 0;
        }
        update();
    }
}
