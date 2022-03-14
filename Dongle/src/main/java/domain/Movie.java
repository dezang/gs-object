package domain;

import java.time.Duration;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = discountConditions;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    protected Money getFee() {
        return fee;
    }

}
