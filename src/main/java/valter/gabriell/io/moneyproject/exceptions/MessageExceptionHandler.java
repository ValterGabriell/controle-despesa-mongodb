package valter.gabriell.io.moneyproject.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record MessageExceptionHandler(String message, HttpStatus statusCode, LocalDateTime timestamp) {
}
