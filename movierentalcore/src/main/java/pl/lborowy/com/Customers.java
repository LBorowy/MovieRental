package pl.lborowy.com;

import java.util.Date;

/**
 * Created by RENT on 2017-05-19.
 */
public class Customers {
    private static int nextId = 0;
    private int id;
    private String pesel;
    private String firstName;
    private String lastName;
    private String city;
    private Date date;

    public Customers(String pesel, String firstName, String lastName, String city, Date date) {
        this.id = nextId;
        nextId++;

        this.date = date;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
