package com.example.prdecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A class intentionally full of issues to demonstrate SonarQube PR decoration.
 * Each method triggers one or more well-known Sonar Java rules.
 */
public class IssueShowcase {

    // S2068: Hardcoded credentials should not be used.
    private static final String PASSWORD = "admin123";

    // S1313: Using a hardcoded IP address is security-sensitive.
    private static final String SERVER_IP = "192.168.1.100";

    // S1170 / unused: this field is never read.
    private int unusedCounter = 0;

    // S2386 / S1104-style: mutable public static array.
    public static String[] MUTABLE_STATE = new String[] {"a", "b"};

    public void run(String input) {
        // S1481 & S1854: unused local variable and dead store.
        int total = 0;
        total = compute();

        // S2589: condition is always true.
        if (input != null || true) {
            System.out.println("Always runs with password " + PASSWORD);
        }

        // S1155: use isEmpty() instead of comparing size to 0.
        List<String> items = new ArrayList<>();
        if (items.size() == 0) {
            // S108: empty block.
        }

        // S1132: string literal should be on the left side of equals.
        if (input.equals("start")) {
            connectTo(SERVER_IP);
        }

        // S2259: possible null pointer dereference (input may be null above).
        System.out.println(input.length());
    }

    // S3776: high cognitive complexity from deep nesting.
    // S1172: parameter 'flag' is never used.
    public int compute(int a, int b, boolean flag) {
        if (a > 0) {
            if (b > 0) {
                if (a > b) {
                    if (a > 100) {
                        if (b > 50) {
                            return a + b;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private int compute() {
        // S3626: redundant return.
        return 42;
    }

    private void connectTo(String ip) {
        System.out.println("Connecting to " + ip);
    }

    // S1186: empty method.
    public void doNothing() {
    }

    // S00112: generic exceptions should never be thrown.
    public void risky() throws Exception {
        throw new Exception("boom");
    }
}
