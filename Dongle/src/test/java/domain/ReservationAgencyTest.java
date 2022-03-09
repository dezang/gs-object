package domain;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

class ReservationAgencyTest {

    @Test
    void reserve() {
        ReservationAgency reservation = new ReservationAgency();

        Duration duration = Duration.of(60, ChronoUnit.MILLIS);
        Movie givenMovie = new Movie("Movie", duration, new Money(10000), List.of(new DiscountCondition()), MovieType.NONE_DISCOUNT, Money.ZERO, 0);
        Screening givenScreening = new Screening(givenMovie, 0, LocalDateTime.now());
        Customer givenCustomer = new Customer("Doongle", "id");
        Reservation reserve = reservation.reserve(givenScreening, givenCustomer, 10);

    }
}