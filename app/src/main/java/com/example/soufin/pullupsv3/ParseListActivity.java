package com.example.soufin.pullupsv3;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class ParseListActivity extends ListActivity {

    List<ParseWorkout> workouts = new ArrayList<ParseWorkout>();
    ListView parseList;
    List<String> dataList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_list);

        //parseList = (ListView)findViewById(R.id.parse_list);
        /*
        ParseQuery<ParseWorkout> query = new ParseQuery<ParseWorkout>("Workout");

        query.whereEqualTo("Device", ParseInstallation.getCurrentInstallation());

        query.findInBackground(new FindCallback<ParseWorkout>() {
            @Override
            public void done(List<ParseWorkout> list, ParseException e) {
                if ( e != null) {
                    Toast.makeText(ParseListActivity.this, "Error " + e, Toast.LENGTH_SHORT).show();
                }
                for (ParseWorkout workout : list){
                    ParseWorkout newWorkout = new ParseWorkout();
                    newWorkout.setReps(workout.getReps());
                    workouts.add(newWorkout);
                    //Log.v("TRACK :", workouts.get(1).toString());
                }

                ArrayAdapter<ParseWorkout> adapter = new ArrayAdapter<ParseWorkout>(ParseListActivity.this, android.R.layout.simple_expandable_list_item_1, workouts);
                setListAdapter(adapter);
        }}); */

        ParseQuery<ParseObject> pQuery = ParseQuery.getQuery("Workout");
        pQuery.whereEqualTo("Device", ParseInstallation.getCurrentInstallation());
        pQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e==null){
                    if (list.size()>0){
                        ParseObject p = list.get(0);
                        if (p.getList("Reps") != null){
                            dataList = p.getList("Reps");
                        } else {
                            dataList = null;
                        }
                    }
                }
            }
        });

        for (String str : dataList){
            Log.v("YOLO", str + " ");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ParseListActivity.this, android.R.layout.simple_expandable_list_item_1, dataList);
        setListAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parse_list, menu);
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
