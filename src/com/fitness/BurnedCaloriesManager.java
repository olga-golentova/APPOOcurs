package com.fitness;

public class BurnedCaloriesManager implements IBurnedCaloriesCalculator{
    public static final int RUNNING = 1;
    public static final int SWIMMING = 2;
    public static final int WORKOUT = 3;
    public static final int WALKING = 4;
    public static final int RIDDING = 5;


    private int getActivityCalories(int productID) {
        int number = 0;
        switch (productID) {
            case RUNNING:
                number = 9;
                break;

            case SWIMMING:
                number = 8;
                break;
            case WORKOUT:
                number = 5;
                break;
            default:
                number = 11
                ;
        }
        return number;
    }

    public int getBurnedCalories(Person person) {
        int caloriesSum = 0;
        for (Activity activity : person.getActivityList()) {
            caloriesSum += getActivityCalories(activity.getID()) * activity.getTime();
        }
        return caloriesSum;
    }

}