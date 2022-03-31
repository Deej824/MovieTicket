package com.codedifferently.MovieApiV3.domain.MovieTicket.services;


import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketNotCreatedException;
import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketNotFound;
import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketPurchaseException;
import com.codedifferently.MovieApiV3.domain.MovieTicket.model.MovieTicket;
import com.codedifferently.MovieApiV3.domain.cinema.components.exceptions.SeatNotFoundException;

public interface MovieTicketService {
//    MovieTicket create(MovieTicket movieTicket) throws MovieTicketNotCreatedException;
//    MovieTicket findById(Long id) throws MovieTicketNotFound;
//    MovieTicket update(MovieTicket movieTicket) throws MovieTicketNotFound;
//    void delete(Long id) throws MovieTicketNotFound;
    MovieTicket purchaseTicket (MovieTicket movieTicket) throws MovieTicketPurchaseException, SeatNotFoundException;
}
