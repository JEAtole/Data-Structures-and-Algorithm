import java.util.Arrays;
import java.util.Scanner;

public class SortingProgram {

    // --------------- BUBBLE SORT --------------- //

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Step " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    // --------------- SELECTION SORT --------------- //

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            System.out.println("Step " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    // --------------- INSERTION SORT --------------- //

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            System.out.println("Step " + i + ": " + Arrays.toString(arr));
        }
    }

    // --------------- MERGE SORT --------------- //

    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }

        System.out.println("Merging: " + Arrays.toString(arr));
    }

    // --------------- QUICK SORT --------------- //

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }

    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            System.out.println(Arrays.toString(array));
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // Accept a set of numbers
            System.out.print("Enter a set of numbers (comma separated): ");
            String input = scanner.nextLine();
            String[] inputStr = input.split(",");
            int[] numbers = new int[inputStr.length];

            for (int i = 0; i < inputStr.length; i++) {
                numbers[i] = Integer.parseInt(inputStr[i].trim());
            }

            // Ask for sorting method
            System.out.println("Choose a sorting method:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");

            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Sorting:");
            switch (choice) {
                case 1 -> bubbleSort(numbers);
                case 2 -> selectionSort(numbers);
                case 3 -> insertionSort(numbers);
                case 4 -> mergeSort(numbers);
                case 5 -> quickSort(numbers);
                default -> {
                    System.out.println("Invalid choice");
                    continue;
                }
            }

            // Print the final sorted output
            System.out.println("-------------------------");
            System.out.println("Sorted: " + Arrays.toString(numbers));
            System.out.println("-------------------------");

            // Ask if the user wants to reset
            System.out.print("Do you want to try again? (yes/no): ");
            String resetChoice = scanner.nextLine();

            if (!resetChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();

    }

}
