package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aircraft aircraft; // Links record directly to a specific aircraft asset

    private String maintenanceType; // Daily, A-Check, B-Check, Engine, Avionics
    private String description;
    private LocalDate dateStarted;
    private String technicianName;
    private String partsUsed;
    private String status;          // Scheduled, In-Progress, Completed

    // No-arg constructor required by JPA
    public MaintenanceRecord() {}

    // Convenience constructor
    public MaintenanceRecord(Aircraft aircraft, String maintenanceType, String description, 
                             LocalDate dateStarted, String technicianName, String partsUsed, String status) {
        this.aircraft = aircraft;
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.dateStarted = dateStarted;
        this.technicianName = technicianName;
        this.partsUsed = partsUsed;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Aircraft getAircraft() { return aircraft; }
    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public String getMaintenanceType() { return maintenanceType; }
    public void setMaintenanceType(String maintenanceType) { this.maintenanceType = maintenanceType; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDateStarted() { return dateStarted; }
    public void setDateStarted(LocalDate dateStarted) { this.dateStarted = dateStarted; }
    public String getTechnicianName() { return technicianName; }
    public void setTechnicianName(String technicianName) { this.technicianName = technicianName; }
    public String getPartsUsed() { return partsUsed; }
    public void setPartsUsed(String partsUsed) { this.partsUsed = partsUsed; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
