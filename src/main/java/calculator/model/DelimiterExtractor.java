package calculator.model;

public class DelimiterExtractor {

    private final static String DEFAULT_DELIMITER = "[,:]";
    private final static String FRONT_DELIMITER = "//";
    private final static String BACK_DELIMITER = "\\n";

    public String extractDelimiter(String inputString) {
        if (!(inputString.startsWith(FRONT_DELIMITER))) {
            return DEFAULT_DELIMITER;
        }

        int delimiterLastIndex = inputString.indexOf(BACK_DELIMITER);
        validateDelimiter(delimiterLastIndex);

        String delimiter = inputString.substring(2, delimiterLastIndex);
        validateDelimiterNotDefault(delimiter);

        return delimiter;
    }

    private void validateDelimiter(int delimiterLastIndex) {
        if (delimiterLastIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자를 올바른 형식으로 설정하세요.");
        }
    }

    private void validateDelimiterNotDefault(String delimiter) {
        if (delimiter.matches(DEFAULT_DELIMITER)) {
            throw new IllegalArgumentException("디폴트 구분자를 커스텀 구분자로 입력할 수 없습니다.");
        }
    }
}
