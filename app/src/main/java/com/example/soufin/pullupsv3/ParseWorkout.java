package com.example.soufin.pullupsv3;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Soufin on 7/5/2015.
 */

@ParseClassName("Workout")
public class ParseWorkout extends ParseObject{

    public List<String> getReps() {
        return getList("Reps");
    }

    public void setReps(List<String> reps){
        put("Reps", reps);
    }

    public String toString() {

        String temp = "";

        for (String str : this.getReps()){
            temp = (str + "/");
        }

        return temp;
    }
}
