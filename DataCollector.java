import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataCollector {
  private ArrayList<String> posts;
  private ArrayList<String> targetWords;
  private int postIndex;
  private int targetWordIndex;

  public DataCollector() {
    posts = new ArrayList<String>();
    targetWords = new ArrayList<String>();
    postIndex = 0;
    targetWordIndex = 0;
  }

  public void setData(String postsFileName, String targetWordsFileName) {
    posts.clear();
    targetWords.clear();
    postIndex = 0;
    targetWordIndex = 0;

    try {
      Scanner postsScanner = new Scanner(new File(postsFileName), "UTF-8");
      while (postsScanner.hasNextLine()) {
        posts.add(postsScanner.nextLine().trim());
      }
      postsScanner.close();
    } catch (Exception e) {
      System.out.println("Error reading posts file: " + e);
    }

    try {
      Scanner wordsScanner = new Scanner(new File(targetWordsFileName), "UTF-8");
      while (wordsScanner.hasNextLine()) {
        targetWords.add(wordsScanner.nextLine().trim());
      }
      wordsScanner.close();
    } catch (Exception e) {
      System.out.println("Error reading target words file: " + e);
    }
  }

  public String getNextPost() {
    if (postIndex < posts.size()) {
      postIndex++;
      return posts.get(postIndex - 1);
    }
    return "NONE";
  }

  public String getNextTargetWord() {
    if (targetWordIndex < targetWords.size()) {
      targetWordIndex++;
      return targetWords.get(targetWordIndex - 1);
    }
    targetWordIndex = 0;
    return "NONE";
  }

  public void prepareAdvertisement(String fileName, String usernames, String advertisement) {
    try {
      FileWriter writer = new FileWriter(fileName);
      for (String user : usernames.split(" ")) {
        if (user.trim().length() > 0) {
          writer.write("@" + user + " " + advertisement + "\n");
        }
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Could not write to file: " + e);
    }
  }
}
