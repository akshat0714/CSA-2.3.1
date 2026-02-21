# CSA 2.3.1 – Targeted Advertising (Gorilla Version)

## What this project does
This program reads a list of social media posts and a list of "target words" and then creates a file that contains an advertisement for **only the users** whose posts contain at least one target word.

In this version, the topic is **gorillas**.

---

## Files in this repo
- `TargetedAd.java` – main program (my solution)
- `DataCollector.java` – helper that reads posts/target words and writes the ad file
- `targetWords.txt` – gorilla-related keywords (one per line)
- `socialMediaPostsSmall.txt` – small dataset for testing
- `socialMediaPosts.txt` – full dataset (final run)

---

## How requirements are met

### Preparation
 **Create `targetWords.txt` with target words**
- `targetWords.txt` contains gorilla-related words like `gorilla`, `silverback`, `troop`, `primate`, etc.
- One word per line and no blank lines, so it won’t accidentally match everything.

### Programming
 **Load files into a `DataCollector`**
- `TargetedAd` creates a `DataCollector` and calls `setData(postsFile, targetWordsFile)`.

 **Iterate through posts**
- Uses `getNextPost()` in a loop until it returns `"NONE"`.

 **Build a space-separated String of usernames**
- Uses a String like `peopleToTarget` and adds usernames separated by spaces.

 **Compare each post with each target word**
- For each post, it loops through every target word using `getNextTargetWord()`.
- It uses `indexOf(...)` to check if the target word is contained in the post text.

 **Create advertisement output file**
- Calls `prepareAdvertisement("gorillaTargets.txt", peopleToTarget, adMessage)`.

---

## Enhancements (extras beyond the minimum)
- **No duplicate usernames:** a user is only added once even if they match multiple words/posts.
- **Doesn't match against usernames:** only the post text is checked, to avoid false positives from usernames like `silverback_fan`.
- **Cleaner matching:** the post text is normalized (lowercased and punctuation removed) so words like `"silverback!"` still match.
- **Skips blank target words:** prevents the "everyone matches" bug.

---

## How to run
Compile:
```bash
javac DataCollector.java TargetedAd.java
