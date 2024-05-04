package org.example.participation;

import org.example.members.Members;
import org.example.surveys.Surveys;

import java.util.List;

public class ParticipationController {

    ParticipationService participationService;

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    public List<Participation> listOfParticipation(){
        return participationService.readInParticipationFromFile();
    }
}
