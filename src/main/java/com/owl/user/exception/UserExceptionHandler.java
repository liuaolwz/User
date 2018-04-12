package com.owl.user.exception;

import com.owl.user.enums.AppError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, //
                                                                  final HttpHeaders headers, //
                                                                  final HttpStatus status, //
                                                                  final WebRequest request) {
        log.error("MethodArgumentNotValidException:{}", ex);
        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String data = fieldErrors.stream().reduce("请求参数错误：", (msg, fe) -> (msg + fe.getField() + "-" + fe.getDefaultMessage() + ";"), String::concat);
        final ErrorMessage errorMessage =
                new ErrorMessage(AppError.REQUEST_PARAMS_NOT_VALID, data);
        return new ResponseEntity<>(errorMessage, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleExceptionInternal:", ex);
        ErrorMessage errorMessage = new ErrorMessage(AppError.SERVER_INTERNAL_ERROR, "系统异常");
        return new ResponseEntity<>(errorMessage, status);
    }

    @ExceptionHandler(value = {UserException.class})
    protected ResponseEntity<Object> handleUserException(final UserException ex, final WebRequest request) {
        log.error("handleUserException:{}-{}", ex.getMessage(), ex.getData());
        final ErrorMessage errorMessage = new ErrorMessage(ex);
        return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
    }
}
