package org.vdrahun.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/sum")
    public String sum(
            @RequestParam("a") Integer a,
            @RequestParam("b") Integer b) {
        return String.valueOf(calculator.sum(a, b));
    }
}
