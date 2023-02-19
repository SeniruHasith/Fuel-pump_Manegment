public class Queue {
    private int lenOfQueue = 6;
    private int front, rename;
    private int numOfElements = 0;
    private Passenger[] waitingQuepassengers = new Passenger[lenOfQueue];

    // initializing
    public Queue() {
        front = 0;
        rename = -1;
    }

    //getter

    public int getNumOfElements() {
        return numOfElements;
    }

    //adding to the queue
    public void addWaitingQueue(Passenger addToWaiting) {
        if (numOfElements == 6) {
            System.out.println("Sorry!Waiting queue also full now");
        } else {
            rename = (rename + 1) % lenOfQueue;
            waitingQuepassengers[rename] = addToWaiting;
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
        Passenger[] tempArray = new Passenger[lenOfQueue];

        for (int i = 0; i < tempArray.length; i++) {
            if (waitingQuepassengers[i] != removingCustomer) {
                tempArray[i] = waitingQuepassengers[i];
            }
        }

        waitingQuepassengers = tempArray;
        front = (front + 1) % lenOfQueue;
        numOfElements -= 1;

        System.out.println("waiting queue: ");
        for(int i=front;i<numOfElements;i++) {
            System.out.print(waitingQuepassengers[i].getFirstName()+" ");
        }
        System.out.println();

        // checking weather queue is empty after removing an element
        if (front == rename) {
            front = 0;
            rename = -1;
        }

        return removingCustomer;
    }


}
