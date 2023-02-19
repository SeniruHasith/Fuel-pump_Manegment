import java.util.*;
import java.util.Scanner;

public class Main {

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
        System.out.println("welcome to the Filling station");
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


        label:
        while (true) {

            // select user option
            System.out.print("what do you want to do?: ");
            String userInput = input.next();
            userInput = userInput.toUpperCase();

            switch (userInput) {
                case "100","VFQ":
                    // view method
                    fq.viewAllQueues(pump1, pump2, pump3, pump4, pump5);

                    break;
                case "101","VEQ":
                    // view empty queue method
                    fq.emptyQueues(pump1, pump2, pump3, pump4, pump5);

                    break;
                case "102","ACQ": {
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
                    //validate user inputs

                    int litresRequired = input.nextInt();
                    Passenger person = new Passenger(firstName, secondName, vehicleNum, litresRequired);
                    // add customer queue method
                    fq.addCustomer(person, pump1, pump2, pump3, pump4, pump5);


                    break;
                }
                case "103","RCQ": {
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
                    fq.removeCustomer(firstName, secondName, pumpNum, index, pump1, pump2, pump3, pump4, pump5);

                    break;
                }
                case "104","PCQ": {
                    // remove served customer method
                    System.out.print("enter your pump number: ");
                    int pumpNum = input.nextInt();
                    fq.removeServedCustomer(pumpNum, pump1, pump2, pump3, pump4, pump5);

                    break;
                }
                case "105","VCS": {
                    // sort customer
                    int pumpNum = 1;
                    fq.sortNamesASC(pump1, pumpNum);
                    fq.sortNamesASC(pump2, pumpNum + 1);
                    fq.sortNamesASC(pump3, pumpNum + 2);
                    fq.sortNamesASC(pump4, pumpNum + 3);
                    fq.sortNamesASC(pump5, pumpNum + 4);

                    break;
                }
                case "108","STK":
                    // remaining fuel stock
                    System.out.println("Remaining fuel stock is: " + fq.remainingFuelStock());

                    break;
                case "109","AFS":
                    // add fuel stock
                    System.out.print("how many litres, you want to add to the stock? ");
                    int fuelStock = input.nextInt();
                    fq.addFuelStock(fuelStock);

                    break;
                case "110","IFQ": {
                    // income of each queue
                    System.out.print("enter the pump number to calculate income of the queue: ");
                    int pumpNum = input.nextInt();
                    fq.incomeEachQueue(pumpNum);

                    break;
                }
                case "106","SPD":
                    // store program data
                    fq.storeData(pump1, pump2, pump3, pump4, pump5);

                    break;
                case "107","LPD":
                    //load file data
                    fq.loadFile();
                    break;
                case "999","EXT":
                    break label;
            }
        }
    }
}
