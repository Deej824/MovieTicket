package com.codedifferently.MovieApiV3.domain.cinema.components.hall.services;

import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.Hall;
import com.codedifferently.MovieApiV3.domain.cinema.components.exceptions.HallNotFoundException;

public interface HallService {
    Hall create(Hall hall);
    Hall findById(Long id) throws HallNotFoundException;
 // Hall findByMovie (Movie movie)
    Hall updateHall(Hall hall) throws HallNotFoundException;
    void deleteHall (Long id) throws HallNotFoundException;
}
