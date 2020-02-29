package net.dezang.gsobject.domain;

import java.math.BigDecimal;

public class Screening {
    private Movie movie;
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateFee(this).times(audienceCount);
    }
}
