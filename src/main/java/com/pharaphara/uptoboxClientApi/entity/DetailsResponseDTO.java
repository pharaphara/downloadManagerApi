package com.pharaphara.uptoboxClientApi.entity;

public class DetailsResponseDTO {

    private String statusCode;
    private String message;
    private FileDetailsDTO data;


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

    public FileDetailsDTO getData() {
        return data;
    }

    public void setData(FileDetailsDTO data) {
        this.data = data;
    }
}
