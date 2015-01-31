package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.TraktLogin;
import com.github.fingolfintek.trakt.api.model.TraktMessage;
import com.github.fingolfintek.trakt.api.model.TraktUserToken;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Header;
import retrofit.http.POST;

public interface LoginService {

    @POST("/auth/login") 
    TraktUserToken login(@Body TraktLogin login);

    @DELETE("/auth/logout") 
    TraktMessage logout(@Header("trakt-user-login") String username, @Header("trakt-user-token") String token);
}
