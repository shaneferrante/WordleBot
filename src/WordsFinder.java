import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WordsFinder {

  List<String> words;

  public WordsFinder(String letters) {
    WordleData data = new WordleData();
    words = data.words;
    try {
      System.out.println(findWords(letters));
    } catch (IllegalStateException e) {
      System.out.println("No words found");
    }
  }

  public String findWords(String letters) {
    String let = letters;
    List<String> l1 = copyArray(words).stream().filter(s -> hasUnique(s)).filter(s -> isValid(s, let)).toList();
    for (String w1 : l1) {
      String Nletters = filterLetters(letters, w1);
      List<String> l2 = copyArray(l1).stream().filter(s -> isValid(s, Nletters)).toList();
      for (String w2 : l2) {
        String N2letters = filterLetters(Nletters, w2);
        List<String> l3 = copyArray(l2).stream().filter(s -> isValid(s, N2letters)).toList();
        for (String w3 : l3) {
          return w1 + "\n" + w2 + "\n" + w3;
        }
      }
    }
    throw new IllegalStateException("No Words Found");
  }

  public String filterLetters(String in, String filter) {
    String ret = "";
    for (int i = 0; i < in.length(); i++) {
      if (!filter.contains(in.charAt(i)+"")) ret += in.charAt(i);
    }
    return ret;
  }

  public List<String> copyArray(List<String> s) {
    List<String> cpy = new ArrayList<>();
    for (String st : s) cpy.add(st);
    return cpy;
  }

  public boolean isValid(String word, String letters) {
    for (int i = 0; i < word.length(); i++) {
      if (!letters.contains(word.charAt(i)+"")) return false;
    }
    return true;
  }

  public boolean hasUnique(String word) {
    for (int i = 0; i < word.length(); i++) {
      for (int j = i+1; j < word.length(); j++) {
        if (word.charAt(i)==word.charAt(j)) return false;
      }
    }
    return true;
  }

}
