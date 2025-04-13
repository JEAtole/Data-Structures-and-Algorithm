import java.util.Arrays;
public class part2B_2 {
    public static void main(String[] args) {

        // --------------- USING ARRAYS.SORT() METHOD --------------- //

        int[] num1 = {3, 5, 6, 9, 8, 7};
        int[] num2 = {5, 0, 1, 2, 3, 4, -2};

        Arrays.sort(num1);
        Arrays.sort(num2);

        System.out.println("After sorting array becomes: "  + Arrays.toString(num1));
        System.out.println("After sorting array becomes: " + Arrays.toString(num2));

    }
}
