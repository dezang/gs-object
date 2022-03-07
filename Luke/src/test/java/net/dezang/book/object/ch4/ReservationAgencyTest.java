package net.dezang.book.object.ch4;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationAgencyTest {
    @Test
    void reserve() {
        ReservationAgency reservationAgency = new ReservationAgency();
        Reservation reserve = reservationAgency.reserve(
                new Screening(new Movie(), 1, LocalDateTime.now()),
                new Customer("luke", "GoodGuy"),
                5
        );

        assertNotNull(reserve);
    }
}