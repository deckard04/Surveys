package org.example.surveys;

import org.example.CSVFileReader;
import org.example.participation.Participation;

import java.util.ArrayList;
import java.util.List;

public class SurveysService {
    public List<Surveys> readInSurveysFromFiles(){
        List<String[]> dataAsStringArrayList = CSVFileReader.readInDataFromFiles("OO - 2 - Surveys.csv");
        return convertToSurvey(dataAsStringArrayList);
    }

    private List<Surveys> convertToSurvey(List<String[]> dataAsStringArrayList) {
        List<Surveys> listOfSurveys = new ArrayList<>();
        for(String[] data: dataAsStringArrayList){
            Surveys actSurvey = new Surveys(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
            listOfSurveys.add(actSurvey);
        }
        return listOfSurveys;
    }

    public List<Surveys> completedSurveysByGivenPerson(int number, List<Participation> participations, List<Surveys> surveys){
        List<Surveys> listOfCompletedSurveysByGivenMembers = new ArrayList<>();
        for (Participation participation : participations) {
            if (participation.getMemberId() == number && participation.getStatus() == 4) {
                System.out.println(participation);
                Surveys actSurvey = surveys.get(surveys.get(participation.getSurveyId()).getId() - 2);
                listOfCompletedSurveysByGivenMembers.add(actSurvey);
            }
        }
        return listOfCompletedSurveysByGivenMembers;
    }
}
