import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(
                new FileReader("src/Names.txt"));

        ArrayList<String> nameList = new ArrayList<>();

        while (scanner.hasNext()){
            String name = scanner.nextLine();
            nameList.add(name);
        }

        insertionSort(nameList);

        System.out.println("Sorted List: ");
        for (String name: nameList){
            System.out.println(name);
        }

    }

    public static void insertionSort(ArrayList<String> nameList) {
        for (int i = 1; i < nameList.size(); i++) {
            String key = nameList.get(i);
            int j = i - 1;
            while (j >= 0 && nameList.get(j).compareToIgnoreCase(key) > 0) {
                nameList.set(j+1,nameList.get(j));
                j--;
            }
            nameList.set(j+1,key);
        }
    }
}
