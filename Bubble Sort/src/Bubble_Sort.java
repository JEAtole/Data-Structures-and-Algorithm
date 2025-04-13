import java.util.Arrays;
public class Bubble_Sort {

    // --------------- BUBBLE SORT --------------- //

    public static void main(String[] args) {

        int[] array ={20,10,15,54,55,11,78,14};
        System.out.println("Starting Array: " + Arrays.toString(array));

        int flag = 1;
        while(flag==1){
            flag = 0;
            for (int i=0; i < array.length-1; i++){
                if(array[i]>array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = 1;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("Sorted!");
    }
}
