package com.SpringBoot.Course.springnoot.error;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiBaseHandler{

    public NotFoundException(String msg){
        super(msg);
    }
    public HttpStatus getStatuesCode(){
        return HttpStatus.NOT_FOUND;
    }
}
