package edu.icet.rms.exception.handler;

import edu.icet.rms.exception.ObjectNotFoundException;
import edu.icet.rms.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleObjectNotFoundException(ObjectNotFoundException ex) {
        log.debug("Object Not Found Error {}", ex.getMessage());
        return ResponseEntity.ok().body(ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("failed").build());
    }
}
