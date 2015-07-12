package com.example.soufin.pullupsv3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Workout extends ActionBarActivity {

    // exercise
    Exercise pullup;
    //buttons
    Button wNew;
    Button wTap;
    Button wEnd;
    //list
    ListView displayHistory;
    static ArrayList<Integer> storeList = new ArrayList<Integer>();
    // counters
    static int newIndex = 0;
    int tapCount = 0;
    // strings
    String displayTapsString;
    String displayResultString;
    // toasts
    Toast pleaseTap;
    // bools
    boolean firstNew = true;
    boolean flag = false;
    //constants
    int MAX_SETS = 15;
    int MAX_REPS = 25;
    //end things



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_p);

        pullup = new Exercise();
        pullup.setName("Pullup");
        displayTapsString = "Untapped";

        wNew = (Button) findViewById(R.id.newSetButton);
        wTap = (Button) findViewById(R.id.tapButton);
        wEnd = (Button) findViewById(R.id.endWorkoutButton);
        displayHistory = (ListView) findViewById(R.id.displayHistoryList);



        final ArrayAdapter<Sets> arrayAdapter = new ArrayAdapter<Sets>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                pullup.getSets()
        );

       // displayHistory.setVisibility((pullup.getSets() == null) ? View.GONE : View.VISIBLE);

        //displayHistory.setAdapter(arrayAdapter);

        //disable tap by default
        wTap.setEnabled(false);
        //tap button
        wTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tapCount < MAX_REPS) {
                    tapCount++; // increment based on number of taps

                    //pullup.updateSetAt(tapCount); // add taps to current set

                    displayTapsString = pullup.displaySets(); // shows reps inside sets


                    wTap.setText(Integer.toString(tapCount));


                    //Log.v("TRACK :", pullup.toString() + " tapCount : " + tapCount);


                    // prints above log to screen
                    displayResultString = pullup.toString();


                }
            }
        });
        //tap button end

        //new button
        wNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newIndex < MAX_SETS) {
                    //check if new is being pressed for the first time
                    if (!firstNew) {
                        // null check
                        if (tapCount > 0) {
                            pullup.addSet(tapCount);
                            tapCount = 0;
                            displayTapsString = "NEW SET!";
                            wTap.setText(Integer.toString(tapCount));

                            newIndex++; //increment index
                            //enable tap button

                            wTap.setEnabled(true);

                            //populate list
                            // tempList.add(newIndex, pullup.getSets().toNumericString());
                    /*for (Sets set : pullup.getSets()) {
                        Log.v("HISTORY :",  set.toString());

                    }*/

                        /*
                        int index = 0;
                        for (Sets s : pullup.getSets()) {
                            Log.v("CHECK:", (String.valueOf(index++) + ": " + s.toString()));
                        }*/


                            if (newIndex > 0) {
                                displayHistory.setAdapter(arrayAdapter);
                            }


                        } else {
                            pleaseTap = Toast.makeText(getApplicationContext(), "Please tap!", Toast.LENGTH_SHORT);
                            pleaseTap.show();
                        }
                    } else {

                        wTap.setEnabled(true);
                        displayTapsString = "NEW SET!";
                        wTap.setText(Integer.toString(tapCount));
                        firstNew = false;
                    }
                }


            }

        });
        //new button end

        //end button
        wEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // null check
                //if (tapCount > 0) {
                    // add the last taps to the current list
                    pullup.addSet(tapCount);

                    // have to store the list here else the last taps dont carry over to next activity
                    storeList = pullup.storeList();

                    // update display one last time
                    displayHistory.setAdapter(arrayAdapter);

                    int index = 0;
                    for (int i : pullup.storeList()) {
                        Log.v("STORE:", (String.valueOf(index++) + ": " + Integer.toString(i)));
                    }

                    // switch activity and send stored list over to next activity
                    Intent i = new Intent(getApplicationContext(), endWorkout.class);
                    i.putIntegerArrayListExtra("storeList", storeList);
                    startActivity(i);

                //} else {
                 //   pleaseTap = Toast.makeText(getApplicationContext(), "Please tap!", Toast.LENGTH_SHORT);
                  //  pleaseTap.show();
                //}
            }
        });

        //end button end


    }

    @Override
    public void onBackPressed() {
        // do nothing on back pressed
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