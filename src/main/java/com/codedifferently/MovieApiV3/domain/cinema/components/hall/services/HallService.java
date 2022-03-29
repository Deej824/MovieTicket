package com.codedifferently.MovieApiV3.domain.cinema.components.hall.services;

import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.Hall;
import com.codedifferently.MovieApiV3.domain.movie.models.Movie;

public interface HallService {
    Hall create(Hall hall);
    Hall findById(Long id);
    Hall findByMovie (Movie movie);
}
