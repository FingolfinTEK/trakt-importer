package com.github.fingolfintek.trakt.configuration;

import javax.annotation.PreDestroy;
import java.security.GeneralSecurityException;

import com.github.fingolfintek.trakt.api.LoginService;
import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.interceptor.TraktBasicHeadersPopulator;
import com.github.fingolfintek.trakt.api.interceptor.TraktHeadersPopulator;
import com.github.fingolfintek.trakt.api.model.TraktUserToken;
import com.github.fingolfintek.trakt.configuration.properties.TraktProperties;
import com.github.fingolfintek.trakt.security.TrustySslUtil;
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

    @PreDestroy
    public void logout() throws GeneralSecurityException {
        loginService().logout(properties.getUsername(), token().getToken());
    }

    @Bean
    public TraktHeadersPopulator headersPopulator() throws GeneralSecurityException {
        return new TraktHeadersPopulator(properties.getUsername(), token().getToken(), basicHeadersPopulator);
    }

    @Bean
    public TraktUserToken token() throws GeneralSecurityException {
        return loginService().login(properties.toLogin());
    }

    @Bean
    public LoginService loginService() throws GeneralSecurityException {
        return restAdapter(basicHeadersPopulator).create(LoginService.class);
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
                .build();
    }

}
