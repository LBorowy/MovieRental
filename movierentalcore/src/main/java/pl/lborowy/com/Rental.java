package pl.lborowy.com;

import java.util.Date;

/**
 * Created by RENT on 2017-05-19.
 */
public class Rental {
    private int customerId;
    private int movieId;
    private Date date;

    public Rental(int customerId, int movieId) {
        this.customerId = customerId;
        this.movieId = movieId;
        this.date = new Date();
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public Date getDate() {
        return date;
    }
}
