package org.example.mockNewsFeed;


import java.util.Random;

public class MockNewsFeed {
    private static final String[] WORDS = {"up", "down", "rise", "fall", "good", "bad", "success", "failure", "high", "low"};
    private static final Random random = new Random();

    public static String generateHeadline() {
        StringBuilder headline = new StringBuilder();
        int numWords = random.nextInt(3) + 3;
        for (int i = 0; i < numWords; i++) {
            headline.append(WORDS[random.nextInt(WORDS.length)]).append(" ");
        }
        return headline.toString().trim();
    }

    public static int generatePriority() {
        return random.nextInt(10);
    }

}
