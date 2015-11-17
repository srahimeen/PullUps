package com.rahimeen.soufin.pullups; 
 
 
import android.app.Application;
 
 
import com.parse.Parse; 
import com.parse.ParseACL; 
import com.parse.ParseUser; 
 
 
 
 
/** 
 * Created by Soufin on 7/3/2015. 
 * Has to be included in manifest 
 */ 
public class ParseApplication extends Application {
 
 
    @Override 
    public void onCreate() { 
        super.onCreate(); 
 
 
        //ParseCrashReporting.enable(this); okok 
        //ParseObject.registerSubclass(ParseWorkout.class); 
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "xoxo", "xoxo");
 
 
        ParseUser.enableAutomaticUser(); 
        ParseACL defaultACL = new ParseACL();
 
 
        // If you would like all objects to be private by default, remove this line. 
        defaultACL.setPublicReadAccess(true);
 
 
        ParseACL.setDefaultACL(defaultACL, true);
    } 
 
 
 
 
} 
