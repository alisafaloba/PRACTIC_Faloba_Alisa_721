package org.example.Service;

import org.example.Modell.TrafficEvent;

import org.example.Repo.IRepo;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TrafficEventService {

    private final IRepo<TrafficEvent, Integer> TrafficEventRepo;

    public TrafficEventService(IRepo<TrafficEvent, Integer> TrafficEventRepo) {
        this.TrafficEventRepo = TrafficEventRepo;
    }

    public List<TrafficEvent> getAllTrafficEvent() throws IOException {
        return TrafficEventRepo.getAll();
    }

    public TrafficEvent getTrafficEvent(Integer id) throws IOException {
        return TrafficEventRepo.findById(id);
    }

//    . (1.5 Punkte) Berechnung des Risikoscores
//    Für jedes Verkehrsereignis wird ein Risikowert
//            (riskScore) berechnet. Implementieren Sie eine Methode,
//    die den Risikowert ausschließlich anhand des Event-Typs
//    und der Schwere (severity) berechnet.
//    Regeln zur Berechnung:
//            ● SPEEDING → riskScore = severity * 2
//            ● RED_LIGHT → riskScore = severity * 3
//            ● ACCIDENT → riskScore = severity * 5
//            ● PRIORITY_PASS → riskScore = severity * 1
//    Berechnen Sie den Risikowert für die ersten 5 Ereignisse
//    aus der Datei events.json und geben Sie diese in
//    folgender Form auf der Konsole aus:
//    Event <id> -> severity=<severity> ->
//    riskScore=<riskScore>
    public int calculateComputedPoints(int id) {
        TrafficEvent te = TrafficEventRepo.findById(id);
        int points = te.getSeverity();
        int riskscore;


        return switch (te.getEventType()) {
            case  SPEEDING-> points*2;
            case  RED_LIGHT-> points*3;
            case ACCIDENT -> points*5;
            case PRIORITY_PASS ->  points*1;
            default -> points;
        };

    }
    public void executeTask5() throws IOException {
        List<TrafficEvent> top5Events = TrafficEventRepo.getAll().stream()
                .limit(5)
                .collect(Collectors.toList());

        for (TrafficEvent event : top5Events) {
            int riskScore = calculateComputedPoints(event.getId());
            System.out.println("Event " + event.getId() + " -> severity=" + event.getSeverity() + " -> riskScore=" + riskScore);
        }
    }
}

