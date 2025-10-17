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
        if (delimiterLastIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자를 올바른 형식으로 설정하세요.");
        }

        return inputString.substring(2, delimiterLastIndex);
    }
}
