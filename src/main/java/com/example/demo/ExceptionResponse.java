package com.example.demo;
public class ExceptionResponse {
  private String msg;
  private String details;

  public ExceptionResponse(String msg, String details) {
    super();
    this.msg = msg;
    this.details = details;
  }

  public String getMsg() {
    return msg;
  }

  public String getDetails() {
    return details;
  }

}