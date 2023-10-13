package org.example.day05;

import java.util.Optional;
import java.util.function.Predicate;

class NiceStringFinder {
    public boolean isStringNicePartOne(String input) {
        return Optional.of(input)
                .filter(containsAtLeastThreeVowels())
                .filter(containsAtLeastOneDoubleAppearance())
                .filter(doesNotContainSpecificStrings())
                .isPresent();
    }

    private Predicate<String> containsAtLeastThreeVowels() {
        return input -> {
            char[] lowerCaseInput = input.toLowerCase().toCharArray();
            int count = 0;
            for (char c : lowerCaseInput) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count++;
                }
            }
            return count >= 3;
        };
    }

    private Predicate<String> containsAtLeastOneDoubleAppearance() {
        return input -> {
            char[] chars = input.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    return true;
                }
            }
            return false;
        };
    }

    private Predicate<String> doesNotContainSpecificStrings() {
        return input -> !input.contains("ab")
                && !input.contains("cd")
                && !input.contains("pq")
                && !input.contains("xy");
    }

    public boolean isStringNicePartTwo(String input) {
        return Optional.of(input)
                .filter(containsPairOfTwoLettersOccurringAtLeastTwiceWithoutOverlap())
                .filter(containsSelfRepeatingLetterWithOneLetterBetweenThem())
                .isPresent();
    }

    private Predicate<String> containsPairOfTwoLettersOccurringAtLeastTwiceWithoutOverlap() {
        return input -> {
            for (int i = 0; i < input.length() - 1; i++) {
                String pairOfLetters = input.substring(i, i + 2);
                int indexOfFirstOccurrence = input.indexOf(pairOfLetters);
                int indexOfLastOccurrence = input.lastIndexOf(pairOfLetters);
                if (indexOfFirstOccurrence != indexOfLastOccurrence && indexOfFirstOccurrence + 1 != indexOfLastOccurrence) {
                    return true;
                }
            }
            return false;
        };
    }

    private Predicate<String> containsSelfRepeatingLetterWithOneLetterBetweenThem() {
        return input -> {
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length - 2; i++) {
                if (chars[i] == chars[i + 2]) {
                    return true;
                }
            }
            return false;
        };
    }
}
