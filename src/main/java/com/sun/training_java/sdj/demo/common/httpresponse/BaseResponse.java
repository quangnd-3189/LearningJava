package com.sun.training_java.sdj.demo.common.httpresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
  private Object data;
  private int statusCode;
  private String message;
}
