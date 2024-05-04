package org.example.statuses;

import org.example.CSVFileReader;

import java.util.ArrayList;
import java.util.List;

public class StatusesService {
    public List<Statuses> readInStatusesFromFile() {
        List<String[]> dataAsStringArrayList = CSVFileReader.readInDataFromFiles("OO - 2 - Statuses.csv");
        return convertToStatuses(dataAsStringArrayList);
    }

    private List<Statuses> convertToStatuses(List<String[]> dataAsStringArrayList) {
        List<Statuses> listOfStatues = new ArrayList<>();
        for(String[] data: dataAsStringArrayList){
            Statuses actSurvey = new Statuses(Integer.parseInt(data[0]), data[1]);
            listOfStatues.add(actSurvey);
        }
        return listOfStatues;
    }
}
