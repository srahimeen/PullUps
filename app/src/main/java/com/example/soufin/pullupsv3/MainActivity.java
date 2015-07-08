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

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Button mNew; //declare button for newWorkoutButton
    private ListView displayList;
    List<String> store = new ArrayList<String>();
    List<ParseObject> storeP = new ArrayList<ParseObject>();
    String result = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayList = (ListView)findViewById(R.id.displayList);

        //*****************DONT MESS WITH THIS*********************************

        mNew = (Button)findViewById(R.id.mainNewButton);

        mNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Workout.class); //change to workout.class
                startActivity(i);
            }
        });

        //*****************DONT MESS WITH THIS*********************************
        //adapter
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                store
        );

        arrayAdapter.notifyDataSetChanged();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Workout");
        query.whereEqualTo("Device", ParseInstallation.getCurrentInstallation());
        query.setLimit(100);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                storeP.addAll(list);
            }
        });

        //parse obj to str
        for (ParseObject obj : storeP){
            store.add(obj.toString());
            Log.v("THIS: ", obj.toString());
        }

        /*query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {

                String status = object.getString("newStatus");
            }
        });*/

        displayList.setAdapter(arrayAdapter);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
