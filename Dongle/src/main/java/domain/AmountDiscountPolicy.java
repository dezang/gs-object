package domain;

import java.util.List;

public class AmountDiscountPolicy implements DiscountPolicy {

    private final List<SequenceCondition> sequenceCondition = List.of(new SequenceCondition());

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (SequenceCondition condition : sequenceCondition) {
            if (condition.isSatisfiedBy(screening)) {

            }
        }

        return null;
    }
}
