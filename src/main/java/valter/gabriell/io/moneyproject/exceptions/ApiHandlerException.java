package valter.gabriell.io.moneyproject.exceptions;

import org.springframework.http.HttpStatus;

public class ApiHandlerException extends RuntimeException{
    private String message;
    private HttpStatus statusCode;

    public ApiHandlerException(String message, HttpStatus statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
}
