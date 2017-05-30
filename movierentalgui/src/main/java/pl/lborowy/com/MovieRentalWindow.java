package pl.lborowy.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by RENT on 2017-05-24.
 */
public class MovieRentalWindow extends JFrame {

    private JList<Customers> customersJList;
    private JList<Movie> movieJList;
    private JList<Rental> rentalsJList;

    private MovieRental movieRental;

    public static void main(String[] args) {
        MovieRental movieRental = new MovieRental(true);
        new MovieRentalWindow(movieRental);
    }

    public MovieRentalWindow(MovieRental movieRental) throws HeadlessException {
        this.movieRental = movieRental;

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,400);
        setLayout(new FlowLayout());
        setTitle("Wypożyczalnia filmów");

        customersJList = new JList<>();

        JScrollPane customerScrollPane = new JScrollPane(customersJList);
        customerScrollPane.setPreferredSize(new Dimension(300,200));
        add(customerScrollPane);

        movieJList = new JList<>();
        add(movieJList);

        rentalsJList = new JList<>();
        add(rentalsJList);


        JButton buttonAddCustomers = new JButton("Dodaj klienta");
        add(buttonAddCustomers);

        JButton buttonEditCustomers = new JButton("Edytuj klienta");
        add(buttonEditCustomers);

        MovieRentalWindow movieRentalWindow = this; // dzieki temu moge uzyc movieRentalWindow w buttonAddCustomers

        buttonAddCustomers.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEditCustomerWindow(movieRental, movieRentalWindow, null);
            }
        });

        buttonEditCustomers.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customers selectedCustomer = customersJList.getSelectedValue();
                if (selectedCustomer == null) {
                    JOptionPane.showMessageDialog(buttonAddCustomers, "Nie wybrano klienta");
                }
                new AddEditCustomerWindow(movieRental, movieRentalWindow, selectedCustomer);
            }
        });

        showCustomers();
        showMovies();
        showRentals();

        repaint();
    }


    public void showCustomers() {
        java.util.List<Customers> customersList = movieRental.getCustomers();

        // ZAMIANA LISTY KLIENTÓW NA TABLICĘ KLIENTÓW
        Customers[] customersArray = new Customers[customersList.size()];
        for (int i = 0; i < customersArray.length; i++) {
            customersArray[i] = customersList.get(i);
        }

        // ZAMIANA LISTY KLIENTÓW NA TABLICĘ KLIENTÓW - 2 SPOSÓB
        Customers[] customersArray2 = customersList.toArray(new Customers[customersList.size()]);

        customersJList.setListData(customersArray);
    }

    public void showMovies() {
        java.util.List<Movie> movieList = movieRental.getMovies();

        // ZAMIANA LISTY FILMÓW NA TABLICĘ FILMÓW
        Movie[] moviesArray = new Movie[movieList.size()];
        for (int i = 0; i < moviesArray.length; i++) {
            moviesArray[i] = movieList.get(i);
        }

        // ZAMIANA LISTY FILMÓW NA TABLICĘ FILMÓW - 2 SPOSÓB
        Movie[] moviesArray2 = movieList.toArray(new Movie[movieList.size()]);

        movieJList.setListData(moviesArray);
    }

    public void showRentals() {
        java.util.List<Rental> rentalsList = movieRental.getRentals();

        // ZAMIANA LISTY FILMÓW NA TABLICĘ FILMÓW
        Rental[] rentalsArray = new Rental[rentalsList.size()];
        for (int i = 0; i < rentalsArray.length; i++) {
            rentalsArray[i] = rentalsList.get(i);
        }

        // ZAMIANA LISTY FILMÓW NA TABLICĘ FILMÓW - 2 SPOSÓB
        Rental[] rentalArray2 = rentalsList.toArray(new Rental[rentalsList.size()]);

        rentalsJList.setListData(rentalsArray);
    }
}
