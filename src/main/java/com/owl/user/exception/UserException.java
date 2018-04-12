package com.owl.user.exception;

import com.owl.user.enums.AppError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserException extends RuntimeException {
    private static final long serialVersionUID = 1564468276894820652L;
    protected int errorCode;
    protected String message;
    protected String data;
    protected HttpStatus httpStatus;
    public UserException(final AppError appError) {
        super();
        this.errorCode = appError.getErrorCode();
        this.message = appError.getMessageKey();
    }

    public UserException(final AppError appError, final String data) {
        super();
        this.errorCode = appError.getErrorCode();
        this.message = appError.getMessageKey();
        this.data = data;
    }
}
