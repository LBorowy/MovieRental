package pl.lborowy.com;


import pl.lborowy.com.exceptions.MovieAlreadyExistException;
import pl.lborowy.com.exceptions.NullCustomerException;
import pl.lborowy.com.exceptions.NullMovieException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-05-19.
 */
public class MovieRental {
    private List<Customers> customers;
    private List<Rental> rentals;
    private List<Movie> movies;

    public MovieRental() {
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void addCustomer(Customers customer) throws NullCustomerException {
        if(customer == null) {
            throw new NullCustomerException();
        }
        customers.add(customer);
    }

    public void addMovie(Movie movie) throws NullMovieException, MovieAlreadyExistException {
        if (movie == null) {
            throw new NullMovieException();
        }

        if (movies.contains(movie)) {
            throw new MovieAlreadyExistException();
        }

        movies.add(movie);
    }

    public void addRent(Rental rental) {
        // TODO handle errors
        rentals.add(rental);
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
