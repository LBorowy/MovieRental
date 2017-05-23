package pl.lborowy.com.factory;


import pl.lborowy.com.Movie;

/**
 * Created by RENT on 2017-05-23.
 */
public class MovieFactory implements MyFactory<Movie> {

    @Override
    public Movie create(String text) {
        return new Movie(text);
    }
}
