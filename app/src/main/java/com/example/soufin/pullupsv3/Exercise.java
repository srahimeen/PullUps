package com.example.soufin.pullupsv3;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.example.soufin.pullupsv3.Sets;

/**
 * Created by Soufin on 6/26/2015.
 */
public class Exercise {

    //public int ID;
    private String _name;
    private List<Sets> _sets = new ArrayList<Sets>();

    //getter
    public String getName()
    {
        return this._name;
    }
    //setter
    public void setName(String name)
    {
        this._name = name;
    }

    //getter
    public List getSets() {return this._sets; }
    // setter
   public void addSet(){
       Sets temp = new Sets();
       this._sets.add(temp);
   }

    public String displaySets() {

        String displaySet = new String();

        for (Sets set: _sets) {
            displaySet=set.displayReps();
        }

        return displaySet;

    }

    public void updateSetAt(int index, int reps){

        //this._sets.get(index).setReps(reps);
        Sets temp = this._sets.get(index);
        temp.setReps(reps);
        this._sets.set(index, temp);

    }

    public String toString() {
        String output = "Empty";
        int count = -1;
        for (Sets set : this._sets){
            count++;
            output =  "SET : " + Integer.toString(count) + " REPS : " + set.toString();
        }

        return output;
    }

    public ArrayList<String> setHistoryList(){
        ArrayList<String> historyList = new ArrayList<String>();
        historyList.add(this.toString());
        return historyList;
    }



}
