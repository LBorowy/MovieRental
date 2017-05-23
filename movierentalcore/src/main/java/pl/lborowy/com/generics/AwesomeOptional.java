package pl.lborowy.com.generics;

import pl.lborowy.com.Customers;

import java.awt.*;

/**
 * Created by RENT on 2017-05-23.
 */
public class AwesomeOptional <T> { // klasa, która przechowuje jakiś obiekt
    public static void main(String[] args) {
        String s = "ABS";
        AwesomeOptional<String> stringAwesomeOptional = new AwesomeOptional<>("ABC");
        String object = stringAwesomeOptional.getObject();

        AwesomeOptional<Integer> integerAwesomeOptional = new AwesomeOptional<>(1);
        Integer object1 = integerAwesomeOptional.getObject();

//        AwesomeOptional awesomeOptional = new AwesomeOptional(new Point());
//        System.out.println(awesomeOptional.isPresent());
//
//        String s2 = (String) awesomeOptional.getObject();
    }
    private T object;

    public AwesomeOptional(T object) {
        this.object = object;
    }

    public boolean isPresent() {
        return object != null;
    }

    public T getObject() {
        return object;
    }
}
