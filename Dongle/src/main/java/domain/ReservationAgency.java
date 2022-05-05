package domain;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, customer, audienceCount, fee);
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                .minus(calculateDiscountedFee(screening.getMovie()))
                .times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

    private Money calculateDiscountedFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
                return calculatedPercentDiscountedFee(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee(movie);
        }

        throw new IllegalArgumentException();
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
        return Money.ZERO;
    }

    private Money calculatedPercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
            .anyMatch(discountCondition -> discountCondition.isDiscountable(screening));
    }

}
