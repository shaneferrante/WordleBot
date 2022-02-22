public class WordleBotRunner {

  public static void main(String[] args) {
    playOnce("thorn");
  }

  public static void findWords() {
    WordsFinder wf = new WordsFinder("acdeilmnoprsuty");
  }

  public static void playOnce(String word) {
    WordlePlayer w = new WordlePlayer(word);
    w.playGameDisplay();
  }

  public static void testPlayer() {
    WordleData data = new WordleData();
    int[] counts = new int[10];
    int total = 0;
    for (String s : data.words) {
      WordlePlayer player = new WordlePlayer(s);
      int moves = player.playGame();
      counts[moves]++;
      total++;
      if(total < 10 || (total < 100 && total % 10 ==0) || total % 100 == 0) {
        System.out.println(total + "/" + data.words.size());
      }
    }
    System.out.println("Summary");
    total = 0;
    for (int i = 0; i < 10; i++) {
      if (counts[i] != 0) {
        System.out.println(i + ": " + counts[i] + "/" + data.words.size() + " = " +
                (double)Math.round((double)counts[i]/data.words.size()*1000)/10 + "%");
      }
      total += counts[i]*i;
    }
    System.out.println("Average: " + (double)total/data.words.size());
  }

  public static void getWordOnDay(int day) {
    System.out.println(new WordleData(false).words.get(day+2));
  }

}