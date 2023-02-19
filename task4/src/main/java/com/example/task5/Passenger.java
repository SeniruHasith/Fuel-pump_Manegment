package com.example.task5;

public class Passenger {
    String firstName;
    String secondName;
    String vehicleNumber;
    int numOfLitresReq;



    // constructor method
    public Passenger(String firstName, String secondName, String vehicleNumber, int numOfLitresReq) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicleNumber = vehicleNumber;
        this.numOfLitresReq = numOfLitresReq;
    }

    public Passenger(String firstName, String secondName, String vehicleNum, int litres, int pumpNum) {
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getNumOfLitresReq() {
        return numOfLitresReq;
    }

}
