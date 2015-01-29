package com.github.fingolfintek.trakt.api.model;

public class TraktLogin {
    private String login;
    private String password;

    public TraktLogin() {
    }

    public TraktLogin(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
