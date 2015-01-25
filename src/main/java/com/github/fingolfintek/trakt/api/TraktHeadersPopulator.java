package com.github.fingolfintek.trakt.api;

import retrofit.RequestInterceptor;

public class TraktHeadersPopulator implements RequestInterceptor {
    
    private final String apiKey;
    private final String username;
    private final String token;
    private final Integer apiVersion;

    public TraktHeadersPopulator(final String apiKey, final String username, final String token) {
        this(apiKey, username, token, 2);
    }

    public TraktHeadersPopulator(final String apiKey, final String username, final String token, final Integer apiVersion) {
        this.apiKey = apiKey;
        this.username = username;
        this.token = token;
        this.apiVersion = apiVersion;
    }

    @Override 
    public void intercept(final RequestFacade request) {
        request.addHeader("Content-type", "application/json");
        request.addHeader("trakt-api-key", apiKey);
        request.addHeader("trakt-api-version", apiVersion.toString());
        request.addHeader("trakt-user-login", username);
        request.addHeader("trakt-user-token", token);
    }
}
