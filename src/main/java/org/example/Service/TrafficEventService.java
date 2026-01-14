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
}

