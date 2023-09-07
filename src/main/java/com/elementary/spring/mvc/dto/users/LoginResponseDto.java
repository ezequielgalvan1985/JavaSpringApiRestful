package com.elementary.spring.mvc.dto.users;

public class LoginResponseDto {

    private String token;
    private String login;
    private int userId;

    public LoginResponseDto(String token, String login, int userId) {
        this.token = token;
        this.login = login;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }




}
