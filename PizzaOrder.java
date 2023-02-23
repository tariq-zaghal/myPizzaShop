package com.example.trainer;

import java.util.Date;

public  class PizzaOrder implements Comparable<PizzaOrder>{
    //data fields
    private String customerName;
    private Date dateOrdered;
    private int pizzaSize;
    final static int SMALL = 1;
    final static int MEDIUM = 2;
    final static int LARGE = 3;
    private int numberOfToppings;
    private double toppingPrice;

    //a constructor for all the values included
    public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
        this.dateOrdered = new Date();
        this.customerName = customerName;
        this.pizzaSize = pizzaSize;
        this.numberOfToppings = numberOfToppings;
        this.toppingPrice = toppingPrice;
    }

    //default constructor
    public PizzaOrder(){
        this("ahmad",PizzaOrder.SMALL,3,1);
    }

    public double calculateOrderPrice(){
        return numberOfToppings*toppingPrice*pizzaSize;
    }

    @Override
    public int compareTo(PizzaOrder e) {
        if(this.calculateOrderPrice()==e.calculateOrderPrice())
            return 0;
        else if (this.calculateOrderPrice()>e.calculateOrderPrice())
            return -1;
        else
            return 1;
    }

    @Override
    //this toString method includes all the data fields
    public String toString() {

        String sizeSentence = "";
        if(pizzaSize == 1)
            sizeSentence = "pizza size = small";
        else if(pizzaSize == 2)
            sizeSentence = "pizza size = medium";
        else
            sizeSentence = "pizza size = large";
        return
                "\ncustomer name = " + customerName  +
                        "\ndate ordered= " + dateOrdered.toString() +
                        "\n" + sizeSentence +
                        "\nnumber of toppings = " + numberOfToppings +
                        "\ntopping price= " + toppingPrice ;
    }



    //setters and getters for all our private data fields
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(int pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }



}
