package com.codedifferently.MovieApiV3.domain.customer.services;

import com.codedifferently.MovieApiV3.domain.MovieTicket.model.MovieTicket;
import com.codedifferently.MovieApiV3.domain.customer.exceptions.CustomerNotFoundException;
import com.codedifferently.MovieApiV3.domain.customer.models.Customer;

public interface CustomerService  {

    Customer create(Customer customer);
    Customer getById(Long id) throws CustomerNotFoundException;
    Customer getByFullName(String firstName, String lastName) throws CustomerNotFoundException;
    Customer update(Customer member) throws CustomerNotFoundException;
    void delete(Long id) throws CustomerNotFoundException;
    Iterable<MovieTicket> getAllMovieTickets(Long id);

}