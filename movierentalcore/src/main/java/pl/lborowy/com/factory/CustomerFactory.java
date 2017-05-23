package pl.lborowy.com.factory;

import pl.lborowy.com.Customers;

import java.text.ParseException;

/**
 * Created by RENT on 2017-05-23.
 */
public class CustomerFactory implements MyFactory<Customers> {

    @Override
    public Customers create(String text) {
        try {
            return new Customers(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
