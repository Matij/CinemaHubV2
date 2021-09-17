package com.fonteraro.martaco.cinemahub.data.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

@Entity(tableName = "movies")
public class Movie  implements SortedListAdapter.ViewModel {

    @PrimaryKey
    @JsonProperty("id")
    @ColumnInfo(name = "id")
    public Long id;

    @JsonProperty("title")
    @ColumnInfo(name = "title")
    public String title;

    @JsonProperty("year")
    @ColumnInfo(name = "year")
    public String year;

    @JsonProperty("genre")
    @ColumnInfo(name = "genre")
    public String genre;

    @JsonProperty("poster")
    @ColumnInfo(name = "poster")
    public String poster;

    /**
     * No args constructor for use in serialization
     *
     */
    public Movie() {
    }

    // --- GETTER ---

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

    // --- SETTER ---

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

    @Override
    public <T> boolean isSameModelAs(@NonNull T item) {
        if (item instanceof Movie) {
            final Movie movie = (Movie) item;
            return movie.id.equals(id);
        }
        return false;
    }

    @Override
    public <T> boolean isContentTheSameAs(@NonNull T item) {
        if (item instanceof Movie) {
            final Movie other = (Movie) item;
            return genre.equals(other.genre)
                    && (title != null ? title.equals(other.title) : other.title == null);
        }
        return false;
    }
}
