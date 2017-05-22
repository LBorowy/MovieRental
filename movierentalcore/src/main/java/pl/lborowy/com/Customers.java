package pl.lborowy.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RENT on 2017-05-19.
 */
public class Customers {
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String CSV_SEPARATOR = ",";
    private static int nextId = 0;

    private int id;
    private String pesel;
    private String firstName;
    private String lastName;
    private String city;
    private Date date;

    // "0,4324234,Darek,Bond,Wrocław,1970-01-01"
    public Customers(String text) throws ParseException {
        String[] split = text.split(CSV_SEPARATOR);

        this.id = Integer.parseInt(split[0]);
        this.pesel = split[1];
        this.firstName = split[2];
        this.lastName = split[3];
        this.city = split[4];

        String dateString = split[5];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        this.date = simpleDateFormat.parse(dateString);
    }

    public Customers(String pesel, String firstName, String lastName, String city, Date date) {
        this.id = nextId;
        nextId++;

        this.date = date;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String toCSVString() {
        StringBuilder stringBuilder = new StringBuilder(); // bo łączenie Stringów jest zbyt wolne
        stringBuilder.append(id);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(pesel);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(firstName);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(lastName);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(city);
        stringBuilder.append(CSV_SEPARATOR);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        String formatDate = simpleDateFormat.format(date);
        stringBuilder.append(formatDate);

        return stringBuilder.toString();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
