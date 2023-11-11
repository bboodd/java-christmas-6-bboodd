package christmas.util;

public class InputValidate {

    public void validateIsDigit(String input){
        final String REGEX = "^[0-9]+$";
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException(Error.DATE_RANGE_ERROR.message());
        }
    }

    public void validateBlank(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(Error.DATE_RANGE_ERROR.message());
        }
    }
}
