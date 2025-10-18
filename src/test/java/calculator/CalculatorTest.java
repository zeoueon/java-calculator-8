package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.model.SumCalculator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void test() {
        //given
        SumCalculator calculator = new SumCalculator();
        List<Double> numbers = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);

        //when
        Double sum = calculator.calculate(numbers);

        //then
        assertThat(sum).isEqualTo(21);
    }
}
