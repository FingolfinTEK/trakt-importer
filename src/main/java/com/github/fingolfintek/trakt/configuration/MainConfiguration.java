package com.github.fingolfintek.trakt.configuration;

import javax.annotation.PreDestroy;

import java.security.GeneralSecurityException;

import com.github.fingolfintek.trakt.api.TraktLoginService;
import com.github.fingolfintek.trakt.api.interceptor.TraktBasicHeadersPopulator;
import com.github.fingolfintek.trakt.api.interceptor.TraktHeadersPopulator;
import com.github.fingolfintek.trakt.model.TraktUserToken;
import com.github.fingolfintek.trakt.security.TrustySslUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

@Configuration
@EnableConfigurationProperties(TraktProperties.class)
public class MainConfiguration {

    @Autowired
    private TraktProperties properties;

    @Autowired
    private TraktBasicHeadersPopulator basicHeadersPopulator;

    @Bean
    public TraktHeadersPopulator headersPopulator() throws GeneralSecurityException {
        return new TraktHeadersPopulator(properties.getUsername(), token().getToken(), basicHeadersPopulator);
    }

    @Bean
    public TraktUserToken token() throws GeneralSecurityException {
        return loginService().login(properties.toLogin());
    }

    @Bean
    public TraktLoginService loginService() throws GeneralSecurityException {
        return restAdapter().create(TraktLoginService.class);
    }

    @Bean
    public RestAdapter restAdapter() throws GeneralSecurityException {
        return new RestAdapter.Builder()
                .setEndpoint(properties.getEndpoint())
                .setClient(TrustySslUtil.trustyClient())
                .setRequestInterceptor(basicHeadersPopulator)
                .build();
    }

    @PreDestroy
    public void logout() throws GeneralSecurityException {
        loginService().logout(properties.getUsername(), token().getToken());
    }

}
