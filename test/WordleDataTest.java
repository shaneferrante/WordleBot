import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordleDataTest {

  @Test
  public void testWordCount() {
    WordleData data = new WordleData();
    assertEquals(2315, data.words.size());
  }

  @Test
  public void testWordLengths() {
    WordleData data = new WordleData();
    for (String word : data.words) {
      assertEquals(5, word.length());
    }
  }

}