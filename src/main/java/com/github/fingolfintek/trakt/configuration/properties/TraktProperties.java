package com.github.fingolfintek.trakt.configuration.properties;

import com.github.fingolfintek.trakt.api.model.TraktLogin;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("trakt")
public class TraktProperties {
    
    private String endpoint;
    private String apiKey;
    private String username;
    private String password;
    private Integer apiVersion = 2;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Integer getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(final Integer apiVersion) {
        this.apiVersion = apiVersion;
    }
    
    public TraktLogin toLogin() {
        return new TraktLogin(username, password);
    }
}
