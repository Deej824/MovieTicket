package com.codedifferently.MovieApiV3.domain.cinema.components;

import com.codedifferently.MovieApiV3.domain.MovieTicket.exceptions.MovieTicketPurchaseException;
import com.codedifferently.MovieApiV3.domain.MovieTicket.model.MovieTicket;
import com.codedifferently.MovieApiV3.domain.MovieTicket.repo.MovieTicketRepo;
import com.codedifferently.MovieApiV3.domain.MovieTicket.services.MovieTicketService;
import com.codedifferently.MovieApiV3.domain.cinema.components.exceptions.SeatNotFoundException;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.Hall;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.models.HallSeatRequest;
import com.codedifferently.MovieApiV3.domain.cinema.components.hall.services.HallService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MovieTicketServiceTest {

    @MockBean
    HallService hallService;

    @MockBean
    MovieTicketService movieTicketService;

    @Autowired
    MovieTicketRepo movieTicketRepo;

    private MovieTicket input;
    private MovieTicket output;

    @BeforeEach
    public void setUp(){
        input = new MovieTicket(1,"2", "A",LocalTime.now());
        output = new MovieTicket(1,"2", "A",LocalTime.now());

    }

    @Test
    @DisplayName("Purchase MovieTicket Successfully")
    public void PurchaseTicketTest01() throws MovieTicketPurchaseException, SeatNotFoundException {

        movieTicketService.purchaseTicket(input);
        Assertions.assertNotNull(movieTicketService.purchaseTicket(input));
    }
}
