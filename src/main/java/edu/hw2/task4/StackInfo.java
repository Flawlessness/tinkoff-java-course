package edu.hw2.task4;

public class StackInfo {
    private StackInfo() {}

    public static CallingInfo callingInfo() {
        StackTraceElement caller = new Throwable().getStackTrace()[1];

        return new CallingInfo(caller.getClassName(), caller.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
