package org.example.participation;

import org.example.CSVFileReader;

import java.util.ArrayList;
import java.util.List;

public class ParticipationService {
    public List<Participation> readInParticipationFromFile() {
        List<String[]> dataAsStringArrayList = CSVFileReader.readInDataFromFiles("OO - 2 - Participation.csv");
        return convertToParticipation(dataAsStringArrayList);
    }

    private static List<Participation> convertToParticipation(List<String[]> dataAsStringArrayList) {
        List<Participation> listOfParticipation = new ArrayList<>();
        for (String[] data : dataAsStringArrayList) {
            Participation actSurvey;
                actSurvey = new Participation.ParticipationBuilder(Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        (data.length < 4) ? null : Integer.parseInt(data[3]))
                        .build();
                listOfParticipation.add(actSurvey);
        }
        return listOfParticipation;
    }
}
