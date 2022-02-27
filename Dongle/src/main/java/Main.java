import domain.Customer;
import domain.DiscountPolicy;
import domain.Money;
import domain.Movie;
import domain.Screening;

public class Main {

    public static void main(String[] args) {
        Screening screening = new Screening(new Movie(new Money(10000L), new DiscountPolicy()));
        screening.reserve(new Customer("dongle"), 5);
    }
}
