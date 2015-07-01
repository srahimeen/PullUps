package com.example.soufin.pullupsv3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {

    private Button mNew; //declare button for newWorkoutButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //=== PARSE ===

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "MeMuuS9hfDM3LvnqettvWmt9alcr0qLwZIuDqvpw", "bCEERDTH8VrFpI0hD8pR5SXSUQmrlpB9oK8DWYMQ");


        //=============

        mNew = (Button)findViewById(R.id.mainNewButton);

        mNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Workout.class);
                startActivity(i);
            }
        });


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
