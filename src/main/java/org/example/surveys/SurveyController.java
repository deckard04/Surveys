package org.example.surveys;

import org.example.members.Members;
import org.example.participation.Participation;

import java.util.List;

public class SurveyController {
    private final SurveysService surveysService;

    public SurveyController(SurveysService surveysService) {
        this.surveysService = surveysService;
    }

    public List<Surveys> listSurveys(){
        return surveysService.readInSurveysFromFiles();
    }

    public List<Surveys> listOfCompletedSurveysByParticipant(int number, List<Participation> participations, List<Surveys> surveys){
        return surveysService.completedSurveysByGivenPerson(number, participations, surveys);
    }


}
