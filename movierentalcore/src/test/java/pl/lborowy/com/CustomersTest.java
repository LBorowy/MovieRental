package pl.lborowy.com;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-05-22.
 */
public class CustomersTest {
    @Test
    public void constructor_parseStringCorrectCase() throws ParseException {
        // given
        String text = "0,4324234,Darek,Bond,Wrocław,1970-01-01";

        // when
        Customers customers = new Customers(text);

        // then
        assertEquals("4324234", customers.getPesel());
        assertEquals("Darek", customers.getFirstName());
        assertEquals("Bond", customers.getLastName());
        assertEquals("Wrocław", customers.getCity());
        assertEquals(0, customers.getId());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(customers.DATE_PATTERN);
        assertEquals("1970-01-01", simpleDateFormat.format(customers.getDate()));
    }

    @Test
    public void toCSVString() throws Exception {
        // given
        Customers customers = new Customers("4324234", "Darek", "Bond", "Wrocław", new Date(0));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedString = customers.getId() + ",4324234,Darek,Bond,Wrocław," + simpleDateFormat.format(new Date(0));
//        System.out.println("Excepted: " + expectedString);
        // when
        String csvString = customers.toCSVString();
//        System.out.println(csvString);
        // then
        assertEquals(expectedString, csvString);
    }

}