package org.vdrahun.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }
}
