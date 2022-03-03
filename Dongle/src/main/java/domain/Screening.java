package domain;

public class Screening {

    private final Movie movie;

    public Screening(Movie movie) {
        this.movie = movie;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        movie.calculateMovieFee(this);
        return new Reservation(customer, movie, audienceCount);
    }
}
