package org.example.Repo;




import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Modell.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class VehicleRepository implements IRepo<Vehicle, Integer> {
    private final File file = new File("C:\\Users\\Lenovo\\Documents\\Facultate\\Semestrul 3\\MAP\\Praktische Prufungen Modelle\\practic\\Practic\\src\\main\\resources\\vehicles.json");
    private final ObjectMapper mapper = new ObjectMapper();

    private List<Vehicle> Vehicles = new ArrayList<>();

    private void loadData() {
        try {
            if (!file.exists() || file.length() == 0) {
                Vehicles = new ArrayList<>();
                return;
            }
            Vehicles = mapper.readValue(file,
                    new TypeReference<List<Vehicle>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Vehicle> getAll() {
        loadData();
        return Vehicles;
    }

    @Override
    public Vehicle findById(Integer id) {
        loadData();
        return Vehicles.stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElse(null);
    }

}