package edu.project1;

public class GameManager {
    private final int attemptRate = 2;
    private final char[] answer;
    private final int maxAttempts;
    private final int answerLength;
    private int attempts;
    private final char[] userAnswer;
    private int countKnownSymbols;

    public GameManager(String answer, int answerLength) {
        this.answerLength = answerLength;
        this.answer = answer.toCharArray();
        this.maxAttempts = answerLength * attemptRate;
        this.userAnswer = answer.toCharArray();
        this.countKnownSymbols = 0;
        for (int i = 0; i < answerLength; i++) {
            userAnswer[i] = '*';
        }
    }

    public boolean guess(char enteredLetter) {
        attempts++;
        boolean hit = false;
        for (int i = 0; i < answerLength; i++) {
            if (enteredLetter == answer[i]) {
                if (!(userAnswer[i] == enteredLetter)) {
                    userAnswer[i] = enteredLetter;
                    countKnownSymbols++;
                    hit = true;
                }
            }
        }
        return hit;
    }

    public String getUserAnswer() {
        return new String(userAnswer);
    }

    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public boolean isPlayerWon() {
        return countKnownSymbols == answerLength;
    }
}
