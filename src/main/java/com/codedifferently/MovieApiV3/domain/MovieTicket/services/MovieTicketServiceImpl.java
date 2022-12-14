package com.codedifferently.MovieApiV3.domain.MovieTicket.services;

import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketNotFoundException;
import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketPurchaseException;
import com.codedifferently.MovieApiV3.domain.MovieTicket.model.MovieTicket;
import com.codedifferently.MovieApiV3.domain.MovieTicket.repo.MovieTicketRepo;
import com.codedifferently.MovieApiV3.domain.cinema.components.exceptions.SeatNotFoundException;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.HallSeatRequest;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

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
    public MovieTicket update(MovieTicket movieTicket) throws MovieTicketNotFoundException {
        Long id = movieTicket.getId();
        Optional<MovieTicket> movieTicketExistOption = movieTicketRepo.findById(id);
        if (movieTicketExistOption.isEmpty())
            throw new MovieTicketNotFoundException("No Movie Ticket with id" +id );
        return movieTicketRepo.save(movieTicket);
    }

    @Override
    public void delete(Long id) throws MovieTicketNotFoundException {
        Optional<MovieTicket> MovieTicketExistOption = movieTicketRepo.findById(id);
        if (MovieTicketExistOption.isEmpty())
            throw new MovieTicketNotFoundException("No Movie Ticket with id" +id );
        MovieTicket movieTicket = MovieTicketExistOption.get();
        movieTicketRepo.delete(movieTicket);

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

