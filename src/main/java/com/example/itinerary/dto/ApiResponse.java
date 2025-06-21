package com.example.itinerary.dto;

public class ApiResponse<T> {

    private T data;
    private String message;
    private boolean success;

    public ApiResponse(T data,String message,boolean success){
        this.data=data;
        this.message=message;
        this.success=success;
    }

    public String getMessage(){
        return message;
    }
    public boolean getSuccess(){
        return success;
    }
    public T getData(){
        return data;
    }
}
