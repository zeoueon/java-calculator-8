package calculator.model;

import java.util.regex.Pattern;

public class StringSplitter {

    private String inputString;
    private final static String DEFAULT_DELIMITER = "[,:]";

    public StringSplitter(String inputString) {
        this.inputString = setInputString(inputString);
    }

    private String setInputString(String inputString) {
        if (inputString.startsWith("//")) {
            int delimiterLastIndex = inputString.indexOf("\\n");
            inputString = inputString.substring(delimiterLastIndex + 2);
            return inputString;
        }
        return inputString;
    }

    public String[] splitString(String delimiter) {
        if (delimiter.equals(DEFAULT_DELIMITER)) {
            String[] result = inputString.split(delimiter);
            return result;
        }

        String replacedDelimiter = Pattern.quote(delimiter);
        String[] result = inputString.split(replacedDelimiter);
        return result;
    }
}
