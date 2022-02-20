import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class WordlePlayerTest {

  @Test
  public void stressTestIsPossible() {
    WordlePlayer player = new WordlePlayer();
    WordleGame game = new WordleGame();
    GuessType[] gt = {GuessType.Black, GuessType.Yellow, GuessType.Green, GuessType.Yellow, GuessType.Black};
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0L;
    int count = 1;
    while (elapsedTime < 1000) {
      boolean b = player.isPossible(game.randomWord(), gt, game.randomWord());
      count++;
      elapsedTime = (new Date()).getTime()-startTime;
    }
    System.out.println("Count: " + count);
    assertTrue(count > 1000000);
  }

  @Test
  public void stressTestCalculateWordsLeft() {
    WordlePlayer player = new WordlePlayer();
    WordleGame game = new WordleGame();
    GuessType[] gt = {GuessType.Black, GuessType.Yellow, GuessType.Green, GuessType.Yellow, GuessType.Black};
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0L;
    int count = 1;
    while (elapsedTime < 1000) {
      int i = player.calculateWordsLeft(game.randomWord(), gt);
      count++;
      elapsedTime = (new Date()).getTime()-startTime;
    }
    System.out.println("Count: " + count);
    assertTrue(count > 1000);
  }

  @Test
  public void testCalculateWordsLeft() {
    WordlePlayer player = new WordlePlayer();
    GuessType[] gt = {GuessType.Black, GuessType.Green, GuessType.Green, GuessType.Green, GuessType.Green};
    assertEquals(8, player.calculateWordsLeft("light", gt));
  }

  @Test
  public void testIsPossible() {
    WordleGame game = new WordleGame();
    WordlePlayer player = new WordlePlayer();
    GuessType[] gt = {GuessType.Green, GuessType.Green, GuessType.Green, GuessType.Green, GuessType.Green};
    assertTrue(player.isPossible("hello", gt, "hello"));
    assertFalse(player.isPossible("hello", gt, "cello"));
    GuessType[] gt2 = {GuessType.Black, GuessType.Yellow, GuessType.Green, GuessType.Yellow, GuessType.Black};
    assertFalse(player.isPossible("adieu", gt2, "prido"));
    assertTrue(player.isPossible("adieu", gt2, "pride"));
  }

}