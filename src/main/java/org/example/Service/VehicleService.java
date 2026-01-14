package org.example.Service;






import org.example.Modell.Vehicle;
import org.example.Modell.VehicleStatus;

import org.example.Repo.IRepo;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VehicleService {

    private final IRepo<Vehicle, Integer> VehicleRepo;

    public VehicleService(IRepo<Vehicle, Integer> VehicleRepo) {
        this.VehicleRepo = VehicleRepo;
    }

    public List<Vehicle> getAllVehicle() throws IOException {
        return VehicleRepo.getAll();
    }

    public Vehicle getVehicle(Integer id) throws IOException {
        return VehicleRepo.findById(id);
    }
}