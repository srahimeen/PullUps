package com.rahimeen.soufin.pullups;


public class Sets {

   // private int _id;
    private int _reps = 0;
    private int counter = 0;

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
        String reps = Integer.toString(this.getReps());

        return reps;

    }

    public String toNumericString() {
        return Integer.toString(_reps);
    }

    public int toInteger() {
        return this._reps;
    }

    public String toString() {
       // counter++;
        return ("Reps : " + Integer.toString(_reps));
    }

}
