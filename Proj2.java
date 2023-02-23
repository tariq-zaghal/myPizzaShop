package com.example.trainer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

public class Proj2 extends Application {

    public void start(Stage stage) throws IOException {
        //this pane includes the main content
        ArrayList<PizzaOrder> orders = new ArrayList<>();
        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(15));
        Label head = new Label("Pizzaria De Birzeit");
        head.setFont(new Font(20));
        mainPane.setTop(head);
        mainPane.setAlignment(head, Pos.CENTER);
        GridPane items = new GridPane();
        items.setHgap(10);
        items.setVgap(20);

        //labels to select elementary fields
        items.add(new Label("Name: "),0,0);
        items.add(new Label("Order Type: "),0,1);
        items.add(new Label("Pizza Size: "),0,2);
        items.add(new Label("Toppings: "),0,3);
        items.add(new Label("Topping Price: "),0,4);
        items.add(new Label("Order Price: "),0,5);

        //name
        TextField nameTf = new TextField("");

        //orders
        ComboBox<String> orderType = new ComboBox<>();
        orderType.getItems().addAll("To-Go","Seated","Delivery");
        orderType.getSelectionModel().select(0);

        //pizza sizes
        ComboBox<String> pizzaSize = new ComboBox<>();
        pizzaSize.getItems().addAll("Small","Medium","Large");
        pizzaSize.getSelectionModel().select(0);

        //Toppings

        CheckBox tp1 = new CheckBox("Olives");
        CheckBox tp2 = new CheckBox("Onions");
        CheckBox tp3 = new CheckBox("Green Peppers");
        CheckBox tp4 = new CheckBox("Salami");
        CheckBox tp5 = new CheckBox("Parmesan");
        CheckBox tp6 = new CheckBox("Pepperoni");

        //arrayList to loop through the toppings and count the checked ones
        ArrayList<CheckBox> toppingsList = new ArrayList<>();
        toppingsList.add(tp1);
        toppingsList.add(tp2);
        toppingsList.add(tp3);
        toppingsList.add(tp4);
        toppingsList.add(tp5);
        toppingsList.add(tp6);
        //----------------------------------------------------------

        //adding topping checkboxes to the grid
        GridPane tpGrid = new GridPane();
        tpGrid.setHgap(10);
        tpGrid.setVgap(10);
        tpGrid.add(tp1,0,0);
        tpGrid.add(tp2,0,1);
        tpGrid.add(tp3,0,2);
        tpGrid.add(tp4,1,0);
        tpGrid.add(tp5,1,1);
        tpGrid.add(tp6,1,2);

        //text field for topping price
        TextField topPriceTf = new TextField("10");

        //text field for order price (output only)
        TextField orderPriceTf = new TextField("0.0");
        orderPriceTf.setEditable(false);

        //items is the grid that takes the main components of the GUI
        items.add(nameTf,1,0);
        items.add(orderType,1,1);
        items.add(pizzaSize,1,2);
        items.add(tpGrid,1,3);
        items.add(topPriceTf,1,4);
        items.add(orderPriceTf,1,5);


        // the panes for delivery order
        GridPane paneDel = new GridPane();
        paneDel.setPadding(new Insets(0,0,15,0));
        paneDel.setVisible(false); //doesn't appear at first

        //labels for the delivery pane
        Label tripRateLbl = new Label("Trip rate: ");
        Label zoneLbl = new Label("Zone: ");

        //text fields for delivery pane
        TextField tripRateTf = new TextField("0.0");
        TextField zoneTf = new TextField("0");


        paneDel.setVgap(10);
        paneDel.setHgap(10);

        //add the delivery pane elements to their grid pane
        paneDel.add(tripRateLbl,0,0);
        paneDel.add(zoneLbl,0,1);
        paneDel.add(tripRateTf,1,0);
        paneDel.add(zoneTf,1,1);

        //pane for seats
        GridPane paneSeated = new GridPane();
        paneSeated.setVisible(false);
        paneSeated.setVgap(10);
        paneSeated.setHgap(10);
        paneSeated.setPadding(new Insets(0,0,15,0));

        Label serviceChrgLbl = new Label("Service Charge: ");
        Label numberOfPeopleLbl = new Label("Number of people: ");
        TextField serviceChrgTf = new TextField("0.0");
        TextField numberOfPeopleTf = new TextField("0");

        paneSeated.add(serviceChrgLbl,0,0);
        paneSeated.add(numberOfPeopleLbl,0,1);
        paneSeated.add(serviceChrgTf,1,0);
        paneSeated.add(numberOfPeopleTf,1,1);





        VBox mainBody = new VBox(20);
        mainBody.getChildren().addAll(items,paneDel,paneSeated);


//adding the main ting
        mainPane.setCenter(mainBody);
        mainBody.setAlignment(Pos.CENTER);


