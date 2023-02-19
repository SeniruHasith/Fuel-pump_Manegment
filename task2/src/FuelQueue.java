import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FuelQueue {
    private int fuelStock = 6600;
    private double pump1income = 0;
    private double pump2income = 0;
    private double pump3income = 0;
    private double pump4income = 0;
    private double incomePump5 = 0;

    public void viewAllQueues(ArrayList<Passenger> pump1,
                              ArrayList<Passenger> pump2,
                              ArrayList<Passenger> pump3,
                              ArrayList<Passenger> pump4,
                              ArrayList<Passenger> pump5) {

        System.out.println("-------------------------------------------------------");
        System.out.println("Pump 1");
        //view pump1
        if (pump1.size() == 0) {
            System.out.println("No one in the pump 1 queue");
        } else {
            for (Passenger passenger : pump1) {
                System.out.print(passenger.getFirstName() + " " + passenger.getSecondName() + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("Pump 2");
        if (pump2.size() == 0) {
            System.out.println("No one in the pump 2 queue");
        } else {
            for (Passenger passenger : pump2) {
                System.out.print(passenger.getFirstName() + " " + passenger.getSecondName() + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("Pump 3");
        if (pump3.size() == 0) {
            System.out.println("No one in the pump 3 queue");
        } else {
            for (Passenger passenger : pump3) {
                System.out.print(passenger.getFirstName() + " " + passenger.getSecondName() + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("Pump 4");
        if (pump4.size() == 0) {
            System.out.println("No one in the pump 4 queue");
        } else {
            for (Passenger passenger : pump4) {
                System.out.print(passenger.getFirstName() + " " + passenger.getSecondName() + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("Pump 5");
        if (pump5.size() == 0) {
            System.out.println("No one in the pump 5 queue");
        } else {
            for (Passenger passenger : pump5) {
                System.out.print(passenger.getFirstName() + " " + passenger.getSecondName() + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
    }

    // view empty queue method
    public void emptyQueues(ArrayList<Passenger> pump1,
                            ArrayList<Passenger> pump2,
                            ArrayList<Passenger> pump3,
                            ArrayList<Passenger> pump4,
                            ArrayList<Passenger> pump5) {

        if (pump1.size() == 0) {
            System.out.println("pump 1 is empty");
        }
        if (pump2.size() == 0) {
            System.out.println("pump 2 is empty");
        }
        if (pump3.size() == 0) {
            System.out.println("pump 3 is empty");
        }
        if (pump4.size() == 0) {
            System.out.println("pump 4 is empty");
        }
        if (pump5.size() == 0) {
            System.out.println("pump 5 is empty");
        }
    }

    // add customer method
    public void addCustomer(Passenger person,
                            ArrayList<Passenger> pump1,
                            ArrayList<Passenger> pump2,
                            ArrayList<Passenger> pump3,
                            ArrayList<Passenger> pump4,
                            ArrayList<Passenger> pump5) {

        //checking fuel stock before adding
        if (fuelStock < person.getLitresReq()) {
            System.out.println("Only " + fuelStock + " liters in the stock !!!");
        } else {

            int[] tempArr = new int[5];
            tempArr[0] = pump1.size();
            tempArr[1] = pump2.size();
            tempArr[2] = pump3.size();
            tempArr[3] = pump4.size();
            tempArr[4] = pump5.size();

            int id = 0;

            if (pump1.size() == 6 && pump2.size() == 6 && pump3.size() == 6 && pump4.size() == 6 && pump5.size() == 6) {
                System.out.println("All queues are full!!!");
            } else {
                for (int i = 0; i < 4; i++) {
                    if (tempArr[i] > tempArr[i + 1]) {
                        id = i + 1;
                    }
                }
                if (id == 0) {

                    pump1.add(person);
                    //calculating the income of pump
                    pump1income = person.getLitresReq() * 430 + pump1income;
                    System.out.println("you are in pump 1");
                    // printing the queue index of a person when adding to the queue
                    System.out.println(person.getFirstName() + " added place " + pump1.size() + " in pump 1");
                    // reduce from stock
                    fuelStock -= person.LitresReq;

                } else if (id == 1) {

                    pump2.add(person);
                    //calculating the income of pump
                    pump2income = person.getLitresReq() * 430 + pump2income;
                    System.out.println("you are in pump 2");
                    // printing the queue index of a person when adding to the queue
                    System.out.println(person.getFirstName() + " added place " + pump2.size() + " in pump 2");
                    // reduce from stock
                    fuelStock -= person.LitresReq;

                } else if (id == 2) {

                    pump3.add(person);
                    //calculating the income of pump
                    pump3income = person.getLitresReq() * 430 + pump3income;
                    System.out.println("you are in pump 3");
                    // printing the queue index of a person when adding to the queue
                    System.out.println(person.getFirstName() + " added place " + pump3.size() + " in pump 3");
                    // reduce from stock
                    fuelStock -= person.LitresReq;

                } else if (id == 3) {

                    pump4.add(person);
                    //calculating the income of pump
                    pump4income = person.getLitresReq() * 430 + pump4income;
                    System.out.println("you are in pump 4");
                    // printing the queue index of a person when adding to the queue
                    System.out.println(person.getFirstName() + " added place " + pump4.size() + " in pump 4");
                    // reduce from stock
                    fuelStock -= person.LitresReq;

                } else if (id == 4) {

                    pump5.add(person);
                    //calculating the income of pump
                    incomePump5 = person.getLitresReq() * 430 + incomePump5;
                    System.out.println("you are in pump 5");
                    // printing the queue index of a person when adding to the queue
                    System.out.println(person.getFirstName() + " added place " + pump5.size() + " in pump 5");
                    // reduce from stock
                    fuelStock -= person.LitresReq;

                }
                //warning
                if (fuelStock <= 500) {
                    System.out.println("Warning!!! stock reached 500 litres !!! stock is: " + fuelStock);
                }
            }

        }
    }

    // remove customer from a specific location
    public void removeCustomer(String firstName, String secondName,
                               int pumpNum, int index,
                               ArrayList<Passenger> pump1,
                               ArrayList<Passenger> pump2,
                               ArrayList<Passenger> pump3,
                               ArrayList<Passenger> pump4,
                               ArrayList<Passenger> pump5) {

        if (pumpNum == 1) {
            if (pump1.size() == 0) {
                System.out.println("No customers to remove in pump 1 queue!!!");
            } else {
                if (pump1.get(index).getFirstName().equals(firstName) && pump1.get(index).getSecondName().equals(secondName)) {
                    int litres = pump1.get(index).getLitresReq();
                    fuelStock += litres;
                    pump1income -= pump1income - (pump1.get(index).getLitresReq() * 430);
                    pump1.remove(index);
                    System.out.println(firstName + " removed from queue 1");
                } else {
                    System.out.println("you are not at pump 1 !!");
                }
            }

        } else if (pumpNum == 2) {
            if (pump2.size() == 0) {
                System.out.println("No customers to remove in pump 2 queue!!!");
            } else {
                if (pump2.get(index).getFirstName().equals(firstName) && pump2.get(index).getSecondName().equals(secondName)) {
                    int litres = pump2.get(index).getLitresReq();
                    fuelStock += litres;
                    pump2income -= pump2income - (pump2.get(index).getLitresReq() * 430);
                    pump2.remove(index);
                    System.out.println(firstName + " removed from queue 2");
                } else {
                    System.out.println("you are not at pump 2 !!");
                }
            }

        } else if (pumpNum == 3) {
            if (pump3.size() == 0) {
                System.out.println("No customers to remove in pump 3 queue!!!");
            } else {
                if (pump3.get(index).getFirstName().equals(firstName) && pump3.get(index).getSecondName().equals(secondName)) {
                    int litres = pump3.get(index).getLitresReq();
                    fuelStock += litres;
                    pump3income -= pump3income - (pump3.get(index).getLitresReq() * 430);
                    pump3.remove(index);
                    System.out.println(firstName + " removed from queue 3");
                } else {
                    System.out.println("you are not at pump 3 !!");
                }
            }

        } else if (pumpNum == 4) {
            if (pump4.size() == 0) {
                System.out.println("No customers to remove in pump 4 queue!!!");
            } else {
                if (pump4.get(index).getFirstName().equals(firstName) && pump4.get(index).getSecondName().equals(secondName)) {
                    int litres = pump4.get(index).getLitresReq();
                    fuelStock += litres;
                    pump4income -= pump4income - (pump4.get(index).getLitresReq() * 430);
                    pump4.remove(index);
                    System.out.println(firstName + " removed from queue 4");
                } else {
                    System.out.println("you are not at pump 4 !!");
                }
            }

        } else if (pumpNum == 5) {
            if (pump5.size() == 0) {
                System.out.println("No customers to remove in pump 5 queue!!!");
            } else {
                if (pump5.get(index).getFirstName().equals(firstName) && pump5.get(index).getSecondName().equals(secondName)) {
                    int litres = pump5.get(index).getLitresReq();
                    fuelStock += litres;
                    incomePump5 -= incomePump5 - (pump5.get(index).getLitresReq() * 430);
                    pump5.remove(index);
                    System.out.println(firstName + " removed from queue 5");
                } else {
                    System.out.println("you are not at pump 5 !!");
                }
            }
        }


    }

    // remove served customer
    public void removeServedCustomer(int pumpNum,
                                     ArrayList<Passenger> pump1,
                                     ArrayList<Passenger> pump2,
                                     ArrayList<Passenger> pump3,
                                     ArrayList<Passenger> pump4,
                                     ArrayList<Passenger> pump5) {
        switch (pumpNum) {
            case 1 -> {
                System.out.println(pump1.get(0).getFirstName() + " served  and remove from pump 1");
                pump1.remove(0);
            }
            case 2 -> {
                System.out.println(pump2.get(0).getFirstName() + " served  and remove from pump 2");
                pump2.remove(0);
            }
            case 3 -> {
                System.out.println(pump3.get(0).getFirstName() + " served  and remove from pump 3");
                pump3.remove(0);
            }
            case 4 -> {
                System.out.println(pump4.get(0).getFirstName() + " served  and remove from pump 4");
                pump4.remove(0);
            }
            case 5 -> {
                System.out.println(pump5.get(0).getFirstName() + " served  and remove from pump 5");
                pump5.remove(0);
            }
            default -> System.out.println("enter a valid pump number");
        }
    }

    // sort method
    public void sortNamesASC(ArrayList<Passenger> pump, int pumpNum) {
        //pump1
        String temp;
        String[] tempArray = new String[6];
        for (int i = 0; i < pump.size(); i++) {
            tempArray[i] = pump.get(i).getFirstName() + pump.get(i).getSecondName();
        }

        for (int i = 0; i < pump.size(); i++) {
            for (int j = i + 1; j < pump.size(); j++) {
                // to compare one string with other strings
                if (tempArray[i].compareTo(tempArray[j]) > 0) {
                    // swapping
                    temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;
                }
            }
        }
        System.out.print("Sorted pump  : " + pumpNum);
        for (String s : tempArray) {
            if (s != null) {
                System.out.print(s + ", ");
            }
        }
        System.out.println();
    }

    // remaining fuel stock
    public int remainingFuelStock() {
        return fuelStock;
    }

    //add fuel stock
    public void addFuelStock(int fuelStock) {
        if (fuelStock > 6600 || fuelStock < 0) {
            System.out.println("please enter a valid amount of litres to add!!!");
        } else {
            if (fuelStock + this.fuelStock > 6600) {
                System.out.println("stock limit is 6600 litres !!! cannot add " + fuelStock + " litres!!!");
            } else {
                this.fuelStock += fuelStock;
                System.out.println("current stock is: " + this.fuelStock);
            }
        }
    }

    // income of each fuel queue
    public void incomeEachQueue(int pumpNum) {
        if (pumpNum == 1) {
            System.out.println("income of pump 1: " + pump1income);
        } else if (pumpNum == 2) {
            System.out.println("income of pump 2: " + pump2income);
        } else if (pumpNum == 3) {
            System.out.println("income of pump 3: " + pump3income);
        } else if (pumpNum == 4) {
            System.out.println("income of pump 4: " + pump4income);
        } else if (pumpNum == 5) {
            System.out.println("income of pump 5: " + incomePump5);
        }
    }

    public void storeData(ArrayList<Passenger> pump1,
                          ArrayList<Passenger> pump2,
                          ArrayList<Passenger> pump3,
                          ArrayList<Passenger> pump4,
                          ArrayList<Passenger> pump5) {
        try {
            FileWriter fileWriter = new FileWriter("Filling Station Data.txt");
            System.out.println("data file created!enter 107 to view");

            fileWriter.write("=====================================================\n");
            fileWriter.write("data about the fuel center\n");
            fileWriter.write("=====================================================\n");
            fileWriter.write("Maximum stock in the fuel center: " + 6600 + " litres");
            fileWriter.write("\n");
            fileWriter.write("remaining stock: " + fuelStock);
            fileWriter.write("\n\n");

            fileWriter.write("=====================================================\n");
            fileWriter.write("current ques: \n");
            fileWriter.write("=====================================================\n");
            fileWriter.write("PUMP-1: " + "\n");
            if (pump1.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump1.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("First name " + pump1.get(i).getFirstName() + "\n");
                    fileWriter.write("Second name " + pump1.get(i).getSecondName() + "\n");
                    fileWriter.write("Num of litres " + pump1.get(i).getLitresReq() + "\n");
                    fileWriter.write("Vehicle number " + pump1.get(i).getVehicleNumber() + "\n");
                }
            }
            fileWriter.write("\n");

            fileWriter.write("PUMP-2: " + "\n");
            if (pump2.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump2.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("First name " + pump2.get(i).getFirstName() + "\n");
                    fileWriter.write("Second name " + pump2.get(i).getSecondName() + "\n");
                    fileWriter.write("Num of litres " + pump2.get(i).getLitresReq() + "\n");
                    fileWriter.write("Vehicle number " + pump2.get(i).getVehicleNumber() + "\n");
                }
            }
            fileWriter.write("\n");

            fileWriter.write("PUMP-3: " + "\n");
            if (pump3.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump3.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("First name " + pump3.get(i).getFirstName() + "\n");
                    fileWriter.write("Second name " + pump3.get(i).getSecondName() + "\n");
                    fileWriter.write("Num of litres " + pump3.get(i).getLitresReq() + "\n");
                    fileWriter.write("Vehicle number " + pump3.get(i).getVehicleNumber() + "\n");
                }
            }

            fileWriter.write("\n");

            fileWriter.write("PUMP-4: " + "\n");
            if (pump4.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump4.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("First name " + pump4.get(i).getFirstName() + "\n");
                    fileWriter.write("Second name " + pump4.get(i).getSecondName() + "\n");
                    fileWriter.write("Num of litres " + pump4.get(i).getLitresReq() + "\n");
                    fileWriter.write("Vehicle number " + pump4.get(i).getVehicleNumber() + "\n");
                }
            }

            fileWriter.write("\n");

            fileWriter.write("PUMP-5: " + "\n");
            if (pump5.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump5.size(); i++, j++) {
                    fileWriter.write("customer" + j);
                    fileWriter.write("First name " + pump5.get(i).getFirstName() + "\n");
                    fileWriter.write("Second name " + pump5.get(i).getSecondName() + "\n");
                    fileWriter.write("Num of litres " + pump5.get(i).getLitresReq() + "\n");
                    fileWriter.write("Vehicle number " + pump5.get(i).getVehicleNumber() + "\n");
                }
            }

            fileWriter.write("\n\n");

            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadFile() {
        try {
            File fileName = new File("C:\\Users\\user\\OneDrive\\Desktop\\task2\\Filling Station Data.txt");
            Scanner readData = new Scanner(fileName);
            String fileLine;
            System.out.println("=====================================================");
            System.out.println("Filling Station Data File");
            System.out.println("=====================================================");
            while (readData.hasNextLine()) {
                fileLine = readData.nextLine();
                System.out.println(fileLine);
            }
            readData.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
