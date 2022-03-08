package domain;

public class Money {

    public static final Money ZERO = new Money(0);
    int money = 0;

    public Money(int money) {
        this.money = money;
    }

    public Money times(double discountPercent) {
        return null;
    }

    public Money minus(Money discountAmount) {
        return null;
    }
}
