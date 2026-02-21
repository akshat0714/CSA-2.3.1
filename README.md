# CSA 2.3.1 – Targeted Advertising (Gorilla Version)

## What This Project Does

This program simulates a simple targeted advertising system. Instead of sending the same advertisement to every user, the program analyzes social media posts and only targets users whose posts suggest they are interested in a specific topic. In this version, the topic is **gorillas**.

The program reads posts, checks for gorilla-related keywords, collects usernames of matching users, and then generates an advertisement file specifically for those users.

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

## How the Requirements Are Met

### Preparation Requirement

**Requirement:** Create a file called `targetWords.txt` and populate it with words that determine if a user is interested in the topic.

**How it is met:**

- The file `targetWords.txt` exists in the repository.
- It contains one gorilla-related word per line.
- There are no blank lines, which prevents accidental matching of every post.


# Programming Requirements

## Programming Requirement 1: Load Data Using DataCollector

### Requirement:
Create a `DataCollector` object and load both the posts file and the target words file.

### How it is met:
In `TargetedAd.java`, the program creates a `DataCollector` object and calls:

```java
DataCollector collector = new DataCollector();
collector.setData(postsFileName, targetWordsFileName);
```

This loads all social media posts and target words into memory so they can be processed.

## Programming Requirement 2: Iterate Through Social Media Posts

### Requirement:
Iterate through social media posts to find users who match the criteria.

### How it is met:
The program repeatedly calls:

```java
collector.getNextPost();
```

This method returns one post at a time. The loop continues until the method returns `"NONE"`, which indicates there are no more posts left.

This ensures every post in the file is examined.

## Programming Requirement 3: Create a String to Hold Usernames

### Requirement:
Create a `String` variable that stores usernames separated by spaces.

### How it is met:
The program creates a variable like:

```java
String peopleToTarget = "";
```

Whenever a post matches at least one target word, the username is added to this string with a space after it.

### Example format:

```
kong_keeper jungle_jim banana_business
```

This satisfies the requirement of storing usernames in a single space-separated string.

## Programming Requirement 4: Compare Each Post to Each Target Word

### Requirement:
Compare each post to each target word and add the user if there is a match.

### How it is met:
The algorithm uses nested loops:

- The outer loop goes through each post.
- The inner loop goes through each target word.
- It uses `indexOf(...)` to check if the target word appears in the post text.

If at least one target word is found in the post text, the username is added to the list.

This directly follows the instructions in the assignment.

## Programming Requirement 5: Prepare the Advertisement File

### Requirement:
Use the `prepareAdvertisement` method to generate the advertisement file.

### How it is met:
After collecting all targeted usernames, the program calls:

```java
collector.prepareAdvertisement("gorillaTargets.txt", peopleToTarget, adMessage);
```

This creates a file called `gorillaTargets.txt` that contains one line per targeted user with the advertisement message.

## Enhancements (Improvements Beyond the Minimum Requirements)

Although the assignment only required basic functionality, this implementation includes several improvements:

### 1. Prevent Duplicate Usernames

If a user matches multiple target words or appears in multiple posts, they should only receive the advertisement once.

The program checks whether the username already exists in the list before adding it again.

### 2. Avoid Matching Keywords in Usernames

Some usernames may contain words like `"silverback"` or `"ape"`.

The program only checks the actual post text, not the username, to prevent false positives.

### 3. Cleaner and More Reliable Matching

The post text is normalized by:

- Converting everything to lowercase
- Removing punctuation
- Removing extra spaces

This ensures that words like `"silverback!"` still match the keyword `silverback`.

### 4. Skip Blank Target Words

If `targetWords.txt` accidentally contains a blank line, `indexOf("")` would match every post.

The program skips empty target words to prevent this bug.

