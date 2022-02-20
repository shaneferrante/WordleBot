public class WordleGame {

  WordleData data;
  String target;

  public WordleGame() {
    data = new WordleData();
    target = randomWord();
  }

  public WordleGame(String word) {
    target = word;
    data = new WordleData();
  }

  public String randomWord() {
    int index = (int)(Math.random()*data.words.size());
    return data.words.get(index);
  }

  //Not correct doesn't account for double letters
  public GuessType[] guessWordSpecific(String guess, String target) {
    GuessType[] answer = new GuessType[5];
    for (int i = 0; i < 5; i++) {
      answer[i] = GuessType.Black;
      if (guess.charAt(i) == target.charAt(i)) answer[i] = GuessType.Green;
    }
    for (int i = 0; i < 5; i++) {
      if (answer[i] != GuessType.Green) {
        for (int j = 0; j < 5; j++) {
          if (answer[i] == GuessType.Black && target.charAt(j) == guess.charAt(i)) {
            answer[i] = GuessType.Yellow;
          }
        }
      }
    }
    return answer;
  }

  public GuessType[] guessWord(String guess) {
    return guessWordSpecific(guess, target);
  }

}
