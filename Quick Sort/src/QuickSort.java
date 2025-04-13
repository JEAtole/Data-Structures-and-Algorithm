import java.util.Arrays;
    public class QuickSort {

        public static void quickSort(int[] data) {
            quickSort(data, 0, data.length - 1);
        }

        private static void quickSort(int[] data, int bigIndex, int smallIndex) {
            if (bigIndex < smallIndex) {
                int pivotIndex = partition(data, bigIndex, smallIndex);
                System.out.println("The pivot is in index " + pivotIndex + "(" + data[pivotIndex] + ")\n");
                System.out.println("Sorting left partition");
                if ((pivotIndex-1) == -1){
                    System.out.println("Left partition contains nothing because there are no numbers less than " + data[pivotIndex] + ".\nIt also means that the pivot(" + data[pivotIndex] +") is already in the right place.");
                } else {
                    System.out.println("The pivot is in index " + (pivotIndex - 1) + " : " + data[pivotIndex - 1]);
                }
                quickSort(data, bigIndex, pivotIndex - 1);
                System.out.println("Sorting right partition");
                if ((pivotIndex+1) == data.length){
                    System.out.println("Right partition contains nothing because there are no numbers greater than " + data[pivotIndex] + ".\nIt also means that the pivot(" + data[pivotIndex] + ") is already in the right place.");
                } else {
                    System.out.println("The pivot is in index " + (pivotIndex + 1) + " : " + data[pivotIndex + 1]);
                }
                quickSort(data, pivotIndex + 1, smallIndex);
            } else {
                System.out.println("Partition sorted!\n");
            }
        }

        private static int partition(int[] data, int bigIndex, int smallIndex) {
            int pivot = data[bigIndex];
            int i = bigIndex + 1;
            int j = smallIndex;
            while (i <= j) {
                if (data[i] <= pivot) {
                    i++;
                } else if (data[j] > pivot) {
                    j--;
                } else {
                    swap(data, i, j);
                }
                System.out.println("i = " + i + " and j = " + j);
            }
            swap(data, bigIndex, j);
            return j;
        }

        private static void swap(int[] data, int i, int j) {
            System.out.println("From: " + Arrays.toString(data));
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            System.out.println("Swap index " + i + " and " + j + "\n" + Arrays.toString(data) + "\n");

        }

        public static void main(String[] args) {
            int[] data = {10, 80, 30, 90, 40, 50, 70};

            System.out.println("Before sorting: " + Arrays.toString(data) + "\n");
            System.out.println("The pivot starts at index 0: " + data[0]);
            quickSort(data);
            System.out.println("After sorting: " + Arrays.toString(data));
        }
    }


