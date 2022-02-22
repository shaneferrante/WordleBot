import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordleData {

  ArrayList<String> words;

  public WordleData() {
    try {
      File file = new File("C:\\Users\\shane\\CS3500\\WordleBot\\src\\PossibleWords.txt");
      Scanner sc = new Scanner(file);
      String[] w = sc.nextLine().split("\",\"");
      Arrays.sort(w);
      List<String> l = List.of(w);
      words = new ArrayList<String>();
      for (String s : l) {
        words.add(s);
      }
    } catch (FileNotFoundException e) {
      System.out.println("error");
    }
  }

  public WordleData(boolean sorted) {
    try {
      File file = new File("C:\\Users\\shane\\CS3500\\WordleBot\\src\\PossibleWords.txt");
      Scanner sc = new Scanner(file);
      String[] w = sc.nextLine().split("\",\"");
      if (sorted) {
        Arrays.sort(w);
      }
      List<String> l = List.of(w);
      words = new ArrayList<String>();
      for (String s : l) {
        words.add(s);
      }
    } catch (FileNotFoundException e) {
      System.out.println("error");
    }
  }

}