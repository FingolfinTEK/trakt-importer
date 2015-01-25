package com.github.fingolfintek.trakt.api.interceptor;

import retrofit.RequestInterceptor;

public class TraktHeadersPopulator implements RequestInterceptor {

    private final String username;
    private final String token;
    private final TraktBasicHeadersPopulator basicHeadersPopulator;
    
    public TraktHeadersPopulator(final String username, final String token, final TraktBasicHeadersPopulator basicHeadersPopulator) {
        this.username = username;
        this.token = token;
        this.basicHeadersPopulator = basicHeadersPopulator;
    }

    @Override
    public void intercept(final RequestFacade request) {
        basicHeadersPopulator.intercept(request);
        request.addHeader("trakt-user-login", username);
        request.addHeader("trakt-user-token", token);
    }
}
