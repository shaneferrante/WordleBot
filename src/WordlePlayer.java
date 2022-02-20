import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class WordlePlayer {

  ArrayList<String> possibleWords;
  int count;
  WordleGame game;
  WordleData data;

  public WordlePlayer() {
    data = new WordleData();
    possibleWords = copyList(data.words);
    game = new WordleGame();
    count = 0;
  }

  public WordlePlayer(String startWord) {
    data = new WordleData();
    possibleWords = copyList(data.words);
    game = new WordleGame(startWord);
    count = 0;
  }

  private ArrayList<String> copyList(ArrayList<String> l) {
    ArrayList<String> cpy = new ArrayList<String>();
    for (String s : l) {
      cpy.add(s);
    }
    return cpy;
  }

  public int playGame() {
    String next = "raise";
    while (!guessWord(next)) {
      next = calculateNextGuess();
      if (possibleWords.size() == 1) {
        next = possibleWords.get(0);
      }
    }
    return count;
  }

  public int playGameDisplay() {
    String next = "raise";
    System.out.println("Guess " + (count+1) + ": " + next);
    while (!guessWord(next)) {
      next = calculateNextGuess();
      if (possibleWords.size() == 1) {
        next = possibleWords.get(0);
      }
      System.out.println("Guess " + (count+1) + ": " + next);
    }
    return count;
  }

  //O(n^3)
  String calculateNextGuess() {
    String bestWord = "";
    double bestAvgWordsLeft = 10000;
    int counted = 0;
    for (String guess : data.words) {
      int wordsLeft = 0;
      for (String target : possibleWords) {
        wordsLeft+= calculateWordsLeft(guess, game.guessWordSpecific(guess, target));
      }
      double avg = (double)wordsLeft/possibleWords.size();
      if (avg < bestAvgWordsLeft) {
        bestAvgWordsLeft = avg;
        bestWord = guess;
      }
      counted++;
      if (counted < 10 || (counted < 100 && counted%10==0) || counted%100==0) {
        //System.out.println(counted + "/" + data.words.size());
      }
    }
    return bestWord;
  }

  //O(n)
  int calculateWordsLeft(String guess, GuessType[] key) {
    int count = 0;
    for (String target : possibleWords) {
      if (isPossible(guess, key, target)) {
        //System.out.println(target);
        count++;
      }
    }
    return count;
  }

  //O(1)
  boolean isPossible(String guess, GuessType[] key, String target) {
    return Arrays.equals(key, game.guessWordSpecific(guess, target));
  }

  boolean guessWord(String guess) {
    GuessType[] key = game.guessWord(guess);
    possibleWords.removeIf(target -> !isPossible(guess, key, target));
    count++;
    for (int i = 0; i < 5; i++) {
      if (key[i] != GuessType.Green) return false;
    }
    return true;

  }

}
