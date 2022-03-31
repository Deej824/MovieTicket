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
    public MovieTicketServiceImpl(MovieTicketRepo movieTicketRepo) {
        this.movieTicketRepo = movieTicketRepo;
    }

    @Override
    public MovieTicket purchaseTicket(MovieTicket movieTicket) throws MovieTicketPurchaseException, SeatNotFoundException {
        // movieTicket.getDesiredSeat
        // Send in a HallSeatRequest
        //Use Hall Service to check to see if seat is available using the checkStatusofSeat method
        // If seat is available we will call reserveSeat method and send in our desired seat.
        // MovieTicketRepo saves the ticket
        HallSeatRequest hallSeatRequest = new HallSeatRequest(new Hall(movieTicket.getHallRoomNumber(), LocalTime.now()),movieTicket.getDesiredRow(), movieTicket.getDesiredSeat());

       Boolean isDesiredSeatAvailable = hallService.checkStatusOfSeat(hallSeatRequest);

       if (isDesiredSeatAvailable){
           hallService.reserveSeat(hallSeatRequest);
           movieTicketRepo.save(movieTicket);
       }
       else throw new MovieTicketPurchaseException("Could not purchase ticket");


        return movieTicketRepo.save(movieTicket) ;
    }
    }

