import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class WordleGameTest {

  WordleGame game;

  public WordleGameTest() {
    game = new WordleGame();
  }

  public GuessType[] fromString(String s) {
    GuessType[] gt = new GuessType[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i)=='g') gt[i] = GuessType.Green;
      else if (s.charAt(i) == 'y') gt[i] = GuessType.Yellow;
      else gt[i] = GuessType.Black;
    }
    return gt;
  }

  @Test
  public void testGuessWordSpecific() {
    WordleGame game = new WordleGame();
    testPair("hello", "hello", "ggggg");
    testPair("adieu", "pride", "bygyb");
    testPair("adieu", "eeeee", "bbbgb");
    testPair("adiee", "eeeee", "bbbgg");
    testPair("adiee", "aeaae", "gbbyg");
    testPair("abcba", "cbaab", "ygyyy");
    testPair("abcda", "cbaab", "ygyby");
  }

  public void testPair(String guess, String target, String key) {
    assertEquals(fromString(key), game.guessWordSpecific(guess, target));
  }

  @Test
  public void stressTestGuessWordSpecific() {
    WordleGame game = new WordleGame();
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0L;
    int count = 1;
    while (elapsedTime < 1000) {
      GuessType[] gt = game.guessWordSpecific(game.randomWord(), game.randomWord());
      count++;
      elapsedTime = (new Date()).getTime()-startTime;
    }
    System.out.println("Count: " + count);
    assertTrue(count > 100000);
  }

}