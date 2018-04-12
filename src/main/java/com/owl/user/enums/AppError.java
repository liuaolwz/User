package com.owl.user.enums;

import lombok.Getter;

@Getter
public enum AppError {
    ERROR_USER_NOT_EXIST(4000, "error.user.not.exist"),
    REQUEST_PARAMS_NOT_VALID(4001, "request.params.not.valid"),
    SERVER_INTERNAL_ERROR(9999, "server.internal.error");

    AppError(int errorCode, String messageKey) {
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    private final int errorCode;
    private final String messageKey;

}
