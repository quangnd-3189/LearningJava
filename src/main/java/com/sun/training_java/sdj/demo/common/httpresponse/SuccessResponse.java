package com.sun.training_java.sdj.demo.common.httpresponse;

import org.springframework.http.HttpStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SuccessResponse extends BaseResponse {
  public SuccessResponse(Object data, String message) {
    super(data, HttpStatus.OK.value(), message);
  }
}
