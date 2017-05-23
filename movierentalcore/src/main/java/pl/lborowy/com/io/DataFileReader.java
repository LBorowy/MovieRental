package pl.lborowy.com.io;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import pl.lborowy.com.factory.MyFactory;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-05-22.
 */
public class DataFileReader <T> {
    private MyFactory<T> factory;


    public DataFileReader(MyFactory<T> factory) {
        this.factory = factory;
    }

    public List<T> readFromFile(String fileName) throws IOException {
        List<T> returnList = new ArrayList<>();

        List<String> fileLines = Files.readLines(new File(fileName), Charsets.UTF_8);

        for (String line : fileLines) {
            T object = factory.create(line);
            returnList.add(object);
        }
        return returnList;
    }
}
