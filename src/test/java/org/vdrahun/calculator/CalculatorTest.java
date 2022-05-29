package org.vdrahun.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("sumProvider")
    void shouldSumTwoIntegers(Integer a, Integer b, Integer expectedSum) {
        assertThat(calculator.sum(a, b)).isEqualTo(expectedSum);
    }

    static Stream<Arguments> sumProvider() {
        return Stream.of(
                arguments(0, 0, 0),
                arguments(1, 2, 3),
                arguments(-1, 1, 0),
                arguments(10, 20, 30)
        );
    }
}