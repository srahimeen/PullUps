package com.example.soufin.pullupsv3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Workout extends ActionBarActivity {

    Exercise pullup;
    Button wNew;
    Button wTap;
    Button wEnd;
    TextView displayTaps;
    TextView displayResult;
    int newIndex = -1;
    int tapCount;
    int[] score = new int[5];
    boolean flag = false;
    String displayTapsString;
    String displayResultString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        pullup = new Exercise();
        pullup.setName("Pullup");
        displayTapsString = "Untapped";

        wNew = (Button) findViewById(R.id.newSetButton);
        wTap = (Button) findViewById(R.id.tapButton);
        wEnd = (Button) findViewById(R.id.endWorkoutButton);
        displayTaps = (TextView) findViewById(R.id.displayTaps);
        displayResult = (TextView) findViewById(R.id.displayResult);


        wTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapCount++; // increment based on number of taps
                pullup.updateSetAt(newIndex, tapCount);
                displayTapsString = pullup.displaySets();
                displayTaps.setText(displayTapsString); // should be displayTapsString string
                Log.v("TRACK :", pullup.toString() + " tapCount : " + tapCount);

                displayResultString = pullup.toString();
                displayResult.setText(displayResultString);
            }
        });

        wNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIndex += 1;
                pullup.addSet();
                tapCount = 0;
                displayTapsString = "NEW SET!";
                displayTaps.setText(displayTapsString);


            }

        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout, menu);
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