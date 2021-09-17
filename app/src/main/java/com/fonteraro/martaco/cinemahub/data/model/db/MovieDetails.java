package com.fonteraro.martaco.cinemahub.data.model.db;

public class MovieDetails {

    private Long id;

    private String title;

    private String year;

    private String genre;

    private String poster;

    private String plot;

    public MovieDetails() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPoster() {
        return poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
