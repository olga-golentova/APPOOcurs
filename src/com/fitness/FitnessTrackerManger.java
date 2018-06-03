package com.fitness;

import com.fitness.BurnedCaloriesManager;
import com.fitness.FitnessReminder;
import com.fitness.Training;
import com.fitness.ConsumedCaloriesManager;
import com.fitness.Person;
import com.fitness.BodyMassIndexCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FitnessTrackerManger {
    private List<Person> personList;
    private ConsumedCaloriesManager consumedCaloriesManager;
    private BurnedCaloriesManager burnedCaloriesManager;
    private FitnessReminder fitnessReminder;

    public FitnessTrackerManger() {
        this.personList = new ArrayList<Person>();
        this.consumedCaloriesManager = new ConsumedCaloriesManager();
        this.burnedCaloriesManager = new BurnedCaloriesManager();
        this.fitnessReminder = new FitnessReminder();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public BurnedCaloriesManager getBurnedCaloriesManager() {
        return burnedCaloriesManager;
    }

    public ConsumedCaloriesManager getConsumedCaloriesManager() {
        return consumedCaloriesManager;
    }

    public int calculateBodyMassIndex(Person person) {
        BodyMassIndexCalculator bodyMassIndexCalculator = new BodyMassIndexCalculator(person);
        return bodyMassIndexCalculator.compute();
    }

    public void addTraining(Training training) {
        fitnessReminder.addTraining(training);
    }


    public Person createPerson(BufferedReader br) throws IOException {
        Person person = new Person();

        System.out.print("Name: ");
        person.setName(br.readLine());

        System.out.print("Age: ");
        person.setAge(Integer.parseInt(br.readLine()));

        System.out.print("Height: ");
        person.setHeight(Integer.parseInt(br.readLine()));

        System.out.print("Weight: ");
        person.setWeight(Integer.parseInt(br.readLine()));

        System.out.print("Do you want to calculate your BMI: ");

        if(br.readLine().equalsIgnoreCase("yes")) {
            System.out.println("BMI: " + calculateBodyMassIndex(person));
        }

        return person;

    }

    public Person getPerson(String name) {
        for (Person person :
                personList) {
            if (name.equalsIgnoreCase(person.getName())) {
                return person;
            }
            return null;
        }
        return null;
    }

    int getCaloriesSummary(Person person) {
        return getConsumedCaloriesManager().getConsumedCalories(person) - getBurnedCaloriesManager().getBurnedCalories(person);
    }
}
