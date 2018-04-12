package com.owl.user.exception;

import com.owl.user.enums.AppError;
import org.springframework.http.HttpStatus;

public class BadRequestException extends UserException {
    private static final long serialVersionUID = -537080915232983596L;
    {
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
    public BadRequestException(AppError appError) {
        super(appError);
    }

    public BadRequestException(AppError appError, String data) {
        super(appError, data);
    }
}
