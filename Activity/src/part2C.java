import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class part2C {

    // --------------- USING COLLECTIONS CLASS: COLLECTIONS.SORT() AND COLLECTIONS.REVERSE() METHODS --------------- //
    // --------------- COLLECTIONS.SORT() AND COLLECTIONS.REVERSE() METHODS --------------- //

    /*
    PROBLEM:
    Write a program that takes 10 integers from the user,
    Sorts the positive numbers in ascending order and the negative numbers in descending order,
    and then combines the two lists.
    Example output: [0, 2, 4, 5, 8, -1, -2, -3, -6, -7]
    */

    public static void main(String[] args) {

        Scanner u_input = new Scanner(System.in);
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        System.out.println("Please enter 10 integers:");
        for(int i=0;i<10;i++){
            int x = u_input.nextInt();
            if(x>=0){
                positive.add(x);
            } else {
                negative.add(x);
            }
        }

        Collections.sort(positive);
        Collections.sort(negative);
        Collections.reverse(negative);

        positive.addAll(negative);

        System.out.println(positive);

    }
}

