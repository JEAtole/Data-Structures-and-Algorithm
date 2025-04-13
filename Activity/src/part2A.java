public class part2A {
    public static int[] minSubArraySum(int[] nums, int size){

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        int minSum = sum;
        int index_start = 0;

        for (int i = size; i < nums.length; i++) {
            sum += nums[i] - nums[i - size];
            if (sum < minSum) {
                minSum = sum;
                index_start = i - size + 1;
            }
        }
        return new int[]{minSum, index_start};

    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10 } ;
        int size = 4;
        int[] result = minSubArraySum(nums, size);
        System.out.println("\nSub-array size: " + size);
        System.out.print("Sub array from " + result[1] + " to " + (result[1] + size - 1) + " and sum is " + result[0]);
    }
}

