package com.SpringBoot.Course.springnoot.security;

public class SignInRequest {

    private String userName;
    private String password;

    public SignInRequest(){}
    public SignInRequest(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
