package domain;

import java.util.List;

public class PercentDiscountPolicy implements DiscountPolicy {

    private final List<SequenceCondition> sequenceCondition = List.of(new SequenceCondition());

    public Money calculateDiscountAmount(Screening screening) {
        for (SequenceCondition condition : sequenceCondition) {
            if (condition.isSatisfiedBy(screening)) {

            }
        }

        return null;
    }
}
