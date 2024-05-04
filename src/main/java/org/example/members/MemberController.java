package org.example.members;

import org.example.participation.Participation;
import org.example.surveys.Surveys;

import java.util.List;

public class MemberController {

    MembersService membersService;

    public MemberController(MembersService membersService) {
        this.membersService = membersService;
    }

    public List<Members> listOfMembers(){
        return membersService.readInMembersFromFiles();
    }

    public List<Members> listOfGivenSurveyParticipantMembers(int number, List<Participation> participations, List<Members> members){
        return this.membersService.listOfGivenSurveyCompletedMembers(number, participations, members);
    }

    public int collectedPointByGivenPerson(int number, List<Surveys> surveys, List<Participation> participations){
        return this.membersService.collectedPointsByGivenMember(number, surveys, participations);
    }

    public List<Members> listOfCanBeInvitedMembers(int number, List<Participation> participations, List<Members> members){
        return this.membersService.CanBeInvitedMembersList(number, participations, members);
    }

}
