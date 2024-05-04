package org.example.surveys;

import org.example.CSVFileReader;
import org.example.members.Members;
import org.example.participation.Participation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Surveys {
    private int id;
    private String name;
    private int expectedCompletes;
    private int completionPoints;
    private int filteredPoints;

    public Surveys() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExpectedCompletes() {
        return expectedCompletes;
    }

    public int getCompletionPoints() {
        return completionPoints;
    }

    public int getFilteredPoints() {
        return filteredPoints;
    }

    public Surveys(int id, String name, int expectedCompletes, int completionPoints, int filteredPoints) {
        this.id = id;
        this.name = name;
        this.expectedCompletes = expectedCompletes;
        this.completionPoints = completionPoints;
        this.filteredPoints = filteredPoints;
    }


    @Override
    public String toString() {
        return "Surveys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expectedCompletes=" + expectedCompletes +
                ", completionPoints=" + completionPoints +
                ", filteredPoints=" + filteredPoints +
                "}\n";
    }
}
