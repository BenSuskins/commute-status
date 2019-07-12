package uk.co.suskins.commutestatus;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        updateTrainTimes();
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
            updateTrainTimes();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateTrainTimes() {
        //Updates the Text Views
        //Hockley Text Views
        TextView hockleyTime = findViewById(R.id.hockley_time);
        TextView hockleyStatus = findViewById(R.id.hockley_status);

        //Stratford Text Views
        TextView stratfordTime = findViewById(R.id.stratford_time);
        TextView stratfordStatus = findViewById(R.id.stratford_status);


        //Update the Time and Status values
        //updateTime(hockleyTime, stratfordTime);

        //Time should be set to the STD
        //Status should be set to the ETD - On Time or Delayed Time

        //updateStatus(hockleyStatus, stratfordStatus);
    }

}
