package calculator.model;

import java.util.List;

public class SumCalculator implements Calculator {

    @Override
    public Double calculate(List<Double> numbers) {
        return formatDouble(
                numbers.stream()
                        .mapToDouble(Double::doubleValue)
                        .sum()
        );
    }

    public Double formatDouble(Double number) {
        if (number > Double.MAX_VALUE) {
            throw new IllegalArgumentException("숫자가 너무 큽니다.");
        }
        return Math.round(number * 1000) / 1000.0; // 소수점 셋째자리까지 표시
    }
}
