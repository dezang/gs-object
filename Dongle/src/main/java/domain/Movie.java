package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions, MovieType movieType,
        Money discountAmount, double discountPercent) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = discountConditions;
        this.movieType = movieType;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.getType() == DiscountConditionType.PERIOD) {
                if (discountCondition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (discountCondition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != movieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != movieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != movieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }


    public MovieType getMovieType() {
        return movieType;
    }

}
