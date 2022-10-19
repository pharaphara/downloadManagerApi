package com.pharaphara.uptoboxClientApi.entity;

public class InfoDTO {

    private String statusCode;
    private String message;
    private InfoDataDTO data;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InfoDataDTO getData() {
        return data;
    }

    public void setData(InfoDataDTO data) {
        this.data = data;
    }
}
