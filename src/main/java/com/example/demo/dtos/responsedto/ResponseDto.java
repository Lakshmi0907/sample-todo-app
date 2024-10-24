package com.example.demo.dtos.responsedto;

import java.util.LinkedList;

public class ResponseDto<T> {
    private Boolean success;
    private String message;
    private T data;

    public ResponseDto() {
    }

    public ResponseDto(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseDto(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
