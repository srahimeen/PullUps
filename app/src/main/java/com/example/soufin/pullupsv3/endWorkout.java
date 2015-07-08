package com.example.soufin.pullupsv3;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.soufin.pullupsv3.Workout;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;

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
    ArrayList<Integer> inputList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_workout);

        //initialize views
        eTotalRepsValue = (TextView)findViewById(R.id.totalRepsValue);
        eSetsValue = (TextView)findViewById(R.id.setsValue);
        eAverageValue = (TextView)findViewById(R.id.averageValue);
        eScore = (RatingBar)findViewById(R.id.rating);
        eBack = (Button)findViewById(R.id.backButton);


        // receive list from previous activity
        inputList = getIntent().getIntegerArrayListExtra("storeList");

        // debug
        int index = 0;
        for (int i : inputList) {
            Log.v("STORE:", (String.valueOf(index++) + ": " + Integer.toString(i)));
        }


        // set total reps
        for (Integer i : inputList){
            setCount++;
            totalReps += i;
        }
        // set average
        average = totalReps/setCount;
        // display everything
        eSetsValue.setText(Integer.toString(setCount));
        eTotalRepsValue.setText(Integer.toString(totalReps));
        eAverageValue.setText(Double.toString(average));
        eScore.setRating((float) average);

        //convert from list of ints to string
        String result = "";
        boolean first = true;
        for(Integer i : inputList){
            if(first){
                result += Integer.toString(i);
                first = false;
            } else {
                result += "/" + Integer.toString(i);
            }

        }

        // log test
        Log.v("RESULT: ", result);


        // Parse Storage
        ParseObject testObject = ParseObject.create("Workout");
        testObject.put("Device", ParseInstallation.getCurrentInstallation());
        testObject.put("RepsInt", inputList);
        testObject.put("Result", result);
        testObject.put("Average", average);
        testObject.saveInBackground();

        eBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class); //change to workout.class
                startActivity(i);
            }
        });


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
