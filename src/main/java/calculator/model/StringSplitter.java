package calculator.model;

import java.util.regex.Pattern;

public class StringSplitter {

    private final static String DEFAULT_DELIMITER = "[,:]";

    private String inputString;
    private String delimiter;
    private DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    public StringSplitter(String inputString) {
        this.inputString = setInputString(inputString);
        this.delimiter = setDelimiter(inputString);
    }

    private String setInputString(String inputString) {
        if (inputString.startsWith("//")) {
            int delimiterLastIndex = inputString.indexOf("\\n");
            inputString = inputString.substring(delimiterLastIndex + 2);
            return inputString;
        }
        return inputString;
    }

    private String setDelimiter(String inputString) {
        return delimiterExtractor.extractDelimiter(inputString);
    }

    public String[] splitString() {
        if (delimiter.equals(DEFAULT_DELIMITER)) {
            String[] result = inputString.split(delimiter);
            return result;
        }

        String replacedDelimiter = Pattern.quote(delimiter);
        String[] result = inputString.split(replacedDelimiter);
        return result;
    }
}
