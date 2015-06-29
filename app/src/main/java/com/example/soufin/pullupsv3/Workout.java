package com.example.soufin.pullupsv3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;
import android.R.*;

import com.example.soufin.pullupsv3.Sets;
import com.example.soufin.pullupsv3.Exercise;

import org.w3c.dom.Text;



public class Workout extends ActionBarActivity {

    Exercise pullup;
    Button wNew;
    Button wTap;
    Button wEnd;
    TextView displayText;
    int newIndex = -1;
    int tapCount;
    int[] score = new int[5];
    boolean flag = false;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        pullup = new Exercise();
        pullup.setName("Pullup");
        result = "Untapped";

        wNew = (Button) findViewById(R.id.newSetButton);
        wTap = (Button) findViewById(R.id.tapButton);
        wEnd = (Button) findViewById(R.id.endWorkoutButton);
        displayText = (TextView) findViewById(R.id.displayScore);



        wTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapCount++; // increment based on number of taps
                pullup.updateSetAt(newIndex, tapCount);
                result = pullup.displaySets();
                displayText.setText(result); // should be result string
                Log.v("TRACK :", pullup.toString() + " tapCount : " + tapCount);
            }
        });

        wNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIndex += 1;
                pullup.addSet();
                tapCount = 0;
                result = "NEW SET!";
                displayText.setText(result);
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