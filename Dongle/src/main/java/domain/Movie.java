package domain;

public class Movie {

    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public Movie(Money fee, DiscountPolicy discountPolicy) {
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
