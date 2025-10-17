package calculator.controller;

import calculator.model.Calculator;
import calculator.model.DelimiterExtractor;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController {

    private Input input;
    private Output output;
    private Calculator calculator;
    private DelimiterExtractor delimiterExtractor;

    public CalculatorController() {
        input = new Input();
        output = new Output();
        calculator = new Calculator();
        delimiterExtractor = new DelimiterExtractor();
    }

    public void run() {
        String inputString = input.inputString();

        String delimiter = delimiterExtractor.extractDelimiter(inputString);
        Double sum = calculator.calculate(inputString, delimiter);

        output.printSum(sum);
    }
}
