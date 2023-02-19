package com.example.task5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        // creating fuel queue object to access methods
        FuelQueue fq = new FuelQueue();

        ArrayList<Passenger> pump1 = new ArrayList<Passenger>(6);
        ArrayList<Passenger> pump2 = new ArrayList<Passenger>(6);
        ArrayList<Passenger> pump3 = new ArrayList<Passenger>(6);
        ArrayList<Passenger> pump4 = new ArrayList<Passenger>(6);
        ArrayList<Passenger> pump5 = new ArrayList<Passenger>(6);

// menu items
        System.out.println("=====================================================================================");
        System.out.println("welcome to the filling station");
        System.out.println("=====================================================================================");
        System.out.println("""
                100 or VFQ: View all Fuel Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue.(From a specific location)
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining Fuel Stock.
                109 or AFS: Add Fuel Stock.
                110 or IFQ: Income of each fuel queue.
                999 or EXT: Exit the Program.
                """);
        System.out.println("=====================================================================================");


        while(true){

            // select user option
            System.out.print("what do you want to do?: ");
            String userInput = input.next();
            userInput = userInput.toUpperCase();

            switch (userInput) {
                case "100", "VFQ" ->
                    // view method
                        fq.viewAllQueues(pump1, pump2, pump3, pump4, pump5);
                case "101", "VEQ" ->
                    // view empty queue method
                        fq.emptyQueues(pump1, pump2, pump3, pump4, pump5);
                case "102", "ACQ" -> {
                    System.out.print("enter your first name: ");
                    String firstName = input.next();
                    firstName = firstName.toUpperCase();
                    System.out.print("enter your second name: ");
                    String secondName = input.next();
                    secondName = secondName.toUpperCase();
                    System.out.print("enter your vehicle number: ");
                    String vehicleNum = input.next();
                    vehicleNum = vehicleNum.toUpperCase();
                    System.out.print("enter how many litres required: ");
                    int numOfLitresReq = input.nextInt();

                    Passenger person = new Passenger(firstName, secondName, vehicleNum, numOfLitresReq);
                    // add customer queue method
                    fq.addCustomer(person, pump1, pump2, pump3, pump4, pump5);

                    break;
                }
                case "103", "RCQ" -> {
                    // remove a customer from a specific location
                    System.out.print("please enter your first name: ");
                    String firstName = input.next();
                    firstName = firstName.toUpperCase();
                    System.out.print("please enter your second name: ");
                    String secondName = input.next();
                    secondName = secondName.toUpperCase();
                    System.out.print("please enter your pump number: ");
                    int pumpNum = input.nextInt();
                    System.out.print("please enter your place at the queue: ");
                    int index = input.nextInt();
                    index = index - 1;
                    fq.removeCustomerSpecific(firstName, secondName, pumpNum, index, pump1, pump2, pump3, pump4, pump5);

                    break;
                }
                case "104", "PCQ" -> {
                    // remove served customer method
                    System.out.print("enter your pump number: ");
                    int pumpNum = input.nextInt();
                    fq.removeServedCustomer(pumpNum, pump1, pump2, pump3, pump4, pump5);

                    break;
                }
                case "105", "VCS" -> {
                    // sort customer
                    int pumpNum = 1;
                    fq.sortNameASC(pump1, pumpNum);
                    fq.sortNameASC(pump2, pumpNum + 1);
                    fq.sortNameASC(pump3, pumpNum + 2);
                    fq.sortNameASC(pump4, pumpNum + 3);
                    fq.sortNameASC(pump5, pumpNum + 4);

                    break;
                }
                case "108", "STK" ->
                    // remaining fuel stock
                        System.out.println("remaining fuel stock is: " + fq.remainingFuelStock());
                case "109", "AFS" -> {
                    // add fuel stock
                    System.out.print("how many litres, you want to add to the stock? ");
                    int fuelStock = input.nextInt();
                    fq.addFuelStock(fuelStock);
                }
                case "110", "IFQ" -> {
                    // income of each queue
                    System.out.print("enter the pump number to calculate income of the queue: ");
                    int pumpNum = input.nextInt();
                    fq.incomeEachQueue(pumpNum);

                    break;
                }
                case "106", "SPD" ->
                    // store program data
                        fq.storeData(pump1, pump2, pump3, pump4, pump5);
                case "107", "LPD" ->
                    //load file data
                        fq.loadFile();
                case "111", "GUI" ->
                    //Launch application
                        launch();
                case "999", "EXT" -> {
                    //creating db connection
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Connection con = null;
                    try {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_queue_management_system", "root", "SeniruHasith");
                        Statement stmt = con.createStatement();
                        String sql = "DELETE FROM customer";
                        stmt.executeUpdate(sql);
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        }
    }
}