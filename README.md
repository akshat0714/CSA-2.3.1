# CSA 2.3.1 – Targeted Advertising (Gorilla Version)

## What This Project Does

This program simulates a simple targeted advertising system.

Instead of sending the same advertisement to every user, the program analyzes social media posts and only targets users whose posts suggest they are interested in a specific topic.

In this version, the topic is **gorillas**.

The program reads posts, checks for gorilla-related keywords, collects usernames of matching users, and then generates an advertisement file specifically for those users.

---

## Overall Process

The program follows this general process:

1. Read all social media posts from a file.
2. Read a list of gorilla-related keywords from another file.
3. Go through each post one at a time.
4. Separate the username from the actual post text.
5. Check if the post text contains any of the target words.
6. If it does, add that username to a list (without duplicates).
7. After all posts are checked, create a new file that contains an advertisement line for each targeted user.

This simulates how companies might target ads based on user interests.

---

## Files in This Repository

- `TargetedAd.java`  
  This is the main program. It contains the algorithm required by the assignment and controls the entire targeting process.

- `DataCollector.java`  
  This helper class handles:
  - Loading the social media posts file
  - Loading the target words file
  - Providing posts and target words one at a time
  - Writing the final advertisement file

- `targetWords.txt`  
  Contains gorilla-related keywords, one per line.  
  Example words include: `gorilla`, `silverback`, `troop`, `primate`, `bamboo`.

- `socialMediaPostsSmall.txt`  
  A smaller dataset used to test the program quickly and verify that it works correctly.

- `socialMediaPosts.txt`  
  The full dataset used for the final run.

---

## How the Requirements Are Met

### Preparation Requirement

**Requirement:** Create a file called `targetWords.txt` and populate it with words that determine if a user is interested in the topic.

**How it is met:**

- The file `targetWords.txt` exists in the repository.
- It contains one gorilla-related word per line.
- There are no blank lines, which prevents accidental matching of every post.

This satisfies the preparation portion of the assignment.

---

### Programming Requirement 1: Load Data Using DataCollector

**Requirement:** Create a `DataCollector` object and load both the posts file and the target words file.

**How it is met:**

In `TargetedAd.java`, the program creates a `DataCollector` object and calls:

```java
DataCollector collector = new DataCollector();
collector.setData(postsFileName, targetWordsFileName);
