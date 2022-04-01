package com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions;

public class MovieTicketNotFoundException extends Exception{
    public MovieTicketNotFoundException(String msg){
        super (msg);
    }
}
