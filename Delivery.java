package com.example.trainer;

public class Delivery extends PizzaOrder{
    private double tripRate;
    private int zone; //should be int from 1 to 4

    //main constructor for all fields
    public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate, int zone) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.tripRate = tripRate;
        this.zone = zone;
    }

    public Delivery(double tripRate, int zone) {
        this.tripRate = tripRate;
        this.zone = zone;
    }

    //default constructor
    public Delivery(){
        this(1,1);
    }

    @Override
    public String toString() {

        return   super.toString()+
                "\ntrip rate = " + tripRate +
                "\nzone = " + zone
                +"\norder price = "+ this.calculateOrderPrice();
    }

    @Override
    //calculate price for delivery order
    public double calculateOrderPrice(){
        return (tripRate/100)*super.calculateOrderPrice()*zone + super.calculateOrderPrice();
    }



    //getters and setters for our data fields
    public double getTripRate() {
        return tripRate;
    }

    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }


}

