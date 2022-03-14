package domain;

public class AmountDiscountMovie implements DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountMovie(Money discountAmount) {
        this.discountAmount = discountAmount;
    }
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
