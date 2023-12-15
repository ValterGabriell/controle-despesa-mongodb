package valter.gabriell.io.moneyproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import valter.gabriell.io.moneyproject.exceptions.ex.FieldIsNullOrEmpty;
import valter.gabriell.io.moneyproject.exceptions.ex.FieldOutOfRangeOfLenghtException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(FieldOutOfRangeOfLenghtException.class)
    public ResponseEntity<MessageExceptionHandler> fieldOutOfRangeException(FieldOutOfRangeOfLenghtException apiRequestHandlerException) {
        MessageExceptionHandler messageExceptionHandler
                = new MessageExceptionHandler(apiRequestHandlerException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(FieldIsNullOrEmpty.class)
    public ResponseEntity<MessageExceptionHandler> fieldIsNullOrEmpty(FieldIsNullOrEmpty apiRequestHandlerException) {
        MessageExceptionHandler messageExceptionHandler
                = new MessageExceptionHandler(apiRequestHandlerException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);
    }
}
