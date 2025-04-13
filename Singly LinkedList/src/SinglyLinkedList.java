/*
    PROBLEM:
    Create a program that implements a singly linked list and display the middle element.
    Note: if the list has an even number of nodes, display the second middle node.
*/

public class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public LinkedList() {
            this.head = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void display() {
            Node current = head;

            if (current == null){
                System.out.println("The list is empty");
                return;
            }
            System.out.println("Nodes in the list are: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void displayMiddle(){

            if (head == null) {
                System.out.println("There is no middle because list is empty.");
                return;
            }

            Node current = head;
            int length = 0;

            while (current != null) {
                length++;
                current = current.next;
            }

            int middle = length/2 +1;
            current = head;

            for (int i = 1; i < middle; i++ ){
                current = current.next;
            }

            System.out.println("The middle data is " + current.data);

        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(21);
        list.add(12);
        list.add(35);
        list.add(241);
        list.add(565);
        list.add(654);

        list.display();
        list.displayMiddle();

    }

}
