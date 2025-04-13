import java.util.Arrays;
class part2B {

    // --------------- BUBBLE SORT --------------- //

    public static void main(String[] args) {

        int [] num1 = { 3, 5, 6, 9, 8, 7 };
        int[] num2 = { 5, 0, 1, 2, 3, 4, -2 };

        int[] result1 = sort(num1);
        int[] result2 = sort(num2);

        System.out.println("After sorting array becomes: " + Arrays.toString(result1));
        System.out.println("After sorting array becomes: " + Arrays.toString(result2));

    }
    public static int[] sort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    int x = nums[i];
                    nums[i] = nums[j];
                    nums[j] = x;
                }
            }
        }
        return nums;
    }
}
