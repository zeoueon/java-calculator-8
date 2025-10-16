package calculator.model;

public class DelimiterExtractor {

    private final static String DEFAULT_DELIMITER = "[,:]";
    private final static String FRONT_DELIMITER = "//";
    private final static String BACK_DELIMITER = "\\n";

    public String extractDelimiter(String inputString) { // 일단 여기서는 검증이 된 입력이라고 가정하자.
        if (!(inputString.substring(0, 2).equals(FRONT_DELIMITER))) {
            return DEFAULT_DELIMITER;
        }

        int delimiterLastIndex = inputString.indexOf(BACK_DELIMITER);
        if (delimiterLastIndex == -1) {
            throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
        }
        
        return inputString.substring(0, delimiterLastIndex);
    }

}
