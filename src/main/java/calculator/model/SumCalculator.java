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
        return Math.round(number * 1000) / 1000.0; // 소수점 셋째자리까지 표시
    }
}
