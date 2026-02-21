public class TargetedAd {

  public static void main(String[] args) {
    String postsFileName = "socialMediaPosts.txt";
    String targetWordsFileName = "targetWords.txt";

    DataCollector collector = new DataCollector();
    collector.setData(postsFileName, targetWordsFileName);

    String peopleToTarget = "";

    String postLine = collector.getNextPost();
    while (!postLine.equals("NONE")) {
      postLine = postLine.trim();
      if (postLine.length() == 0) {
        postLine = collector.getNextPost();
        continue;
      }

      int firstSpace = postLine.indexOf(' ');
      if (firstSpace < 0) {
        postLine = collector.getNextPost();
        continue;
      }

      String username = postLine.substring(0, firstSpace).trim();
      String postText = postLine.substring(firstSpace + 1).trim();

      String cleanPost = cleanUp(postText);

      boolean matched = false;

      String targetWord = collector.getNextTargetWord();
      while (!targetWord.equals("NONE")) {
        String cleanWord = targetWord.trim().toLowerCase();
        if (cleanWord.length() > 0) {
          cleanWord = cleanWord.replaceAll("[^a-z0-9-]+", "");
          if (cleanWord.length() > 0 && cleanPost.indexOf(" " + cleanWord + " ") >= 0) {
            matched = true;
          }
        }
        targetWord = collector.getNextTargetWord();
      }

      if (matched) {
        String alreadyAddedCheck = " " + peopleToTarget + " ";
        if (alreadyAddedCheck.indexOf(" " + username + " ") < 0) {
          peopleToTarget += username + " ";
        }
      }

      postLine = collector.getNextPost();
    }

    peopleToTarget = peopleToTarget.trim();

    String adMessage = "Love gorillas? Get primate-safe enrichment toys, treats, and habitat tips!";

    if (peopleToTarget.length() > 0) {
      collector.prepareAdvertisement("gorillaTargets.txt", peopleToTarget, adMessage);
    }
  }

  private static String cleanUp(String text) {
    String lower = text.toLowerCase();
    lower = lower.replaceAll("[^a-z0-9-]+", " ");
    lower = lower.trim().replaceAll("\\s+", " ");
    return " " + lower + " ";
  }
}
