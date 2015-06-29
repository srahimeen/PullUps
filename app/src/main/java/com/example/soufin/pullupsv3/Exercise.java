package com.example.soufin.pullupsv3;


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
   public void setSets(int reps){
       Sets tempSet = new Sets();
       tempSet.setReps(reps);
       this._sets.add(tempSet);
   }

    public String displaySets() {

        String displaySet = new String();

        for (Sets set: _sets) {
            displaySet=set.displayReps();
        }

        return displaySet;

    }




}
