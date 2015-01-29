package com.github.fingolfintek.trakt.model;

import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.googlecode.jcsv.annotations.MapToColumn;

public class ImdbEntry {
    @MapToColumn(column = 0)
    private int position;
    
    @MapToColumn(column = 1)
    private String id;
    
    @MapToColumn(column = 2)
    private String created;
    
    @MapToColumn(column = 3)
    private String modified;
    
    @MapToColumn(column = 4)
    private String description;
    
    @MapToColumn(column = 5)
    private String title;
    
    @MapToColumn(column = 6)
    private String titleType;
    
    @MapToColumn(column = 7)
    private String directors;
    
    @MapToColumn(column = 8)
    private String rating;
    
    @MapToColumn(column = 9)
    private String imdbRating;
    
    @MapToColumn(column = 10)
    private String runtimeInMinutes;
    
    @MapToColumn(column = 11)
    private String year;
    
    @MapToColumn(column = 12)
    private String genres;
    
    @MapToColumn(column = 13)
    private String numberOfVotes;
    
    @MapToColumn(column = 14)
    private String releaseDate;
    
    @MapToColumn(column = 15)
    private String url;

    public int getPosition() {
        return position;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(final String modified) {
        this.modified = modified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(final String titleType) {
        this.titleType = titleType;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(final String directors) {
        this.directors = directors;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(final String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(final String runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public String getYear() {
        return year;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(final String genres) {
        this.genres = genres;
    }

    public String getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(final String numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
    
    public TraktExternalIds toIds() {
        final TraktExternalIds ids = new TraktExternalIds();
        ids.setImdb(id);
        return ids;
    }
    
    public boolean isShow() {
        return "TV Series".equals(titleType);
    }
}
