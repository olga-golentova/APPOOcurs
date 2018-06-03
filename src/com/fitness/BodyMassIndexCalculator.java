package com.fitness;

public class BodyMassIndexCalculator implements IBMICalculator{
    private Person person;

    public BodyMassIndexCalculator(Person person) {
        this.person = person;
    }

   public int compute() {
        return (int) (person.getWeight() * 10000/ (person.getHeight() * person.getHeight()));
    }
}