        //the buttons
        Button processOrder = new Button("Process Order");
        Button printOrder = new Button("Print Order");
        Button reset = new Button("Reset");
        Button total = new Button("Total");
        HBox buttomButtons = new HBox(5);
        buttomButtons.getChildren().addAll(processOrder,printOrder,reset,total);

        //--------------------------------------------------------------
                             //EVENT HANDLING

        //button actions


        //Control the visibility of sub-panes
        orderType.setOnAction(e -> {
            if(Objects.equals(orderType.getValue(), "To-Go")){
                paneDel.setVisible(false);
                paneSeated.setVisible(false);

            } else if (Objects.equals(orderType.getValue(), "Delivery")) {
                paneDel.setVisible(true);
                paneSeated.setVisible(false);
            }else if(Objects.equals(orderType.getValue(), "Seated")) {
                paneDel.setVisible(false);
                paneSeated.setVisible(true);
            }
        });


        //this block creates objects for the ordered pizzas
        processOrder.setOnAction(e ->{
            String name = nameTf.getText();
            //get pizza size
            int pizSize;
            if(pizzaSize.getValue().equals("Small"))
                pizSize = 1;
            else if (pizzaSize.getValue().equals("Medium"))
                pizSize = 2;
            else
                pizSize = 3;

            //count number of chosen toppings
            int topCnt = 0;
            for(int i = 0; i<toppingsList.size();i++){
                if(toppingsList.get(i).isSelected())
                    topCnt++;
            }

            //get the price of a single topping
            double tpPrice = Double.parseDouble(topPriceTf.getText());


            //Create object of the corresponding order type:

            if(orderType.getValue().equals("To-Go")){
                ToGo temp = new ToGo(name,pizSize,topCnt,tpPrice);
                orders.add(temp);
                orderPriceTf.setText(temp.calculateOrderPrice()+" ");
            } else if (orderType.getValue().equals("Delivery")) {
                int zone = Integer.parseInt(zoneTf.getText());
                double rate = Double.parseDouble(tripRateTf.getText());
                Delivery temp = new Delivery(name,pizSize,topCnt,tpPrice,rate,zone);
                orders.add(temp);
                orderPriceTf.setText(temp.calculateOrderPrice()+" ");
            }else {
                int pplCnt = Integer.parseInt(numberOfPeopleTf.getText());
                double charge = Double.parseDouble(serviceChrgTf.getText());
                Seated temp = new Seated(name,pizSize,topCnt,tpPrice,charge,pplCnt);
                orders.add(temp);
                orderPriceTf.setText(temp.calculateOrderPrice()+" ");
            }
        });


        //retruns all to default
        reset.setOnAction(e->{
            nameTf.setText("");
            pizzaSize.getSelectionModel().select(0);
            orderType.getSelectionModel().select(0);
            for (int i = 0; i< toppingsList.size();i++){
                toppingsList.get(i).setSelected(false);
            }
            orders.clear();
            topPriceTf.setText("0.0");
            tripRateTf.setText("0.0");
            serviceChrgTf.setText("0.0");
            numberOfPeopleTf.setText("0");
            zoneTf.setText("0");
            orderPriceTf.setText("0.0");
            paneDel.setVisible(false);
            paneSeated.setVisible(false);

        });


        //creates a purchases report on a new stage
        printOrder.setOnAction(e->{
            Stage secStage = new Stage();
            StackPane stackPane = new StackPane();
            TextArea text = new TextArea();
            Collections.sort(orders);
            String out = "";
            for(int i = 0;i<orders.size();i++){
                out+="name: "+orders.get(i).getCustomerName()+"\ntotal: "+orders.get(i).calculateOrderPrice()+" NIS"+"\n\n\n";
            }
            text.setText(out);
            text.setEditable(false);
            stackPane.getChildren().add(text);
            stackPane.setAlignment(Pos.CENTER);
            stackPane.setPadding(new Insets(10));
            Scene scene2 = new Scene(stackPane,400,400);
            secStage.setScene(scene2);
            secStage.setTitle("Purchases Report");
            secStage.show();
        });



        total.setOnAction(e->{
            double tot = 0;
            for(int i =0;i<orders.size();i++){
                tot+=orders.get(i).calculateOrderPrice();
            }

            System.out.println(tot);
        });

        //---------------------------------------------------------------------------------

        mainPane.setBottom(buttomButtons);
        buttomButtons.setAlignment(Pos.CENTER);

        //scroll pane in order to guarantee no issues would happen in pane sizing
        ScrollPane sc = new ScrollPane();
        sc.setContent(mainPane);


        BorderPane root = new BorderPane();
        root.setCenter(sc);
        root.setPadding(new Insets(15));


        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);

        stage.setTitle("Pizzaria De Birzeit");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
