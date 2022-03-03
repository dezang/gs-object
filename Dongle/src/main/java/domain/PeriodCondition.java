package domain;

public class PeriodCondition implements DiscountCondition {

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
