package com.example.soufin.pullupsv3;


import java.util.ArrayList;
import java.util.List;


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
    public List<Sets> getSets() {return this._sets;}
    //setter
   public void addSet(int reps){
       Sets temp = new Sets();
       temp.setReps(reps);
       this._sets.add(temp);
   }

    public String displaySets() {

        String displaySet = new String();

        for (Sets set: _sets) {
            displaySet=set.displayReps();
        }

        return displaySet;

    }

    public void updateSetAt(int reps){

        //this._sets.get(index).setReps(reps);
       /* Sets temp = this._sets.get(index);
        temp.setReps(reps);
        this._sets.set(index, temp);*/

        //Sets temp = new Sets();
        //this._sets.add(temp.setReps(reps));


    }

    public String toString() {
        String output = "Empty";
        int count = -1;
        for (Sets set : this._sets){
            count++;
            output =  "SET : " + Integer.toString(count) +  set.toString();
        }

        return output;
    }

    public List<Sets> getHistoryList(){
        List<Sets> tempList = new ArrayList<Sets>();
        //historyList.add(this.toNumericString());
        int count = 0;
        for (Sets set : this.getSets()) {
            if (set.toNumericString() != "0") {
                tempList.add(count, set);
            }
        }

        return tempList;
    }

    public ArrayList<String> getHistoryListTest(){
        ArrayList<String> tempList = new ArrayList<String>();
        //historyList.add(this.toNumericString());
        int count = 0;
        for (Sets set : this.getSets()) {
            tempList.add(count, set.toNumericString());
        }
        if (!tempList.isEmpty()) {
            tempList.remove(0); // remove first item which is zero
        }
        return tempList;

    }

    public void removeAtIndex(int index) {
        this._sets.set(index, null);
    }




}
