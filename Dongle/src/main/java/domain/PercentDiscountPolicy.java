package domain;

public class PercentDiscountPolicy implements DiscountPolicy {

    private double percent;

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return screening.getMovie().getFee().times(percent);
    }
}
