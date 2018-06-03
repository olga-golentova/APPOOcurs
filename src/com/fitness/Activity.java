package com.fitness;



public class Activity {
    private int ID;
    private int time;

    public Activity(int ID, int time) {
        this.ID = ID;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
