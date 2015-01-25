package com.github.fingolfintek.trakt.api.interceptor;

import com.github.fingolfintek.trakt.configuration.TraktProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit.RequestInterceptor;

@Component
public class TraktBasicHeadersPopulator implements RequestInterceptor {
    
    private final String apiKey;
    private final Integer apiVersion;

    @Autowired
    public TraktBasicHeadersPopulator(TraktProperties properties) {
        this(properties.getApiKey(), properties.getApiVersion());
    }

    public TraktBasicHeadersPopulator(final String apiKey, final Integer apiVersion) {
        this.apiKey = apiKey;
        this.apiVersion = apiVersion;
    }

    @Override 
    public void intercept(final RequestFacade request) {
        request.addHeader("Content-type", "application/json");
        request.addHeader("trakt-api-key", apiKey);
        request.addHeader("trakt-api-version", apiVersion.toString());
    }
}
