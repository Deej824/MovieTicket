package com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.services;

import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.exceptions.HallRowNotFoundException;
import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.models.HallRow;
import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.repos.HallRowRepo;
import com.codedifferently.MovieApiV3.domain.cinema.components.hallRow.models.HallSeat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
public class HallRowServiceImpl implements HallRowService{
    private static final Logger logger = LoggerFactory.getLogger(HallRowServiceImpl.class);
    private static final Integer MAX_SEATS_PER_ROW = 5;
    private HallRowRepo rowRepo;

    @Autowired
    public HallRowServiceImpl(HallRowRepo rowRepo){
        this.rowRepo = rowRepo;
    }

    @Override
    public HallRow create(HallRow hallRow) {
        String rowName = hallRow.getName();
        hallRow.setSeats(generateSeats(rowName));
        return rowRepo.save(hallRow);
    }

    @Override
    public HallRow findById(Long id) throws HallRowNotFoundException {
        Optional<HallRow> rowOptional = rowRepo.findById(id);
        if(rowOptional.isEmpty())
            throw new HallRowNotFoundException("Row Not Found");
        return rowOptional.get();
    }

    @Override
    public HallRow update(HallRow hallRow) throws HallRowNotFoundException{
        //Todo : finish Update
        return null;
    }

    @Override
    public void delete(Long id) throws HallRowNotFoundException {
        //Todo : finish delete
    }

    private Set<HallSeat> generateSeats(String rowName){
        Set<HallSeat> seats = new TreeSet<>();
        for(int x =1; x <= MAX_SEATS_PER_ROW; x++){
            String seatLocation = rowName+"_"+x;
            HallSeat seat = new HallSeat(seatLocation);
            logger.debug("Created a seat %s", seatLocation);
            seats.add(seat);
        }
        return seats;
    }

}
