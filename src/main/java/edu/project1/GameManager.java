package edu.project1;

public class GameManager {
    private final int attemptRate = 2;
    private final char[] answer;
    private int maxAttempts;
    private final int answerLength;
    private int attempts;
    private final char[] userAnswer;
    private int countKnownSymbols;

    public GameManager(String answer) {
        this.answerLength = answer.length();
        this.answer = answer.toCharArray();
        this.userAnswer = answer.toCharArray();
        this.countKnownSymbols = 0;
        init();
    }

    private void init() {
        this.maxAttempts = answerLength * attemptRate;
        for (int i = 0; i < answerLength; i++) {
            userAnswer[i] = '*';
        }
    }

    public Game.ReturnCode guess(String enteredString) {
        if (enteredString.equals("stop")) {
            return Game.ReturnCode.STOP;
        } else if (enteredString.length() != 1) {
            return Game.ReturnCode.ERROR;
        }

        attempts++;

        if (isHit(enteredString)) {
            return Game.ReturnCode.HIT;
        }

        return Game.ReturnCode.MISS;
    }

    public boolean isHit(String enteredString) {
        boolean hit = false;
        char enteredLetter = enteredString.charAt(0);
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

    public boolean isAnswerCorrect() {
        return answerLength > 0;
    }

}
