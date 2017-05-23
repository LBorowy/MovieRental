package pl.lborowy.com;

import org.junit.Test;
import pl.lborowy.com.exceptions.MovieAlreadyExistException;
import pl.lborowy.com.exceptions.NullCustomerException;
import pl.lborowy.com.exceptions.NullMovieException;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-05-22.
 */
public class MovieRentalTest {
    @Test
    public void addCustomer_correctCase() throws NullCustomerException {
        // given
        MovieRental movieRental = new MovieRental(); // wypożyczalnia
        Customers customer = new Customers("123456", "Michał","Szulc", "Wrocław", new Date()); // klient
        // when
        movieRental.addCustomer(customer);
        // then
        assertEquals(1, movieRental.getCustomers().size());
        assertTrue(movieRental.getCustomers().contains(customer)); // lista w wypożyczalni zawiera tego klienta
    }

    @Test(expected = NullCustomerException.class) // oczekuje NullCustomerException
    public void addCustomer_nullCustomer() throws NullCustomerException {
        // given
        MovieRental movieRental = new MovieRental();
        Customers customer = null;
        // when
        movieRental.addCustomer(customer);
    }

    @Test
    public void addMovie_correctCase() throws NullMovieException, MovieAlreadyExistException {
        // given
        MovieRental movieRental = new MovieRental();
        Movie movie = new Movie("2F2F", "action", "cars");
        // when
        movieRental.addMovie(movie);
        // then
        assertEquals(1, movieRental.getMovies().size());
        assertTrue(movieRental.getMovies().contains(movie)); // lista w wypożyczalni zawiera ten film
    }

    @Test(expected = NullMovieException.class) // oczekuje NullMovieException
    public void addMovie_nullCase() throws NullMovieException, MovieAlreadyExistException {
        //given
        MovieRental movieRental = new MovieRental();
        Movie movie = null;
        // when
        movieRental.addMovie(movie);
    }

    @Test(expected = MovieAlreadyExistException.class)
    public void addMovie_duplicate() throws NullMovieException, MovieAlreadyExistException {
        // given
        MovieRental movieRental = new MovieRental();
        Movie movie = new Movie("2F2F", "action", "cars");
        // when
        movieRental.addMovie(movie);
        movieRental.addMovie(movie);
    }

    @Test
    public void toCSVString() {

    }
}