package com.SpringBoot.Course.springnoot.error;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseHandler extends RuntimeException {
    public ApiBaseHandler(String msg){
        super(msg);
    }
    public abstract HttpStatus getStatuesCode();
}
