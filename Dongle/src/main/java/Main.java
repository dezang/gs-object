import domain.Customer;
import domain.Money;
import domain.Movie;
import domain.PercentDiscountPolicy;
import domain.Screening;

public class Main {

    public static void main(String[] args) {
        Movie hulk = new Movie(new Money(10000L), new PercentDiscountPolicy());
        Screening screening = new Screening(hulk);
        screening.reserve(new Customer("dongle"), 5);
    }
}
