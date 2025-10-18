package calculator.model;

import java.util.List;

public class SumCalculator implements Calculator {

    @Override
    public Double calculate(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    // Double 반올림 함수도 추가하자.
}
