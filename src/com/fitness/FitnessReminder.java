package com.fitness;



import java.util.ArrayList;
import java.util.List;

public class FitnessReminder {
    List<Training>  reminderList = new ArrayList<Training>();


   public void addTraining(Training reminder) {
        reminderList.add(reminder);
    }



}

