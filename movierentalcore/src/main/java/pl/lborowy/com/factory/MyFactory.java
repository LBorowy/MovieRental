package pl.lborowy.com.factory;

/**
 * Created by RENT on 2017-05-23.
 */
public interface MyFactory <T> {
    T create(String text);
}
