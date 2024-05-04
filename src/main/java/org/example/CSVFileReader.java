package org.example;

import org.example.surveys.Surveys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    public static List<String[]> readInDataFromFiles(String fileName){
        List<String[]> data = new ArrayList<>();
        ClassLoader classLoader = Surveys.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        String filePathAsString = file.toString().replace("%20", " ");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathAsString))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
