package pl.lborowy.com;

import pl.lborowy.com.exceptions.NullCustomerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * Created by RENT on 2017-05-24.
 */
public class AddEditCustomerWindow extends JFrame{
    private MovieRental movieRental;
    private MovieRentalWindow movieRentalWindow; // stworzenie nowego pola
    private Customers customersToEdit;


//    public static void main(String[] args) {
//        new AddEditCustomerWindow(new MovieRental(), null, null);
//    }


    public AddEditCustomerWindow(MovieRental movieRental, MovieRentalWindow movieRentalWindow, Customers customerToEdit) throws HeadlessException {

        this.movieRental = movieRental;
        this.movieRentalWindow = movieRentalWindow; // zapamiętywanie pola
        this.customersToEdit = customerToEdit;

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,600);
        setLayout(null);
        setTitle("Rental Window");

        JLabel firstName = new JLabel("First Name");
        firstName.setSize(100,50);
        firstName.setLocation(0,0);
        add(firstName);

        JTextField firstNameTextField = new JTextField();
        firstNameTextField.setSize(100,50);
        firstNameTextField.setLocation(0,50);
        add(firstNameTextField);

        JLabel lastName = new JLabel("Last Name");
        lastName.setSize(100,50);
        lastName.setLocation(0,100);
        add(lastName);

        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setSize(100,50);
        lastNameTextField.setLocation(0,150);
        add(lastNameTextField);

        JLabel pesel = new JLabel("Pesel");
        pesel.setSize(100,50);
        pesel.setLocation(0,200);
        add(pesel);

        JTextField peselTextField = new JTextField();
        peselTextField.setSize(100,50);
        peselTextField.setLocation(0,250);
        add(peselTextField);

        JLabel city = new JLabel("Miasto");
        city.setSize(100,50);
        city.setLocation(0,300);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setSize(100,50);
        cityTextField.setLocation(0,350);
        add(cityTextField);

        JButton buttonAddEdit = new JButton("Dodaj/Edytuj");
        buttonAddEdit.setSize(150,50);
        buttonAddEdit.setLocation(0,450);
        add(buttonAddEdit);

        if(customerToEdit != null) {
            cityTextField.setText(customerToEdit.getCity());
            firstNameTextField.setText(customerToEdit.getFirstName());
            lastNameTextField.setText(customerToEdit.getLastName());
            peselTextField.setText(customerToEdit.getPesel());
        }

        buttonAddEdit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String pesel = peselTextField.getText();
                String city = cityTextField.getText();

                if (customerToEdit == null) {
                    Customers customer = new Customers(pesel, firstName, lastName, city, new Date());
                    try {
                        movieRental.addCustomer(customer);
                        movieRentalWindow.showCustomers(); // metoda odświeżająca w głównym oknie

                        JOptionPane.showMessageDialog(buttonAddEdit,"Udało się stworzyć klienta!");
                    } catch (NullCustomerException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    customerToEdit.setCity(city);
                    customerToEdit.setLastName(lastName);
                    customerToEdit.setFirstName(firstName);
                    customerToEdit.setPesel(pesel);
                    JOptionPane.showMessageDialog(buttonAddEdit, "Udało się zmienić dane klienta!");
                }
                movieRentalWindow.showCustomers();

                // Zamkniecie okna
                setVisible(false);
                dispose();

                movieRental.printAllData();
            }
        });

        repaint();
    }
}
