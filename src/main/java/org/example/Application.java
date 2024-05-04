package org.example;

import org.example.SurveyStats.SurveyStats;
import org.example.members.MemberController;
import org.example.members.Members;
import org.example.members.MembersService;
import org.example.participation.Participation;
import org.example.participation.ParticipationController;
import org.example.participation.ParticipationService;
import org.example.statuses.Statuses;
import org.example.statuses.StatusesController;
import org.example.statuses.StatusesService;
import org.example.surveys.SurveyController;
import org.example.surveys.Surveys;
import org.example.surveys.SurveysService;

import java.util.List;
import java.util.Scanner;

public class Application {

    static final SurveyController surveyController = new SurveyController(new SurveysService());
    static final ParticipationController participationController = new ParticipationController(new ParticipationService());
    static final MemberController memberController = new MemberController(new MembersService());
    public static void run(){
        choose();
    }

    public static void choose() {
        List<Members> listOfMembers = memberController.listOfMembers();
        List<Participation> listOfParticipation = participationController.listOfParticipation();
        List<Surveys> listOfSurvey = surveyController.listSurveys();
        while (true) {
            System.out.println("\nVálasszon opciót");
            System.out.println("1:Adott kérdőívet kitöltők (Completed státuszúak) listája\n" +
                    "2:Adott személy által kitöltött (Completed státuszú) kérdőívek listája\n" +
                    "3:Adott személy által eddig gyűjtött pontok lekérdezése\n" +
                    "4:Adott kérdőívre meghívható (Még nem vett részt ebben a felmérésben és státusza aktív) személyek listázása\n");
            Scanner sc = new Scanner(System.in);
            int chooseNumber = sc.nextInt();
            switch (chooseNumber) {
                case 1:
                    System.out.println("Írja be a kívánt kérdőív Id-ját");
                    int surveyId = sc.nextInt();
                    List<Members> surveyCompletedMembers = memberController.listOfGivenSurveyParticipantMembers(surveyId, listOfParticipation, listOfMembers);
                    for (int i = 0; i < surveyCompletedMembers.size(); i++) {
                        System.out.println(surveyCompletedMembers.get(i).getFullName() + " " + surveyCompletedMembers.get(i).getId());
                    }
                    break;
                case 2:
                    System.out.println("írja be a kívánt személy Id-ját");
                    int memberId = sc.nextInt();
                    List<Surveys> completedSurveysByTheGivenPerson = surveyController.listOfCompletedSurveysByParticipant(memberId, listOfParticipation, listOfSurvey);
                    for (int i = 0; i < completedSurveysByTheGivenPerson.size(); i++) {
                        System.out.println("ID: " + completedSurveysByTheGivenPerson.get(i).getId() + ", Név: " + completedSurveysByTheGivenPerson.get(i).getName());
                    }
                    break;
                case 3:
                    System.out.println("Írja be a kívánt személy Id-ját");
                    int givenMemberId = sc.nextInt();
                    int givenMemberPoints = memberController.collectedPointByGivenPerson(givenMemberId, listOfSurvey, listOfParticipation);
                    System.out.printf("Id: %d felhasználó által gyűjtött pontok száma: %d", givenMemberId, givenMemberPoints);
                    break;
                case 4:
                    System.out.println("Írja be a kívánt kérdőív Id-ját");
                    int givenSurveyId = sc.nextInt();
                    List<Members> canBeInvitedMembers = memberController.listOfCanBeInvitedMembers(givenSurveyId, listOfParticipation, listOfMembers);
                    for (Members member : canBeInvitedMembers) {
                        System.out.println(member.getId() + " " + member.getFullName());
                    }
                    break;
                case 5:
                    System.out.println("A kérdőívek statisztikái");
                    List<SurveyStats> surveysWithStats;
            }
        }
    }
}
