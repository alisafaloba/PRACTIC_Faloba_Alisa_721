package org.example.Repo;




import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Modell.TrafficEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TrafficEventRepository implements IRepo<TrafficEvent, Integer> {
    private final File file = new File("C:\\Users\\Lenovo\\Documents\\Facultate\\Semestrul 3\\MAP\\Praktische Prufungen Modelle\\practic\\Practic\\src\\main\\resources\\events.json");
    private final ObjectMapper mapper = new ObjectMapper();

    private List<TrafficEvent> TrafficEvents = new ArrayList<>();

    private void loadData() {
        try {
            if (!file.exists() || file.length() == 0) {
                TrafficEvents = new ArrayList<>();
                return;
            }
            TrafficEvents = mapper.readValue(file,
                    new TypeReference<List<TrafficEvent>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<TrafficEvent> getAll() {
        loadData();
        return TrafficEvents;
    }

    @Override
    public TrafficEvent findById(Integer id) {
        loadData();
        return TrafficEvents.stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElse(null);
    }

}