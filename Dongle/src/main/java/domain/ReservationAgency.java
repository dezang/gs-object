package domain;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();
        return new Reservation(customer, screening, movie.getFee(), audienceCount);
    }
}
