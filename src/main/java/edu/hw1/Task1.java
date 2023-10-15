package edu.hw1;

public final class Task1 {
    private final static int SECONDS_IN_MINUTES = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        String[] dividedTime = time.split(":");
        int minutes = Integer.parseInt(dividedTime[0]);
        int seconds = Integer.parseInt(dividedTime[1]);

        if ((seconds < 0) || (minutes < 0) || (seconds >= SECONDS_IN_MINUTES)
            || (minutes > (Integer.MAX_VALUE - seconds) / SECONDS_IN_MINUTES)) {
            return -1;
        }

        return minutes * SECONDS_IN_MINUTES + seconds;
    }
}
