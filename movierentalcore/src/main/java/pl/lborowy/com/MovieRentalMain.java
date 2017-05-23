package pl.lborowy.com;

import pl.lborowy.com.exceptions.MovieAlreadyExistException;
import pl.lborowy.com.exceptions.NullCustomerException;
import pl.lborowy.com.exceptions.NullMovieException;

import java.util.Date;

/**
 * Created by RENT on 2017-05-23.
 */
public class MovieRentalMain {
    public static void main(String[] args) throws NullCustomerException, NullMovieException, MovieAlreadyExistException {
        MovieRental movieRental = new MovieRental();
        movieRental.printAllData();

        System.out.println("===== DODAJĘ KLIENTA =====");
        movieRental.addCustomer(new Customers("123", "Adam", "Kowalski", "Wrocław", new Date()));
        System.out.println("===== DODAJĘ FILM =====");
        movieRental.addMovie(new Movie("Terminator", "action", "good"));
        System.out.println("===== DODAJĘ WYPOŻYCZENIE =====");
        movieRental.addRent(new Rental(0,0));


        movieRental.printAllData();



    }
}
