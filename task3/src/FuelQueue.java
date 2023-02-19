import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FuelQueue{

    Queue queueObject = new Queue();
    private int stockLitres = 6600;
    private int incomePump1 = 0;
    private int incomePump2 = 0;
    private int incomePump3 = 0;
    private int incomePump4 = 0;
    private int incomePump5 = 0;

    public void viewAllQueues(ArrayList<Passenger> pump1,
                              ArrayList<Passenger> pump2,
                              ArrayList<Passenger> pump3,
                              ArrayList<Passenger> pump4,
                              ArrayList<Passenger> pump5) {

        //view pump1
        if (pump1.size() == 0) {
            System.out.println("no one in the pump 1");
        } else {
            System.out.print("pump1: ");
            for (int i = 0; i < pump1.size(); i++) {
                System.out.print(pump1.get(i).getFirstName() + " " + pump1.get(i).getSecondName() + ", ");
            }
            System.out.println();
        }

        if (pump2.size() == 0) {
            System.out.println("no one in the pump 2");
        } else {
            System.out.print("pump 2: ");
            for (int i = 0; i < pump2.size(); i++) {
                System.out.print(pump2.get(i).getFirstName() + " " + pump2.get(i).getSecondName() + ", ");
            }
            System.out.println();
        }

        if (pump3.size() == 0) {
            System.out.println("no one in the pump 3");
        } else {
            System.out.print("pump 3: ");
            for (int i = 0; i < pump3.size(); i++) {
                System.out.print(pump3.get(i).getFirstName() + " " + pump3.get(i).getSecondName() + ", ");
            }
            System.out.println();
        }

        if (pump4.size() == 0) {
            System.out.println("no one in the pump 4");
        } else {
            System.out.print("pump 4: ");
            for (int i = 0; i < pump4.size(); i++) {
                System.out.print(pump4.get(i).getFirstName() + " " + pump4.get(i).getSecondName() + ", ");
            }
            System.out.println();
        }

        if (pump5.size() == 0) {
            System.out.println("no one in the pump 5");
        } else {
            System.out.print("pump 5: ");
            for (int i = 0; i < pump5.size(); i++) {
                System.out.print(pump5.get(i).getFirstName() + " " + pump5.get(i).getSecondName() + ", ");
            }
            System.out.println();
        }

    }

    // view empty queue method
    public void emptyQueues(ArrayList<Passenger> pump1,
                            ArrayList<Passenger> pump2,
                            ArrayList<Passenger> pump3,
                            ArrayList<Passenger> pump4,
                            ArrayList<Passenger> pump5) {

        if (pump1.size()>0 && pump2.size()>0 && pump3.size()>0 && pump4.size()>0 && pump5.size()>0){
            System.out.println("No empty queues!!!");
        }
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
    public void addCustomer(Passenger object,
                            ArrayList<Passenger> pump1,
                            ArrayList<Passenger> pump2,
                            ArrayList<Passenger> pump3,
                            ArrayList<Passenger> pump4,
                            ArrayList<Passenger> pump5) {

        if (stockLitres < object.getLitresReq() ){
            System.out.println("we have only "+stockLitres+" in the stock !!!");
        }else {

            int[] lengthArrays = new int[5];
            lengthArrays[0] = pump1.size();
            lengthArrays[1] = pump2.size();
            lengthArrays[2] = pump3.size();
            lengthArrays[3] = pump4.size();
            lengthArrays[4] = pump5.size();

            int minIndex = 0;

            if (pump1.size() == 6 && pump2.size() == 6 && pump3.size() == 6 && pump4.size() == 6 && pump5.size() == 6) {
                System.out.println("All queues are full!!! you will be added to the waiting queue !!!");
                queueObject.addWaitingQueue(object);
            } else {
                for (int i = 0; i < 4; i++) {
                    if (lengthArrays[i] > lengthArrays[i + 1]) {
                        minIndex = i + 1;
                    }
                }
                // add customer
                if (minIndex == 0) {

                    pump1.add(object);
                    //calculating the income
                    incomePump1 = object.getLitresReq() * 430 + incomePump1;
                    System.out.println("you are in pump 1");
                    // printing the queue index of a person when adding to the queue
                    System.out.println("you are at " + pump1.size()+ " ");
                    // reduce from stock
                    stockLitres -= object.LitresReq;

                } else if (minIndex == 1) {

                    pump2.add(object);
                    //calculating the income
                    incomePump2 = object.getLitresReq() * 430 + incomePump2;
                    System.out.println("you are in pump 2");
                    // printing the queue index of a person when adding to the queue
                    System.out.println("you are at " + pump2.size()  + " ");
                    // reduce from stock
                    stockLitres -= object.LitresReq;

                } else if (minIndex == 2) {

                    pump3.add(object);
                    //calculating the income
                    incomePump3 = object.getLitresReq() * 430 + incomePump3;
                    System.out.println("you are in pump 3");
                    // printing the queue index of a person when adding to the queue
                    System.out.println("you are at " + pump3.size() + " ");
                    // reduce from stock
                    stockLitres -= object.LitresReq;

                } else if (minIndex == 3) {

                    pump4.add(object);
                    //calculating the income
                    incomePump4 = object.getLitresReq() * 430 + incomePump4;
                    System.out.println("you are in pump 4");
                    // printing the queue index of a person when adding to the queue
                    System.out.println("you are at " + pump4.size() + " ");
                    // reduce from stock
                    stockLitres -= object.LitresReq;

                } else if (minIndex == 4) {

                    pump5.add(object);
                    //calculating the income
                    incomePump5 = object.getLitresReq() * 430 + incomePump5;

                    System.out.println("you are in pump 5");
                    // printing the queue index of a person when adding to the queue
                    System.out.println("you are at " + pump5.size() + " ");
                    // reduce from stock
                    stockLitres -= object.LitresReq;

                }
            }
        }

        //warning
        if (stockLitres<=500){
            System.out.println("Warning stock reached to 500 litres !!!");
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
                System.out.println("no one at pump 1, please check again!!!");
            } else {
                if (pump1.get(index).getFirstName().equals(firstName) && pump1.get(index).getSecondName().equals(secondName)) {
                    int litres = pump1.get(index).getLitresReq();
                    stockLitres += litres;
                    incomePump1 -= incomePump1 - (pump1.get(index).getLitresReq() * 430);
                    pump1.remove(index);
                    System.out.println(firstName + " removed from queue 1");
                } else {
                    System.out.println("you are not at pump 1 !!");
                }
            }

        } else if (pumpNum == 2) {
            if (pump2.size() == 0) {
                System.out.println("no one at pump 2, please check again!!!");
            } else {
                if (pump2.get(index).getFirstName().equals(firstName) && pump2.get(index).getSecondName().equals(secondName)) {
                    int litres = pump2.get(index).getLitresReq();
                    stockLitres += litres;
                    incomePump2 -= incomePump2 - (pump2.get(index).getLitresReq() * 430);
                    pump2.remove(index);
                    System.out.println(firstName + " removed from queue 2");
                } else {
                    System.out.println("you are not at pump 2 !!");
                }
            }

        } else if (pumpNum == 3) {
            if (pump3.size() == 0) {
                System.out.println("no one at pump 3, please check again!!!");
            } else {
                if (pump3.get(index).getFirstName().equals(firstName) && pump3.get(index).getSecondName().equals(secondName)) {
                    int litres = pump3.get(index).getLitresReq();
                    stockLitres += litres;
                    incomePump3 -= incomePump3 - (pump3.get(index).getLitresReq() * 430);
                    pump3.remove(index);
                    System.out.println(firstName + " removed from queue 3");
                } else {
                    System.out.println("you are not at pump 3 !!");
                }
            }

        } else if (pumpNum == 4) {
            if (pump4.size() == 0) {
                System.out.println("no one at pump 4, please check again!!!");
            } else {
                if (pump4.get(index).getFirstName().equals(firstName) && pump4.get(index).getSecondName().equals(secondName)) {
                    int litres = pump4.get(index).getLitresReq();
                    stockLitres += litres;
                    incomePump4 -= incomePump4 - (pump4.get(index).getLitresReq() * 430);
                    pump4.remove(index);
                    System.out.println(firstName + " removed from queue 4");
                } else {
                    System.out.println("you are not at pump 4 !!");
                }
            }

        } else if (pumpNum == 5) {
            if (pump5.size() == 0) {
                System.out.println("no one at pump 5, please check again!!!");
            } else {
                if (pump5.get(index).getFirstName().equals(firstName) && pump5.get(index).getSecondName().equals(secondName)) {
                    int litres = pump5.get(index).getLitresReq();
                    stockLitres += litres;
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


        if (pumpNum == 1) {

            System.out.println(pump1.get(0).getFirstName()+" removed as a served customer from pump 1");
            pump1.remove(0);


            // checking weather waiting queue is empty or not
            if (queueObject.getNumOfElements() > 0){
                // get removing passenger object to a variable
                Passenger removedCustomer = queueObject.removeCustomer();
                // adding to the queue pump
                pump1.add(removedCustomer);
                System.out.println(removedCustomer.getFirstName()+" "+removedCustomer.getSecondName()+
                        " has been successfully removed from waiting queue and added to the pump 1 queue !!!");
            }

        } else if (pumpNum == 2) {

            System.out.println(pump2.get(0).getFirstName()+" removed as a served customer pump 2");
            pump2.remove(0);


            // checking weather waiting queue is empty or not
            if (queueObject.getNumOfElements() != 0){
                // get removing passenger object to a variable
                Passenger removedCustomer = queueObject.removeCustomer();
                // adding to the queue pump
                pump2.add(removedCustomer);
                System.out.println(removedCustomer.getFirstName()+" "+removedCustomer.getSecondName()+
                        " has been successfully removed from waiting queue and added to the pump 2 queue !!!");
            }

        } else if (pumpNum == 3) {

            System.out.println(pump3.get(0).getFirstName()+" removed as a served customer pump 3");
            pump3.remove(0);


            // checking weather waiting queue is empty or not
            if (queueObject.getNumOfElements() != 0){
                // get removing passenger object to a variable
                Passenger removedCustomer = queueObject.removeCustomer();
                // adding to the queue pump
                pump3.add(removedCustomer);
                System.out.println(removedCustomer.getFirstName()+" "+removedCustomer.getSecondName()+
                        " has been successfully removed from waiting queue and added to the pump 3 queue !!!");
            }

        } else if (pumpNum == 4) {

            System.out.println(pump4.get(0).getFirstName()+" removed as a served customer pump 4");
            pump4.remove(0);


            // checking weather waiting queue is empty or not
            if (queueObject.getNumOfElements() != 0){
                // get removing passenger object to a variable
                Passenger removedCustomer = queueObject.removeCustomer();
                // adding to the queue pump
                pump4.add(removedCustomer);
                System.out.println(removedCustomer.getFirstName()+" "+removedCustomer.getSecondName()+
                        " has been successfully removed from waiting queue and added to the pump 4 queue !!!");
            }

        } else if (pumpNum == 5) {

            System.out.println(pump5.get(0).getFirstName()+" removed as a served customer pump 5");
            pump5.remove(0);


            // checking weather waiting queue is empty or not
            if (queueObject.getNumOfElements() != 0){
                // get removing passenger object to a variable
                Passenger removedCustomer = queueObject.removeCustomer();
                // adding to the queue pump
                pump5.add(removedCustomer);
                System.out.println(removedCustomer.getFirstName()+" "+removedCustomer.getSecondName()+
                        " has been successfully removed from waiting queue and added to the pump 5 queue !!!");
            }

        } else {
            System.out.println("enter a valid pump number");
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
        System.out.print("sorted pump "+pumpNum);
        for (String s : tempArray) {
            if (s != null) {
                System.out.print(s + ", ");
            }
        }
        System.out.println();
    }

    // remaining fuel stock
    public int remainingFuelStock() {
        return stockLitres;
    }

    //add fuel stock
    public void addFuelStock(int fuelStock) {
        if (fuelStock > 6600 || fuelStock < 0) {
            System.out.println("please enter a valid amount of litres to add!!!");
        } else {
            if (fuelStock + stockLitres > 6600) {
                System.out.println("stock limit is 6600 litres !!! cannot add "+fuelStock+" litres!!!");
            } else {
                stockLitres += fuelStock;
                System.out.println("current stock is: " + stockLitres);
            }
        }
    }

    // income of each fuel queue
    public void incomeEachQueue(int pumpNum) {
        if (pumpNum == 1) {
            System.out.println("income of pump 1: " + incomePump1);
        } else if (pumpNum == 2) {
            System.out.println("income of pump 2: " + incomePump2);
        } else if (pumpNum == 3) {
            System.out.println("income of pump 3: " + incomePump3);
        } else if (pumpNum == 4) {
            System.out.println("income of pump 4: " + incomePump4);
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
            FileWriter fileWriter = new FileWriter("storeData.txt");
            System.out.println("file successfully created!");

            fileWriter.write("=====================================================\n");
            fileWriter.write("data about the fuel center\n");
            fileWriter.write("=====================================================\n");
            fileWriter.write("Maximum stock in the fuel center: " + 6600 + " litres");
            fileWriter.write("\n");
            fileWriter.write("remaining stock: " + stockLitres);
            fileWriter.write("\n\n");

            fileWriter.write("=====================================================\n");
            fileWriter.write("current ques: \n");
            fileWriter.write("=====================================================\n");
            fileWriter.write("pump1: " + "\n");
            if (pump1.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump1.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("first name " + pump1.get(i).getFirstName() + "\n");
                    fileWriter.write("second name " + pump1.get(i).getSecondName() + "\n");
                    fileWriter.write("num of litres " + pump1.get(i).getLitresReq() + "\n");
                    fileWriter.write("vehicle number " + pump1.get(i).getVehicleNumber() + "\n");
                }
            }
            fileWriter.write("\n");

            fileWriter.write("pump2: " + "\n");
            if (pump2.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump2.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("first name " + pump2.get(i).getFirstName() + "\n");
                    fileWriter.write("second name " + pump2.get(i).getSecondName() + "\n");
                    fileWriter.write("num of litres " + pump2.get(i).getLitresReq() + "\n");
                    fileWriter.write("vehicle number " + pump2.get(i).getVehicleNumber() + "\n");
                }
            }
            fileWriter.write("\n");

            fileWriter.write("pump3: " + "\n");
            if (pump3.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump3.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("first name " + pump3.get(i).getFirstName() + "\n");
                    fileWriter.write("second name " + pump3.get(i).getSecondName() + "\n");
                    fileWriter.write("num of litres " + pump3.get(i).getLitresReq() + "\n");
                    fileWriter.write("vehicle number " + pump3.get(i).getVehicleNumber() + "\n");
                }
            }

            fileWriter.write("\n");

            fileWriter.write("pump4: " + "\n");
            if (pump4.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump4.size(); i++, j++) {
                    fileWriter.write("customer" + j + "\n");
                    fileWriter.write("first name " + pump4.get(i).getFirstName() + "\n");
                    fileWriter.write("second name " + pump4.get(i).getSecondName() + "\n");
                    fileWriter.write("num of litres " + pump4.get(i).getLitresReq() + "\n");
                    fileWriter.write("vehicle number " + pump4.get(i).getVehicleNumber() + "\n");
                }
            }

            fileWriter.write("\n");

            fileWriter.write("pump5: " + "\n");
            if (pump5.size() == 0) {
                fileWriter.write("empty que");
            } else {
                for (int i = 0, j = 1; i < pump5.size(); i++, j++) {
                    fileWriter.write("customer" + j);
                    fileWriter.write("first name " + pump5.get(i).getFirstName() + "\n");
                    fileWriter.write("second name " + pump5.get(i).getSecondName() + "\n");
                    fileWriter.write("num of litres " + pump5.get(i).getLitresReq() + "\n");
                    fileWriter.write("vehicle number " + pump5.get(i).getVehicleNumber() + "\n");
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
            File fileName = new File("storeData.txt");
            Scanner readData = new Scanner(fileName);
            String fileLine;
            System.out.println("=====================================================");
            System.out.println("Data from the file");
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
