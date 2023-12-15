package valter.gabriell.io.moneyproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(ApiHandlerException.class)
    public ResponseEntity<MessageExceptionHandler> exception(ApiHandlerException apiHandlerException) {
        MessageExceptionHandler messageExceptionHandler
                = new MessageExceptionHandler(message, statusCode, LocalDateTime.now());
        return new ResponseEntity<>(messageExceptionHandler, statusCode);
    }
}
