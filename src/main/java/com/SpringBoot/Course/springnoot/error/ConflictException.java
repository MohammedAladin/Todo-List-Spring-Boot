package com.SpringBoot.Course.springnoot.error;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiBaseHandler{

    public ConflictException(String msg) {
        super(msg);
    }

    @Override
    public HttpStatus getStatuesCode() {
        return HttpStatus.CONFLICT;
    }
}
