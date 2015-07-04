package com.example.soufin.pullupsv3;

import android.media.Rating;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.soufin.pullupsv3.Workout;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class endWorkout extends ActionBarActivity {

    //buttons
    Button eBack;
    // texts
    TextView eSetsValue;
    TextView eTotalRepsValue;
    TextView eAverageValue;
    // rating
    RatingBar eScore;
    //counters
    int setCount = 0;
    int totalReps = 0;
    double average = 0;
    // lists
    ArrayList<String> inputList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_workout);

        //initialize views
        eTotalRepsValue = (TextView)findViewById(R.id.totalRepsValue);
        eSetsValue = (TextView)findViewById(R.id.setsValue);
        eAverageValue = (TextView)findViewById(R.id.averageValue);
        eScore = (RatingBar)findViewById(R.id.rating);


        // receive list from previous activity
        inputList = getIntent().getStringArrayListExtra("storeList");

        // debug
        int index = 0;
        for (String s : inputList) {
            Log.v("STORE:", (String.valueOf(index++) + ": " + s.toString()));
        }


        for (String str : inputList){
            setCount++;
            totalReps += Integer.parseInt(str);
        }

        average = totalReps/setCount;

        eSetsValue.setText(Integer.toString(setCount));
        eTotalRepsValue.setText(Integer.toString(totalReps));
        eAverageValue.setText(Double.toString(average));
        eScore.setRating((float)average);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end_workout, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
