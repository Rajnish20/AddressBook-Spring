package com.example.addressbookspring.dto;

/**
 * Represent Response DTO
 * @author Rajnish Sahu
 */
public class ResponseDTO {
    private String message;
    private Object data;

    /**
     * Creates a Response DTO with specified message and data
     * @param message to show in response body
     * @param data passed in Request Body
     */
    public ResponseDTO(String message, Object data){
        this.message = message;
        this.data=data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
