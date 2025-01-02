package Exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException() {
        super("You just entered a wrong Type of Data which can not be validated");
    }
    public ValidationException(String message) {
        super(message);
    }
}
