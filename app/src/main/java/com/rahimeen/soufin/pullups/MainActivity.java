package com.rahimeen.soufin.pullups;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private Button mNew; //declare button for newWorkoutButton
    private Button mHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_p);

        // display pullup image
        ImageView img= (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.pullupimg);

        //*****************DONT MESS WITH THIS*********************************

        mNew = (Button)findViewById(R.id.mainNewButton);


        mNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Workout.class); //change to workout.class
                startActivity(i);
            }
        });



        mHistory = (Button)findViewById(R.id.historyButton);

        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ParseManager.class); //change to workout.class
                startActivity(i);
            }
        });


        //*****************DONT MESS WITH THIS*********************************


    }


    @Override
    public void onBackPressed() {
        // do nothing on back pressed
        this.moveTaskToBack(true); // "close" app on back

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_MENU ) {
            //do nothing
            return true;
        }
        return super.onKeyDown(keyCode, event);
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
