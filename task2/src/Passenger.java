public class Passenger {
    String firstName;
    String secondName;
    String vehicleNumber;
    int LitresReq;



    // constructor method
    public Passenger(String firstName, String secondName, String vehicleNumber, int numOfLitresReq) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicleNumber = vehicleNumber;
        this.LitresReq = numOfLitresReq;
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

    public int getLitresReq() {
        return LitresReq;
    }

}
