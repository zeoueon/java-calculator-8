package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void test() {
        //given
        Calculator calculator = new Calculator();

        //when
        Double sum = calculator.calculate("//;\\n1", ";");

        //then
        assertThat(sum).isEqualTo(1);
    }

    @Test
    void 음수_예외_테스트() {
        //given
        Calculator calculator = new Calculator();

        //when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("9,-1:10", "[,:]");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo("숫자는 양수만 가능합니다.");
    }

    @Test
    void 구분자아닌문자_예외_테스트() {
        //given
        Calculator calculator = new Calculator();

        //when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//;\\n1;2;$3", ";");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo("구분자 이외의 문자는 들어갈 수 없습니다.");
    }

    @Test
    void 빈문자열_0으로_테스트() {
        //given
        Calculator calculator = new Calculator();

        //when
        Double sum = calculator.calculate("//*\\n", "*");

        //then
        assertThat(sum).isEqualTo(0);
    }
}
