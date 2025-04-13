/*
    PROBLEM:
    Write a Java program that simulates a queue using the LinkedList.
    Display the front item and the rear item of the queue.
*/

import java.util.LinkedList;

public class QueueAct {
    public static void main(String[] args) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Queue: " + queue);
        System.out.println("Front item is " + queue.peek());
        System.out.println("Rear item is " + queue.getLast());

    }
}
