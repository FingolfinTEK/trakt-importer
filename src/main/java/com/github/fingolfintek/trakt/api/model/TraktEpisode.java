package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TraktEpisode {
    private TraktExternalIds ids;

    public TraktExternalIds getIds() {
        return ids;
    }

    public void setIds(final TraktExternalIds ids) {
        this.ids = ids;
    }
}
