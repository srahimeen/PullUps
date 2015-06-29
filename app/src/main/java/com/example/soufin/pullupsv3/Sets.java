package com.example.soufin.pullupsv3;

/**
 * Created by Soufin on 6/26/2015.
 */
public class Sets {

   // private int _id;
    private int _reps;

    //constructor
    //Sets(int reps) {
     //   setReps(reps);
    //}

    //getter
    public int getReps()
    {
        return this._reps;
    }
    //setter
    public void setReps(int reps)
    {
        this._reps = reps;
    }

    public String displayReps() {
        String reps = Integer.toString(this._reps);

        return reps;

    }

    public String toString() {
        return Integer.toString(_reps);
    }

}
