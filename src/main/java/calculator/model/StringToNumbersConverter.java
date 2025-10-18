package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringToNumbersConverter {

    private StringSplitter stringSplitter;

    public List<Double> convertToNumbers(String inputString) {
        stringSplitter = new StringSplitter(inputString);
        String[] numbers = stringSplitter.splitString();
        return convertToNumbers(numbers);
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
}
