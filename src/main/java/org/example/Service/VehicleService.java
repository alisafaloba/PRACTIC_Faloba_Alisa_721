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

    public List<Vehicle> filternachTypUndStatus(String type, VehicleStatus status) throws IOException {
        return VehicleRepo.getAll().stream()
                .filter(b -> Objects.equals(b.getType().toString(), type) && b.getStatus() == status).collect(Collectors.toList());
    }

    public List<Vehicle> sortierenNachOwnerCity() throws IOException {
        return VehicleRepo.getAll().stream()
                .sorted(Comparator.comparing(Vehicle::getOwnerCity)
                        .thenComparing(Comparator.comparing(Vehicle::getId).reversed()))
                .collect(Collectors.toList());
    }
}