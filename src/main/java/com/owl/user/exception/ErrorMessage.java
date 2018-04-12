package com.owl.user.exception;

import com.owl.user.enums.AppError;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {

  private long timestamp;
  private int code;
  private String data;
  private String message;

  public ErrorMessage(final int code, final String message) {
    this.code = code;
    this.message = message;
    timestamp = System.currentTimeMillis();
  }

  public ErrorMessage(final int code, final String message, final String data) {
    this.code = code;
    this.message = message;
    this.data = data;
    timestamp = System.currentTimeMillis();
  }
  public ErrorMessage(final AppError appError,final String data){
    this.code = appError.getErrorCode();
    this.message=appError.getMessageKey();
    this.data = data;
    timestamp = System.currentTimeMillis();
  }
  public ErrorMessage(final UserException exception){
      this.code = exception.getErrorCode();
      this.message = exception.getMessage();
      this.data = exception.getData();
      timestamp = System.currentTimeMillis();
  }
}
