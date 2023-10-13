package org.example.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NiceStringFinderTest {

    private final NiceStringFinder niceStringFinder = new NiceStringFinder();

    @ParameterizedTest
    @MethodSource("provideArgumentsPartOne")
    void testNiceStringsPartOne(String input, boolean expectedIsNice) {
        boolean actualIsNice = niceStringFinder.isStringNicePartOne(input);
        Assertions.assertEquals(expectedIsNice, actualIsNice);
    }

    private static Stream<Arguments> provideArgumentsPartOne() {
        return Stream.of(
                Arguments.of("ugknbfddgicrmopn", true),
                Arguments.of("aaa", true),
                Arguments.of("jchzalrnumimnmhp", false),
                Arguments.of("haegwjzuvuyypxyu", false),
                Arguments.of("dvszwmarrgswjxmb", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsPartTwo")
    void testNiceStringsPartTwo(String input, boolean expectedIsNice) {
        boolean actualIsNice = niceStringFinder.isStringNicePartTwo(input);
        Assertions.assertEquals(expectedIsNice, actualIsNice);
    }

    private static Stream<Arguments> provideArgumentsPartTwo() {
        return Stream.of(
                Arguments.of("qjhvhtzxzqqjkmpb", true),
                Arguments.of("xxyxx", true),
                Arguments.of("uurcxstgmygtbstg", false),
                Arguments.of("ieodomkazucvgmuy", false)
        );
    }
}
