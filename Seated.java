package com.example.trainer;

public class Seated extends PizzaOrder{
    private double serviceCharge;
    private int numberOfPeople;

    public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge, int numberOfPeople) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }

    public Seated(double serviceCharge, int numberOfPeople) {
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nservice charge = " + serviceCharge +
                "\nnumber of people = " + numberOfPeople
                +"\norder price = "+ this.calculateOrderPrice();
    }

    @Override
    //calculate price for seated customers
    public double calculateOrderPrice(){
        return super.calculateOrderPrice()+serviceCharge*numberOfPeople;
    }


    //getters and setters

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
