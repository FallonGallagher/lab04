import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long startTimeBubble = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      long endTimeBubble = System.nanoTime();
      Lab4.outputList(bubbleSortedList);

      System.out.println("\nTime to complete bubble sort: " + (endTimeBubble - startTimeBubble) + "nanoseconds");

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      long startTimeInsertion = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList); 
      Lab4.outputList(insertionSortedList);
      
      System.out.println("\nTime to complete insertion sort: " + (endTimeInsertion - startTimeInsertion) + "nanoseconds");
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
      int key = integerList.get(i);
      int index = i - 1;

      while (index >= 0 && integerList.get(index) > key) {
          integerList.set(index + 1, integerList.get(index));       
          index--;
        }
        integerList.set(index + 1, key); 
      }
      return integerList;
    }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here

    int n = integerList.size();

    for (int i = 0; i < n - 1; i++){
      for (int j = 0; j < n -1 - i; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {
          int temp = integerList.get(j);          
          integerList.set(j, integerList.get(j + 1));
          integerList.set(j + 1, temp);
        }
      }
    }

    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}