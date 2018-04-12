package com.owl.user.exception;

import com.owl.user.enums.AppError;
import org.springframework.http.HttpStatus;

public class NotFoundException extends UserException {
    private static final long serialVersionUID = 1411570062359558595L;
    {
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
    public NotFoundException(AppError appError) {
        super(appError);
    }

    public NotFoundException(AppError appError, String data) {
        super(appError, data);
    }
}
