package com.github.fingolfintek.trakt.api.model.sync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.TraktShow;
import com.github.fingolfintek.trakt.util.Pair;

public class ShowRating extends TraktShow {
    
    private String ratedAt;
    private Integer rating;
    
    public ShowRating() {
    }

    public ShowRating(Pair<TraktExternalIds,Integer> idsWithRating) {
        this(idsWithRating.getKey(), idsWithRating.getValue());
    }
    
    public ShowRating(TraktExternalIds ids, Integer rating) {
        super(ids);
        this.rating = rating;
    }

    @JsonProperty("rated_at")
    public String getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(final String ratedAt) {
        this.ratedAt = ratedAt;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(final Integer rating) {
        this.rating = rating;
    }
}
