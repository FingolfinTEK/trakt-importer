package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktMessage {
    
    private String message;

    @JsonProperty("msg")
    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
