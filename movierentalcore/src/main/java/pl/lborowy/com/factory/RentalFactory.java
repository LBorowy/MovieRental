package pl.lborowy.com.factory;

import pl.lborowy.com.Rental;

import java.text.ParseException;

/**
 * Created by RENT on 2017-05-23.
 */
public class RentalFactory implements MyFactory<Rental> {

    @Override
    public Rental create(String text) {
        try {
            return new Rental(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
