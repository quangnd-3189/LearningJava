package com.sun.training_java.sdj.demo.common.httpresponse;

import org.springframework.http.HttpStatus;

public class FailedResponse extends BaseResponse {
  public FailedResponse(String message) {
    super(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
  }
}
