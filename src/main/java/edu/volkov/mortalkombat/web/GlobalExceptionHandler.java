package edu.volkov.mortalkombat.web;

import edu.volkov.mortalkombat.util.exception.ErrorInfo;
import edu.volkov.mortalkombat.util.exception.NoSuchEntityException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static edu.volkov.mortalkombat.util.exception.ErrorType.DATA_NOT_FOUND;

@RestControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchEntityException.class)
    public ResponseEntity<ErrorInfo> handleError(HttpServletRequest req, NoSuchEntityException e) {
        return ResponseEntity.status(DATA_NOT_FOUND.getStatus())
                .body(new ErrorInfo(
                        req.getRequestURL(),
                        DATA_NOT_FOUND.getErrorCode(),
                        e.getErrMessage())
                );
    }
}
