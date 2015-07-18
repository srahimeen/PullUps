package com.rahimeen.soufin.pullups;


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

    public String toString() {
        String output = "Empty";
        int count = -1;
        for (Sets set : this._sets){
            count++;
            output =  "SET : " + Integer.toString(count) +  set.toString();
        }

        return output;
    }

    public ArrayList<Integer> storeList(){
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        //historyList.add(this.toNumericString());
        for (Sets set : this.getSets()) {
                tempList.add(set.toInteger());
        }

        return tempList;
    }

    // this is a useless method
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
