package domain;

import java.util.List;

public class Movie {

    private final MovieType movieType;
    private final Money fee;
    private final DiscountPolicy discountPolicy;
    private final List<DiscountCondition> discountConditions;

    public Movie(MovieType movieType, Money fee, DiscountPolicy discountPolicy, List<DiscountCondition> discountConditions) {
        this.movieType = movieType;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
        this.discountConditions = discountConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money getDiscountAmount() {
        return null;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public double getDiscountPercent() {
        return 0;
    }
}