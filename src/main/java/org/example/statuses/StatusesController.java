package org.example.statuses;

import org.example.surveys.Surveys;

import java.util.List;

public class StatusesController {

    StatusesService statusesService;

    public StatusesController(StatusesService statusesService) {
        this.statusesService = statusesService;
    }

    public List<Statuses> listOfStatuses(){
        return statusesService.readInStatusesFromFile();
    }
}
