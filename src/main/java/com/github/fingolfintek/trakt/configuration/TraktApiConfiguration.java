package com.github.fingolfintek.trakt.configuration;

import javax.annotation.PreDestroy;
import java.security.GeneralSecurityException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fingolfintek.trakt.api.LoginService;
import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.interceptor.TraktBasicHeadersPopulator;
import com.github.fingolfintek.trakt.api.interceptor.TraktHeadersPopulator;
import com.github.fingolfintek.trakt.api.model.TraktUserToken;
import com.github.fingolfintek.trakt.configuration.properties.TraktProperties;
import com.github.fingolfintek.trakt.security.TrustySslUtil;
import com.github.fingolfintek.trakt.util.JacksonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableConfigurationProperties(TraktProperties.class)
public class TraktApiConfiguration {

    @Autowired
    private TraktProperties properties;

    @Autowired
    private TraktBasicHeadersPopulator basicHeadersPopulator;

    private LoginService loginService;
    private String token;

    @PreDestroy
    public void logout() throws GeneralSecurityException {
        loginService.logout(properties.getUsername(), token);
    }

    @Bean
    public TraktHeadersPopulator headersPopulator() throws GeneralSecurityException {
        return new TraktHeadersPopulator(properties.getUsername(), token().getToken(), basicHeadersPopulator);
    }

    @Bean
    public TraktUserToken token() throws GeneralSecurityException {
        TraktUserToken userToken = loginService().login(properties.toLogin());
        token = userToken.getToken();
        return userToken;
    }

    @Bean
    public LoginService loginService() throws GeneralSecurityException {
        return loginService = restAdapter(basicHeadersPopulator).create(LoginService.class);
    }

    @Bean
    public SyncService syncService() throws GeneralSecurityException {
        return restAdapter(headersPopulator()).create(SyncService.class);
    }

    private RestAdapter restAdapter(final RequestInterceptor interceptor) throws GeneralSecurityException {
        return new RestAdapter.Builder()
                .setEndpoint(properties.getEndpoint())
                .setClient(TrustySslUtil.trustyClient())
                .setRequestInterceptor(interceptor)
                .setConverter(new JacksonConverter(new ObjectMapper()))
                .build();
    }

}
