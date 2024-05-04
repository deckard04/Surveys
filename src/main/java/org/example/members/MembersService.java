package org.example.members;

import org.example.CSVFileReader;
import org.example.participation.Participation;
import org.example.surveys.Surveys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MembersService {
    public List<Members> readInMembersFromFiles(){
        List<String[]> dataAsStringArrayList = CSVFileReader.readInDataFromFiles("OO - 2 - Members.csv");
        return convertToMembers(dataAsStringArrayList);
    }

    private List<Members> convertToMembers(List<String[]> dataAsStringArrayList) {
        List<Members> listOfMembers = new ArrayList<>();
        for(String[] data: dataAsStringArrayList){
            Members actMember = new Members.MemberBuilder(Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Short.parseShort(data[3]))
                    .build();
            listOfMembers.add(actMember);
        }
        return listOfMembers;
    }

    public List<Members> listOfGivenSurveyCompletedMembers(int number, List<Participation> participation, List<Members> members){
        List<Members> givenSurveyCompletedParticipants = new ArrayList<>();
        List<Participation> participations = participation.stream().filter(p -> p.getSurveyId() == number && p.getStatus() == 4).toList();
        for (Participation value : participations) {
            System.out.println(value.getMemberId());
            members.stream().filter(m -> m.getId() == value.getMemberId()).forEach(givenSurveyCompletedParticipants::add);
        }

        return givenSurveyCompletedParticipants;
    }

    public int collectedPointsByGivenMember(int number, List<Surveys> surveys, List<Participation> participation){
        int points = 0;
        for (int i = 0; i < participation.size(); i++) {
            if (participation.get(i).getMemberId() == number && participation.get(i).getStatus() == 4){
                points += surveys.get(participation.get(i).getSurveyId()-1).getCompletionPoints();
            }
            else if (participation.get(i).getMemberId() == number && participation.get(i).getStatus() == 3){
                points += surveys.get(participation.get(i).getSurveyId()-1).getFilteredPoints();
            }
        }
        return points;
    }

    public List<Members> CanBeInvitedMembersList(int number, List<Participation> participation, List<Members> members){
        List<Integer> idsOfCannotBeInvitedMembers = getAlreadyCompletedMembers(participation, number);
        List<Members> canBeInvitedMembersList = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            if (!idsOfCannotBeInvitedMembers.contains(members.get(i).getId()) && members.get(i).getIsActive() == 1){
                canBeInvitedMembersList.add(members.get(i));
            }
        }
        return canBeInvitedMembersList;
    }

    private List<Integer> getAlreadyCompletedMembers(List<Participation> participation, int number) {
        List<Integer> idsOfCannotBeInvitedMembers = new ArrayList<>();
        for (int i = 0; i < participation.size(); i++) {
            if (participation.get(i).getSurveyId() == number){
                idsOfCannotBeInvitedMembers.add(participation.get(i).getMemberId());
            }
        }
        return idsOfCannotBeInvitedMembers;
    }
}
