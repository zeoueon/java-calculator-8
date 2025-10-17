package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.model.DelimiterExtractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelimiterExtractorTest {

    @Test
    void 구분자_추출_테스트() {
        //given
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        //when
        String delimiter = delimiterExtractor.extractDelimiter("//*\\n");

        //then
        assertThat(delimiter).isEqualTo("*");
    }

    @Test
    void 커스텀구분자_예외_테스트() {
        //given
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        //when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            delimiterExtractor.extractDelimiter("//;n1");
        });

        //then
        assertThat(exception.getMessage()).isEqualTo("커스텀 구분자를 올바른 형식으로 설정하세요.");
    }
}
