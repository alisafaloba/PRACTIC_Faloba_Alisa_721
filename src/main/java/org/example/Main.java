package org.example;

import org.example.Modell.*;
import org.example.Repo.FineRepository;
import org.example.Repo.IRepo;
import org.example.Repo.TrafficEventRepository;
import org.example.Repo.VehicleRepository;
import org.example.Service.TrafficEventService    ;
import org.example.Service.VehicleService;
import org.example.Service.FineService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        IRepo<Fine, Integer> FineRepo = new FineRepository();
        IRepo<TrafficEvent, Integer> TrafficEventRepo = new TrafficEventRepository();
        IRepo<Vehicle, Integer> VehicleRepo = new VehicleRepository();
        TrafficEventService TrafficEventService = new TrafficEventService(TrafficEventRepo);
        VehicleService VehicleService = new VehicleService(VehicleRepo);
        FineService FineService = new FineService(FineRepo);


        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Anzahl der Vehicles,Ereignise und Fines und alle Vehicles anzeigen");
            System.out.println("2 - Filtern Vehcles nach Typ und Status");
            System.out.println("3 - Sortieren nach ownerCity ");
            System.out.println("4 - Sortierte Liste in der Datei speichern");
            System.out.println("5 - Top5 Ereignise nach berechneten Punkten anzeigen");
            System.out.println("6 - Berechne Total Scores pro Fahrer");
            System.out.println("7 - Vereine loschen");
            System.out.println("8 - Vereine aktualisieren");
            System.out.println("0 - Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Fahrer loaded " + (long) VehicleRepo.getAll().size());
                    System.out.println("Ereignise loaded " + (long) TrafficEventRepo.getAll().size());
                    System.out.println("Strafen loaded " + (long) FineRepo.getAll().size());
                    List<Vehicle> allFahrer = VehicleService.getAllVehicle();
                    allFahrer.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Geben Sie den Fahrzeugtyp ein: ");
                    String type = sc.nextLine();
                    System.out.print("Geben Sie den Fahrzeugstatus ein: ");
                    String status = sc.nextLine();
                    List<Vehicle> filteredVehicles = VehicleService.filternachTypUndStatus(type, VehicleStatus.valueOf(status));
                    filteredVehicles.forEach(System.out::println);
                    break;
                case 3:
                    List<Vehicle> sortedVehicles = VehicleService.sortierenNachOwnerCity();
                    sortedVehicles.forEach(System.out::println);
                    break;
                case 4:
                    List<Vehicle> sortedVehicles1 = VehicleService.sortierenNachOwnerCity();
                    String filePath = "sorted_fahrer.txt";
                    try {
                        Files.write(
                                Paths.get(filePath),
                                sortedVehicles1.stream()
                                        .map(Vehicle::toString)
                                        .collect(Collectors.toList())
                        );
                        System.out.println("Die sortierte Liste der Fahrer wurde in der Datei " + filePath + " gespeichert.");
                    } catch (IOException e) {
                        System.out.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
                    }
                    break;

            }
        }
    }
}