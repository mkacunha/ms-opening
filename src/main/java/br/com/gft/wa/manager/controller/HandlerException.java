package br.com.gft.wa.manager.controller;

import br.com.gft.wa.manager.domain.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(new Error(message));
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessException(BusinessException exception) {
        return ResponseEntity.badRequest().body(new Error(exception.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(exception.getMessage()));
    }

    class Error {
        private final String message;

        Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
