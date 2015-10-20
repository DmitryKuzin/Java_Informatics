package model;

import model.sort.iSort;

import java.util.TreeMap;

public class SortTimer {
    private int id=0;
    private TreeMap<Integer,Double> history=new TreeMap<>();
    public TreeMap<Integer,Double> getHistory(){
        return history;
    }
    public int[] sortAndGetTime(iSort a,int[] array){
        int myOwnID=++id;
        double timeStart=System.currentTimeMillis();
        int[] arr=a.sort(array);
        double timeFinish=System.currentTimeMillis();
        history.put(myOwnID,timeFinish-timeStart);
        return arr;
    }
    public void cleanHistory(){
        this.history=new TreeMap<>();
        this.id=0;
    }
}
