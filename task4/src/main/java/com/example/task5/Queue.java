package com.example.task5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Queue {
    private int lenOfqueue = 6;
    private int front, end;
    private int numOfElements = 0;
    private Passenger[] waitingQuepassengers = new Passenger[lenOfqueue];

    // initializing
    public Queue() {
        front = 0;
        end = -1;
    }

    //getter

    public int getNumOfElements() {
        return numOfElements;
    }

    //adding to the queue
    public void addWaitingQueue(Passenger addToWaiting) {
        if (numOfElements == 6) {
            System.out.println("waiting queue is also full :( ");
        } else {
            end = (end + 1) % lenOfqueue;
            waitingQuepassengers[end] = addToWaiting;

            //creating db connection
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            Connection con = null;
            try{

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_queue_management_system", "root", "Vinujawedamulla2001");
                Statement stmt = con.createStatement();
                String sql = "INSERT INTO customer (`firstName` , `secondName`, `vehicleNum`, `liter_count`,`pump_num`)"
                        + "VALUES('" + addToWaiting.getFirstName() + "','" + addToWaiting.getSecondName()
                        + "','" + addToWaiting.getVehicleNumber() + "','" + addToWaiting.getNumOfLitresReq() + "','" + 0 + "')";
                stmt.executeUpdate(sql);
                con.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

            numOfElements += 1;
            System.out.println("waiting list: ");
            for(int i=0;i<numOfElements;i++) {
                System.out.print(waitingQuepassengers[i].getFirstName()+" ");
            }
            System.out.println();
        }
    }

    //removing from the queue
    public Passenger removeCustomer() {
        // defining remove customer object
        Passenger removingCustomer = waitingQuepassengers[front];


        // temp array
        Passenger[] tempArray = new Passenger[lenOfqueue];

        for (int i = 0; i < tempArray.length; i++) {
            if (waitingQuepassengers[i] != removingCustomer) {
                tempArray[i] = waitingQuepassengers[i];
            }
        }

        waitingQuepassengers = tempArray;
        front = (front + 1) % lenOfqueue;
        numOfElements -= 1;

        System.out.println("waiting list: ");
        for(int i = front; i< lenOfqueue -1; i++) {
            if (waitingQuepassengers[i]!=null){
                System.out.print(waitingQuepassengers[i].getFirstName()+" ");
            }
        }
        System.out.println();

        // checking weather queue is empty after removing an element
        if (front == end) {
            front = 0;
            end = -1;
        }

        return removingCustomer;
    }


}
