package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.model.TraktLogin;
import com.github.fingolfintek.trakt.model.TraktUserToken;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;

public interface TraktLoginService {

    @GET("/auth/login") 
    TraktUserToken login(TraktLogin login);

    @DELETE("/auth/logout") 
    void logout(@Header("trakt-user-login") String username, @Header("trakt-user-token") String token);
}
