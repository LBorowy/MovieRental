package pl.lborowy.com.io;

import pl.lborowy.com.CsvObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2017-05-22.
 */
public class DataFileWriter {
//    public static void main(String[] args) {
//        List<Customers> customers = new ArrayList<>();
//        customers.add(new Customers("4324234", "Darek", "Bond", "Wrocław", new Date()));
//        customers.add(new Customers("432", "Andrzej", "Byk", "Sosnowiec", new Date()));
//
//        writeCustomersToFile("customers.csv", customers);
//    }
    public static void writeObjectsToFile(String fileName, List<? extends CsvObject> dataList) { // lista czegoś co jest typu CsvObject
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (CsvObject csvObject : dataList) {
                fileWriter.write(csvObject.toCSVString() + System.lineSeparator()); // + "\n"
            }

            fileWriter.flush(); // spłukanie
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
