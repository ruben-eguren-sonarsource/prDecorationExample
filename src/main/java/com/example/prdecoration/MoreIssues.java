package com.example.prdecoration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A second class full of intentional issues to demonstrate SonarQube PR decoration.
 * These trigger a different set of well-known Sonar Java rules than IssueShowcase.
 */
public class MoreIssues {

    // S2245: using pseudorandom number generators (PRNGs) is security-sensitive.
    private static final Random RANDOM = new Random();

    // S1170: this field could be final but also is never used meaningfully.
    private String name = "default";

    // S1444: public static fields should be final.
    public static int counter = 0;

    // S3008: static fields should comply with naming conventions (should be UPPER_CASE).
    public static int badlyNamedStatic = 5;

    // S1118: utility-style class exposes an implicit public constructor, plus S1186 empties below.

    // S1244: floating point numbers should not be tested for equality.
    public boolean isZero(double value) {
        return value == 0.0;
    }

    // S2184: math operands should be cast before assignment (int division assigned to long).
    public long divide(int a, int b) {
        long result = a / b;
        return result;
    }

    // S2201: return value of method should not be ignored.
    public void trimIt(String text) {
        text.trim();
        System.out.println(text);
    }

    // S1155: use isEmpty(); S3518: possible division by zero.
    public int ratio(int count) {
        return 100 / count;
    }

    // S1301: switch with few cases should be replaced by if; S128: missing break (fall-through).
    public String label(int code) {
        String out = "";
        switch (code) {
            case 1:
                out = "one";
            case 2:
                out = "two";
                break;
            default:
                out = "unknown";
        }
        return out;
    }

    // S1149: use non-synchronized StringBuilder instead of StringBuffer.
    public String build() {
        StringBuffer sb = new StringBuffer();
        sb.append("a").append("b");
        return sb.toString();
    }

    // S2681: nested conditionals need braces; S1066: mergeable if statements.
    public void checkFlags(boolean a, boolean b) {
        if (a) {
            if (b) {
                System.out.println("both");
            }
        }
    }

    // S1481: unused local variable; S1854: dead store.
    public void leak() {
        Map<String, String> cache = new HashMap<>();
        cache.put("key", "value");
        Map<String, String> unused = new HashMap<>();
    }

    // S106: standard outputs should not be used directly.
    public void spin() {
        for (int i = 0; i < 3; i++) {
            System.out.println(RANDOM.nextInt());
        }
    }

    // S1186: empty method.
    public void placeholder() {
    }

    // S1774: ternary operator should not be nested.
    public String classify(int n) {
        return n < 0 ? "neg" : (n == 0 ? "zero" : "pos");
    }

    // S3776: high cognitive complexity; S1871: two branches with the same implementation.
    public int score(int x) {
        if (x > 100) {
            return 10;
        } else if (x > 50) {
            return 5;
        } else if (x > 10) {
            return 10;
        }
        return 0;
    }
}
