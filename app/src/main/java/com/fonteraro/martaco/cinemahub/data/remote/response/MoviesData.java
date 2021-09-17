package com.fonteraro.martaco.cinemahub.data.remote.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fonteraro.martaco.cinemahub.data.model.db.Movie;

import java.util.Date;
import java.util.List;

public class MoviesData {

    @JsonProperty("data")
    private List<Movie> data = null;

    private Date lastRefresh;

    /**
     * No args constructor for use in serialization
     */
    public MoviesData() {
    }

    /**
     * @param data
     */
    public MoviesData(List<Movie> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<Movie> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Movie> data) {
        this.data = data;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}
