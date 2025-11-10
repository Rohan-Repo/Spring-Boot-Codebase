package in.easysystems.showcastdb.exceptions;

import in.easysystems.showcastdb.dto.RESTAPIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// In Case a malformed UUID or a short UUID found we use this GlobalExceptionHandler to handle the BAD REQUEST exception
@ControllerAdvice
public class RESTExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<RESTAPIResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        RESTAPIResponse response = new RESTAPIResponse(
                HttpStatus.BAD_REQUEST.value(),
                "INVALID ID",
                "Invalid or Malformed Actor ID format"
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
