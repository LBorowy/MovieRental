package pl.lborowy.com;


import pl.lborowy.com.exceptions.MovieAlreadyExistException;
import pl.lborowy.com.exceptions.NullCustomerException;
import pl.lborowy.com.exceptions.NullMovieException;
import pl.lborowy.com.factory.CustomerFactory;
import pl.lborowy.com.factory.MovieFactory;
import pl.lborowy.com.factory.RentalFactory;
import pl.lborowy.com.io.DataFileReader;
import pl.lborowy.com.io.DataFileWriter;

import java.io.IOException;
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
//        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.movies = new ArrayList<>();

        ReadFromFile();
    }

    private void ReadFromFile() {
        DataFileReader<Customers> customersDataFileReader = new DataFileReader<>(new CustomerFactory());


        try {
            this.customers = customersDataFileReader.readFromFile("customers.csv");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania klientów z pliku");
            this.customers = new ArrayList<>(); // wyrzuci nową pustą listę
        }

        DataFileReader<Movie> movieDataFileReader = new DataFileReader<>(new MovieFactory());
        try {
            this.movies = movieDataFileReader.readFromFile("movies.csv");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania filmów z pliku");
            this.movies = new ArrayList<>();
        }

        DataFileReader<Rental> rentalDataFileReader = new DataFileReader<>(new RentalFactory());
        try {
            this.rentals = rentalDataFileReader.readFromFile("rentals.csv");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania wypożyczeń z pliku");
            this.rentals = new ArrayList<>();
        }
    }

    public void addCustomer(Customers customer) throws NullCustomerException {
        if(customer == null) {
            throw new NullCustomerException();
        }
        customers.add(customer);
        saveCustomersToFile();
    }

    public void addMovie(Movie movie) throws NullMovieException, MovieAlreadyExistException {
        if (movie == null) {
            throw new NullMovieException();
        }

        if (movies.contains(movie)) {
            throw new MovieAlreadyExistException();
        }

        movies.add(movie);
        saveMoviesToFile();
    }

    public void addRent(Rental rental) {
        // TODO handle errors
        rentals.add(rental);
        saveRentalsToFile();
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

    public void printAllData() {
        System.out.println("========== WYPOŻYCZALNIA ==========");
        System.out.println("===== CUSTOMERS ======");
        for (Customers customer : customers) {
            System.out.println(customer);
        }

        System.out.println("===== MOVIES =====");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println("===== RENTS =====");
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
        System.out.println("======================================");
    }

    public void saveCustomersToFile() {
        DataFileWriter.writeObjectsToFile("customers.csv", customers);
    }

    public void saveMoviesToFile() {
        DataFileWriter.writeObjectsToFile("movies.csv", movies);
    }

    public void saveRentalsToFile() {
        DataFileWriter.writeObjectsToFile("rentals.csv", rentals);
    }
}
