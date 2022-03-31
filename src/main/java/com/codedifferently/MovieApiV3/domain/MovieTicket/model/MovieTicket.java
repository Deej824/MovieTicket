package com.codedifferently.MovieApiV3.domain.MovieTicket.model;


import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.Hall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class MovieTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String desiredSeat;
    private String desiredRow;
    private LocalTime localTime;
    private Integer hallRoomNumber;


    public MovieTicket( ){

    }

    public MovieTicket(Integer hallRoomNumber, String desiredSeat,String desiredRow, LocalTime localTime) {
        this.desiredSeat = desiredSeat;
        this.localTime = localTime;
        this.hallRoomNumber = hallRoomNumber;
        this.desiredRow = desiredRow;
    }

    public String getDesiredSeat() {
        return desiredSeat;
    }

    public void setDesiredSeat(String desiredSeat) {
        this.desiredSeat = desiredSeat;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesiredRow() {
        return desiredRow;
    }

    public void setDesiredRow(String desiredRow) {
        this.desiredRow = desiredRow;
    }

    public Integer getHallRoomNumber() {
        return hallRoomNumber;
    }

    public void setHallRoomNumber(Integer hallRoomNumber) {
        this.hallRoomNumber = hallRoomNumber;
    }

    @Override
    public String toString() {
        return "MovieTicket{" +
                "id=" + id +
                ", desiredSeat='" + desiredSeat + '\'' +
                ", localTime=" + localTime +
                ", hallRoomNumber=" + hallRoomNumber +
                '}';
    }
}

