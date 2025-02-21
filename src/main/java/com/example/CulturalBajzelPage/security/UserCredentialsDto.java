package com.example.CulturalBajzelPage.security;

import lombok.Getter;

@Getter
public class UserCredentialsDto {
    private final String login;
    private final String password;
    private final String role;

    public UserCredentialsDto(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public static UserCredentialsDto map(User user) {
        var login = user.getUsername();
        var password = user.getPassword();
        var role = user.getRole();
        return new UserCredentialsDto(login, password, role.getName());
    }
}
