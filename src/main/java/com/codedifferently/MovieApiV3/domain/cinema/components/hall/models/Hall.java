package com.codedifferently.MovieApiV3.domain.cinema.components.hall.models;

import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.models.HallRow;
import com.codedifferently.MovieApiV3.domain.movie.models.Movie;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Hall {

    @Id
    @GeneratedValue
    private Long id;

    private Integer roomNumber;

    @ManyToOne
    @JoinColumn(name= "movieId")
    private Movie movie;

    private LocalTime showTime;

    public Hall() {
    }

    public Hall(Integer roomNumber, Set<HallRow> rows, Movie movie, LocalTime showTime) {
        this.roomNumber = roomNumber;
        this.movie = movie;
        this.showTime = showTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }


}
