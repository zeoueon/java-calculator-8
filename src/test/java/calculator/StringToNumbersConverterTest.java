package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringToNumbersConverter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StringToNumbersConverterTest {

    @Test
    void test() {
        //given
        StringToNumbersConverter converter = new StringToNumbersConverter();

        //when
        List<Double> numbers = converter.convertToNumbers("");

        //then
        assertThat(numbers).containsExactly(0d);
    }

    @Test
    void 음수_예외_테스트() {
        //given
        StringToNumbersConverter converter = new StringToNumbersConverter();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.convertToNumbers("9,-1:10");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo("숫자는 양수만 가능합니다.");
    }

    @Test
    void 구분자아닌문자_예외_테스트() {
        //given
        StringToNumbersConverter converter = new StringToNumbersConverter();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.convertToNumbers("//;\\n1;2;$3");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo("구분자 이외의 문자는 들어갈 수 없습니다.");
    }

    @Test
    void 빈문자열_0으로_테스트() {
        //given
        StringToNumbersConverter converter = new StringToNumbersConverter();

        //when
        List<Double> numbers = converter.convertToNumbers("//*\\n");

        //then
        assertThat(numbers).containsExactly(0d);
    }
}
