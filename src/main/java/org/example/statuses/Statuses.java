package org.example.statuses;

import org.example.CSVFileReader;
import java.util.ArrayList;
import java.util.List;

public class Statuses {
    private int id;
    private String name;

    public Statuses() {
    }

    public Statuses(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Statuses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}\n";
    }
}
