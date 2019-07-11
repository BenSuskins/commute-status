package uk.co.suskins.commutestatus;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        updateStatus();
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

        return super.onOptionsItemSelected(item);
    }

    public void updateStatus() {
        //Updates the Text Views
        //Hockley Text Views
        TextView hockleyTime = findViewById(R.id.hockley_time);
        TextView hockleyStatus = findViewById(R.id.hockley_status);

        //Stratford Text Views
        TextView stratfordTime = findViewById(R.id.stratford_time);
        TextView stratfordStatus = findViewById(R.id.stratford_status);


        //Update the Time and Status values
        updateHockley(hockleyTime, hockleyStatus);
        updateStratford(stratfordTime, stratfordStatus);

        //Update the background colours
        updateColor(hockleyStatus, stratfordStatus);
    }

    private void updateStratford(TextView stratfordTime, TextView stratfordStatus) {
        updateStratfordTime(stratfordTime);
        updateStratfordStatus(stratfordStatus);
    }

    private void updateHockley(TextView hockleyTime, TextView hockleyStatus) {
        updateHockleyTime(hockleyTime);
        updateHockleyStatus(hockleyStatus);
    }

    private void updateHockleyTime(TextView hockleyTime) {
        //todo
    }

    private void updateStratfordTime(TextView stratfordTime) {
        //todo
    }

    private void updateStratfordStatus(TextView stratfordStatus) {
        //todo
        stratfordStatus.setText(R.string.train_status_cancelled);
    }

    private void updateHockleyStatus(TextView hockleyStatus) {
        //todo
        hockleyStatus.setText(R.string.train_status_on_time);
    }

    private void updateColor(TextView hockleyStatus, TextView stratfordStatus) {
        List<TextView> statuses = new LinkedList<>();
        statuses.add(hockleyStatus);
        statuses.add(stratfordStatus);

        for (TextView status : statuses) {
            if (status.getText().equals(getString(R.string.train_status_on_time))) {
                status.setBackgroundColor(getResources().getColor(R.color.colorOnTime));
            } else if (status.getText().equals(getString(R.string.train_status_cancelled))) {
                status.setBackgroundColor(getResources().getColor(R.color.colorCancelled));
            } else if (status.getText().equals(getString(R.string.train_status_delayed))) {
                status.setBackgroundColor(getResources().getColor(R.color.colorDelayed));
            }
        }
    }
}
