package org.example.Repo;




import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Modell.Fine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FineRepository implements IRepo<Fine, Integer> {
    private final File file = new File("C:\\Users\\Lenovo\\Documents\\Facultate\\Semestrul 3\\MAP\\Praktische Prufungen Modelle\\practic\\Practic\\src\\main\\resources\\fines.json");
    private final ObjectMapper mapper = new ObjectMapper();

    private List<Fine> Fines = new ArrayList<>();

    private void loadData() {
        try {
            if (!file.exists() || file.length() == 0) {
                Fines = new ArrayList<>();
                return;
            }
            Fines = mapper.readValue(file,
                    new TypeReference<List<Fine>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Fine> getAll() {
        loadData();
        return Fines;
    }

    @Override
    public Fine findById(Integer id) {
        loadData();
        return Fines.stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElse(null);
    }

}