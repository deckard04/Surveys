package org.example;

import org.example.members.MemberController;
import org.example.members.Members;
import org.example.participation.Participation;
import org.example.participation.ParticipationController;
import org.example.statuses.Statuses;
import org.example.statuses.StatusesController;
import org.example.surveys.SurveyController;
import org.example.surveys.Surveys;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Surveys.readInSurveysFromFiles("OO - 2 - Surveys.csv");
        Application.run();
    }
}