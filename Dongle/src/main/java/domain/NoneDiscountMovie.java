package domain;

public class NoneDiscountMovie implements DiscountPolicy {


    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
