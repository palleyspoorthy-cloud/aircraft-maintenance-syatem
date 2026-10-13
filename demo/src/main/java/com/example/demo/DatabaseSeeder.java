package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(AircraftRepository airRepo, MaintenanceRecordRepository maintRepo, SparePartRepository partRepo) {
        return args -> {
            if (airRepo.count() == 0) {
                Random rand = new Random();
                String[] models = {"737 Max", "A320 Neo", "787 Dreamliner", "A350-900", "777-300ER"};
                String[] manufacturers = {"Boeing", "Airbus", "Boeing", "Airbus", "Boeing"};
                String[] statuses = {"Active", "Under Maintenance", "Grounded"};
                
                List<Aircraft> createdAircrafts = new ArrayList<>();

                // Seed exactly 50 Aircraft entries into fleet inventory matrix
                for (int i = 1; i <= 50; i++) {
                    String tailNumber = "VT-A" + String.format("%02d", i);
                    int modelIndex = rand.nextInt(models.length);
                    int flightHours = 500 + rand.nextInt(8000);
                    String status = statuses[rand.nextInt(statuses.length)];
                    
                    Aircraft aircraft = new Aircraft(tailNumber, models[modelIndex], manufacturers[modelIndex], flightHours, status);
                    createdAircrafts.add(airRepo.save(aircraft));
                }

                // Seed exactly 100 historical service data records
                String[] checkTypes = {"A-Check", "Engine Inspection", "Avionics Check", "Daily Inspection", "Hydraulic Overhaul"};
                String[] technicians = {"Ravi Kumar", "Anil Sharma", "Priya Singh", "Vikram Malhotra", "Neha Gupta"};
                String[] recordStatuses = {"Completed", "In-Progress", "Scheduled"};

                for (int j = 1; j <= 100; j++) {
                    Aircraft targetAircraft = createdAircrafts.get(rand.nextInt(createdAircrafts.size()));
                    String type = checkTypes[rand.nextInt(checkTypes.length)];
                    String tech = technicians[rand.nextInt(technicians.length)];
                    String recStatus = recordStatuses[rand.nextInt(recordStatuses.length)];
                    
                    maintRepo.save(new MaintenanceRecord(
                        targetAircraft, type, "Automated system check lifecycle milestone index #" + j, 
                        LocalDate.now().minusDays(rand.nextInt(30)), tech, "Standard Service Kit PK-" + j, recStatus
                    ));
                }

                // Seed exactly 100 hardware components into inventory ledger registry
                String[] partPrefixes = {"ENG", "HYD", "BRK", "AV", "STR", "NUC", "CAB", "LND"};
                String[] partNames = {"Fuel Injector Valve", "Hydraulic Actuator Pump", "Carbon Brake Pad", "Altimeter Transponder", "Fuselage Rivet", "Oxygen Delivery Mask", "LED Cabin Light", "Landing Gear Swivel"};
                String[] bays = {"Bay A-", "Bay B-", "Bay C-", "Bay D-", "Vault-0"};

                for (int k = 1; k <= 100; k++) {
                    int typeIndex = rand.nextInt(partNames.length);
                    String partNum = partPrefixes[typeIndex] + "-" + String.format("%03d", k);
                    String name = partNames[typeIndex] + " v" + (1 + rand.nextInt(4));
                    String loc = bays[rand.nextInt(bays.length)] + (1 + rand.nextInt(5));
                    
                    int minLimit = 2 + rand.nextInt(6);
                    int currentStock = 1 + rand.nextInt(15);
                    
                    partRepo.save(new SparePart(partNum, name, currentStock, minLimit, loc));
                }
            }
        };
    }
}
