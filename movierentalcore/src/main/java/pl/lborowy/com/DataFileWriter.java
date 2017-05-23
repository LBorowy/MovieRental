package pl.lborowy.com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2017-05-22.
 */
public class DataFileWriter {
    public static void main(String[] args) {
        List<Customers> customers = new ArrayList<>();
        customers.add(new Customers("4324234", "Darek", "Bond", "Wrocław", new Date()));
        customers.add(new Customers("432", "Andrzej", "Byk", "Sosnowiec", new Date()));

        writeCustomersToFile("customers.csv", customers);
    }
    public static void writeCustomersToFile(String fileName, List<Customers> customers) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (Customers customer : customers) {
                fileWriter.write(customer.toCSVString() + System.lineSeparator()); // + "\n"
            }

            fileWriter.flush(); // spłukanie
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
