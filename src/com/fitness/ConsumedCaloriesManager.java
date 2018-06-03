package com.fitness;

public class ConsumedCaloriesManager implements IConsumedCaloriesCalculator {
    public static final int BREAD = 1;
    public static final int MILK = 2;
    public static final int JUICE = 3;
    public static final int CEREALE = 4;
    public static final int SPAGHETI = 5;
    public static final int MEAT = 6;
    public static final int CHOCOLATE = 7;
    public static final int BEER = 8;
    public static final int HONEY = 9;

    private int getProductCalories(int productID) {
        int number = 0;
        switch (productID) {
            case BREAD:
                number = 235;
                break;

            case BEER:
                number = 60;
                break;
            case MEAT:
                number = 300;
                break;
            case CHOCOLATE:
                number = 720;
            case HONEY:
                number = 400;
            case CEREALE:
                number = 280;
            case MILK:
                number = 50;
            case SPAGHETI:
                number = 330;

            default:
                number = 100;
        }
        return number;
    }

    public int getConsumedCalories(Person person) {
        int caloriesSum = 0;
        for (Product product : person.getProductList()) {
            caloriesSum += getProductCalories(product.getID()) * product.getQuantity();
        }

        return caloriesSum;
    }
}


