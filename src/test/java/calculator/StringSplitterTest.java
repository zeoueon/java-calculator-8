package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.model.StringSplitter;
import org.junit.jupiter.api.Test;

public class StringSplitterTest {

    @Test
    public void test() {
        //given
        StringSplitter stringSplitter = new StringSplitter("//;\\n1");

        //when
        String result[] = stringSplitter.splitString();

        //then
        assertThat(result).containsExactly("1");
    }
}
