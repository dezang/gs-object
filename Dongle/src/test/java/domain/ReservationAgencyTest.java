package domain;

import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationAgencyTest {

    @Test
    void reserveTest() {
        ReservationAgency reservationAgency = new ReservationAgency();
        List<DiscountCondition> conditions = List.of(
            new DiscountCondition(DiscountConditionType.PERIOD, 1, DayOfWeek.MONDAY, LocalTime.now(), LocalTime.now()));
        Movie movie = new Movie(MovieType.NONE_DISCOUNT, new Money(10000), new PercentDiscountPolicy(), conditions);
        Screening screening = new Screening(movie, 1, LocalDateTime.now());

        Reservation dongle = reservationAgency.reserve(screening, new Customer("Dongle", "124"), 5);

        assertEquals(dongle.getAudienceCount(), 5);
    }
}