package com.codedifferently.MovieApiV3.domain.MovieTicket.services;

import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketPurchaseException;
import com.codedifferently.MovieApiV3.domain.MovieTicket.model.MovieTicket;
import com.codedifferently.MovieApiV3.domain.MovieTicket.repo.MovieTicketRepo;
import com.codedifferently.MovieApiV3.domain.cinema.components.exceptions.SeatNotFoundException;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.Hall;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.HallSeatRequest;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.services.HallService;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.services.HallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    private MovieTicketRepo movieTicketRepo;
    private HallService hallService;

    @Autowired
    public MovieTicketServiceImpl(MovieTicketRepo movieTicketRepo, HallService hallService) {
        this.movieTicketRepo = movieTicketRepo;
        this.hallService=hallService;
    }


    @Override
    public MovieTicket purchaseTicket(HallSeatRequest hallSeatRequest, LocalTime localTime) throws MovieTicketPurchaseException, SeatNotFoundException {

        MovieTicket movieTicket;
        Boolean isDesiredSeatAvailable = hallService.checkStatusOfSeat(hallSeatRequest);
        if (!isDesiredSeatAvailable){
            hallService.reserveSeat(hallSeatRequest);
            movieTicket= new MovieTicket(hallSeatRequest, localTime);
        }
        else throw new MovieTicketPurchaseException( "Could not purchase ticket");


        return movieTicketRepo.save(movieTicket) ;
    }
}

