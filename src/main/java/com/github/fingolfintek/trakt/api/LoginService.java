package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.TraktLogin;
import com.github.fingolfintek.trakt.api.model.TraktUserToken;
import retrofit.http.*;

public interface LoginService {

    @POST("/auth/login") 
    TraktUserToken login(@Body TraktLogin login);

    @DELETE("/auth/logout") 
    void logout(@Header("trakt-user-login") String username, @Header("trakt-user-token") String token);
}
