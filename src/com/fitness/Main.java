package com.fitness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String args[]) {

        FitnessTrackerManger fitnessTrackerManger = new FitnessTrackerManger();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        showMenu();

        while (true) {
            try {
                String input = br.readLine();
                switch (input) {
                    case "1":
                        Person person = fitnessTrackerManger.createPerson(br);
                        fitnessTrackerManger.addPerson(person);
                        showMenu();
                        break;
                    case "2":
                        System.out.print("Persion Name: ");
                        Person foundPersion = fitnessTrackerManger.getPerson(br.readLine());
                        if (foundPersion == null) {
                            System.out.println("Persion doesn't exist");
                        }
                        boolean addProduct = true;
                        while (addProduct) {
                            System.out.println("1.Beer");
                            System.out.println("2.Bread");
                            System.out.println("3.Meat");
                            System.out.println("4.Cereale");
                            System.out.println("5.Spaghetti");
                            System.out.println("6.Milk");
                            System.out.println("7.Chocolate");
                            System.out.println("8.Honey");
                            System.out.println("9.Calculate");
                            int productId = -1;
                            switch (br.readLine()) {
                                case "1":
                                    productId = ConsumedCaloriesManager.BEER;
                                    addProduct(foundPersion, productId, br);
                                    break;
                                case "2":
                                    productId = ConsumedCaloriesManager.BREAD;
                                    addProduct(foundPersion, productId, br);
                                    break;
                                case "3":
                                    productId = ConsumedCaloriesManager.MEAT;
                                    addProduct(foundPersion, productId, br);
                                    break;
                                case "9":
                                    addProduct = false;
                                    break;
                            }

                        }
                        int consumeCalories = fitnessTrackerManger.getConsumedCaloriesManager().getConsumedCalories(foundPersion);
                        System.out.println(" Consumed calories " + consumeCalories);
                        showMenu();
                        break;
                    case "3":
                        System.out.print("Persion Name: ");
                        Person found = fitnessTrackerManger.getPerson(br.readLine());
                        if (found == null) {
                            System.out.println("Persion doesn't exist");
                        }
                        boolean continueToAdd = true;
                        while (continueToAdd) {
                            System.out.println("1.Ridding");
                            System.out.println("2.Running");
                            System.out.println("3.Workout");
                            System.out.println("4.Swimming");
                            System.out.println("5.Walking");

                            System.out.println("6.Calculate");
                            int excersisId = -1;
                            switch (br.readLine()) {
                                case "1":
                                    excersisId = BurnedCaloriesManager.RIDDING;
                                    addExcersis(found, excersisId, br);
                                    break;
                                case "2":
                                    excersisId = BurnedCaloriesManager.RUNNING;
                                    addExcersis(found, excersisId, br);
                                    break;
                                case "3":
                                    excersisId = BurnedCaloriesManager.WORKOUT;
                                    addExcersis(found, excersisId, br);
                                    break;
                                case "6":
                                    continueToAdd = false;
                                    break;
                            }

                        }
                        int burnedCalories = fitnessTrackerManger.getBurnedCaloriesManager().getBurnedCalories(found);
                        System.out.println(" Burned calories " + burnedCalories);
                        showMenu();
                        break;

                    case "4":
                        System.out.print("Person Name: ");
                        Person found1 = fitnessTrackerManger.getPerson(br.readLine());
                        if (found1 == null) {
                            System.out.println("Persion doesn't exist");
                        }
                        System.out.println("Summary " + fitnessTrackerManger.getCaloriesSummary(found1));
                        break;
                    case "5":
                        System.exit(0);
                        break;

                    default:
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    static void addProduct(Person person, int productId, BufferedReader br) {
        System.out.print("Quantity: ");
        int quantity = 0;
        try {
            quantity = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productId, quantity);
        person.addProduct(product);
    }

    static void addExcersis(Person person, int excersisId, BufferedReader br) {
        System.out.print("Quantity: ");
        int quantity = 0;
        try {
            quantity = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Activity activity = new Activity(excersisId, quantity);
        person.addActivity(activity);
    }

    private static void showMenu() {

        System.out.println("\n\n\n");

        System.out.println("1.Profile");
        System.out.println("2.Log nutrition");
        System.out.println("3.Log excercise");
        System.out.println("4.Summary");
        System.out.println("5.Exit");
    }
}