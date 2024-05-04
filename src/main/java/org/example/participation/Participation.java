package org.example.participation;

import org.example.CSVFileReader;
import org.example.statuses.Statuses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Participation {
    private int memberId;
    private int surveyId;
    private int status;
    private Integer length;

    public int getMemberId() {
        return memberId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public int getStatus() {
        return status;
    }

    public Integer getLength() {
        return length;
    }

    public Participation() {
    }

    public Participation(ParticipationBuilder participationBuilder) {
        this.memberId = participationBuilder.memberId;
        this.surveyId = participationBuilder.surveyId;
        this.status = participationBuilder.status;
        this.length = participationBuilder.length;
    }

    public static class ParticipationBuilder{
        private int memberId;
        private int surveyId;
        private int status;
        private Integer length;


        public ParticipationBuilder(int memberId, int surveyId, int status, Integer length) {
            this.memberId = memberId;
            this.surveyId = surveyId;
            this.status = status;
            this.length = length;
        }

        public Participation build() {
            return new Participation(this);
        }
    }


    @Override
    public String toString() {
        return "Participation{" +
                "memberId=" + memberId +
                ", surveyId=" + surveyId +
                ", status=" + status +
                ", length=" + length +
                "}\n";
    }
}
