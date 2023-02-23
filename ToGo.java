package com.example.trainer;

public class ToGo extends PizzaOrder{
    public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
    }

    public ToGo() {
    }

    @Override
    public String toString() {
        return super.toString()
                +"\norder price = "+ this.calculateOrderPrice();
    }
}

