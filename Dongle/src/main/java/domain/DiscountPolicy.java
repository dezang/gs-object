package domain;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
