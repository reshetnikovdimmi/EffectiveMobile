package ru.EffectiveMobileTest.test.responses;

import ru.EffectiveMobileTest.test.security.UserDetailsImpl;

public class AuthResponse {

    private UserDetailsImpl shopDetails;
    private String token;
    public AuthResponse(){

    }


    public AuthResponse(String token, UserDetailsImpl shopDetails){
        this.token = token;
        this.shopDetails = shopDetails;
    }

    public Long getUserId(){
        return this.shopDetails.getUserId();
    }

    public String getUsername(){

        return this.shopDetails.getUsername();
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
