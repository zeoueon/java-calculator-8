package calculator.model;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private StringSplitter stringSplitter;
    private String[] numbers;
    private String inputString;

    public Double calculate(String inputString, String delimiter) {
        stringSplitter = new StringSplitter(inputString);
        numbers = stringSplitter.splitString(delimiter);
        return sum(convertToNumbers(numbers));
    }

    private List<Double> convertToNumbers(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .mapToDouble((number) -> number.isEmpty() ? 0.0 : Double.parseDouble(number))
                    .peek(number -> {
                        if (number < 0) {
                            throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
                        }
                    })
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자 이외의 문자는 들어갈 수 없습니다.");
        }
    }

    private Double sum(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
