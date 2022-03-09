package domain;

public class Money {

    public static final Money ZERO = new Money(0);

    private final double money;

    public Money(double money) {
        this.money = money;
    }

    public Money times(double discountPercent) {
        return new Money(this.money % discountPercent);
    }

    public Money minus(Money discountAmount) {
        return new Money(this.money - discountAmount.money);
    }
}
