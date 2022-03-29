package com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.services;

import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.exceptions.HallRowNotFoundException;
import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.models.HallRow;

public interface HallRowService {
    HallRow create(HallRow hallRow);
    HallRow findById(Long id) throws HallRowNotFoundException;
    HallRow update(HallRow hallRow) throws HallRowNotFoundException;
    void delete(Long id) throws HallRowNotFoundException;
}
