package pl.lborowy.com;

import pl.lborowy.com.exceptions.NullCustomerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * Created by RENT on 2017-05-24.
 */
public class AddCustomerWindow extends JFrame{
    private MovieRental movieRental;

    public static void main(String[] args) {
        MovieRental movieRental = new MovieRental();
        new AddCustomerWindow(movieRental);
    }

    public AddCustomerWindow(MovieRental movieRental) throws HeadlessException {

        this.movieRental = movieRental;

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,400);
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

        JButton button = new JButton("Dodaj");
        button.setSize(100,50);
        button.setLocation(0,300);
        add(button);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String pesel = peselTextField.getText();

                Customers customer = new Customers(pesel, firstName, lastName, "Wrocław", new Date());
                try {
                    movieRental.addCustomer(customer);
                    JOptionPane.showMessageDialog(button,"Udało się stworzyć klienta");
                } catch (NullCustomerException e1) {
                    e1.printStackTrace();
                }
            }
        });

        repaint();
    }
}
