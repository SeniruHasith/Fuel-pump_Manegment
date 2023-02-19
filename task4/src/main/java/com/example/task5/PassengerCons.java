package com.example.task5;

public class PassengerCons {
    String firstName;
    String secondName;
    String vehicleNumber;
    int numOfLitresReq;
    int pumpNum;



    // constructor method
    public PassengerCons(String firstName, String secondName, String vehicleNumber, int numOfLitresReq, int pumpNum) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicleNumber = vehicleNumber;
        this.numOfLitresReq = numOfLitresReq;
        this.pumpNum = pumpNum;
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

    public int getPumpNum(){
        return pumpNum;
    }

}
