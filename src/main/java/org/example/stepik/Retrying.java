package org.example.stepik;

import java.util.Scanner;

import static java.lang.System.*;

@FunctionalInterface
interface Retry<T1, T2, R> {
    R run(T1 v1, T2 v2);
    // declare the run method here
}

final class RetryUtils {
    public static Retry retryAction; // assign the retryAction method to this variable

    private RetryUtils() {
        };


    public static int retryAction(
            Runnable action, int maxAttempts, long delayBeforeRetryMs) {

        int fails = 0;
        while (fails < maxAttempts) {
            try {
                action.run();
                return fails;
            } catch (Exception e) {
                out.println("Something goes wrong");
                fails++;
                try {
                    Thread.sleep(delayBeforeRetryMs);
                } catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException);
                }
            }
        }
        return fails;
    }
}

class Retrying {
    private static final int MAX_ATTEMPTS = 10;
    private static final long DELAY_MS = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        RetryUtils.retryAction(() -> System.out.println(scanner.nextLine()), MAX_ATTEMPTS, DELAY_MS);
    }
}

