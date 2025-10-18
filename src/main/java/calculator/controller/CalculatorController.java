package calculator.controller;

import calculator.model.StringToNumbersConverter;
import calculator.model.SumCalculator;
import calculator.view.Input;
import calculator.view.Output;
import java.util.List;

public class CalculatorController {

    private Input input;
    private Output output;
    private SumCalculator calculator;
    private StringToNumbersConverter stringToNumbersConverter;

    public CalculatorController() {
        input = new Input();
        output = new Output();
        calculator = new SumCalculator();
        stringToNumbersConverter = new StringToNumbersConverter();
    }

    public void run() {
        String inputString = input.inputString();

        List<Double> numberList = stringToNumbersConverter.convertToNumbers(inputString);
        Double sum = calculator.calculate(numberList);

        output.printSum(sum);
    }
}
