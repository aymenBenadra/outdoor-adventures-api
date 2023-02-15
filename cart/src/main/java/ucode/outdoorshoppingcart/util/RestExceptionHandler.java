package ucode.outdoorshoppingcart.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestExceptionHandler
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
  @ExceptionHandler(CartNotFoundException.class)
  public ResponseEntity<ErrorResponse> notFound(final CartNotFoundException ex) {
    return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
  }
}

record ErrorResponse(String msg) {
}
