package org.example.members;

import org.example.CSVFileReader;
import org.example.participation.Participation;
import org.example.surveys.Surveys;

import java.util.ArrayList;
import java.util.List;

public class Members {

    private int id;
    private String fullName;
    private String emailAddress;
    private short isActive;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public short getIsActive() {
        return isActive;
    }

    public Members(MemberBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.emailAddress = builder.emailAddress;
        this.isActive = builder.isActive;
    }

    public static class MemberBuilder{
        private int id;
        private String fullName;
        private String emailAddress;
        private short isActive;

        public MemberBuilder(int id, String fullName, String emailAddress, short isActive) {
            this.id = id;
            this.fullName = fullName;
            this.emailAddress = emailAddress;
            this.isActive = isActive;
        }


        public void setId(int id) {
            this.id = id;
        }


        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public void setIsActive(short isActive) {
            this.isActive = isActive;
        }

        public Members build(){
            return new Members(this);
        }
    }


    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isActive=" + isActive +
                "}";
    }

}
