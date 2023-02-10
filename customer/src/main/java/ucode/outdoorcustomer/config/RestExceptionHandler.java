package ucode.outdoorcustomer.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ucode.outdoorcustomer.util.CustomerException;
import ucode.outdoorcustomer.util.ErrorResponse;

/**
 * RestExceptionHandler
 */
@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
  @ExceptionHandler(CustomerException.class)
  public ResponseEntity<ErrorResponse> CustomerNotFound(final CustomerException exception) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }
}
