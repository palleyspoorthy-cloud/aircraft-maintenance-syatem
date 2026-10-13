package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aircraft {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tailNumber;       // e.g., VT-ABC
    private String model;            // e.g., Boeing 737
    private String manufacturer;     // e.g., Boeing, Airbus
    private int totalFlightHours;
    private String status;           // Active, Under Maintenance, Grounded, Retired

    // No-argument constructor required by JPA
    public Aircraft() {}

    // Convenience constructor
    public Aircraft(String tailNumber, String model, String manufacturer, int totalFlightHours, String status) {
        this.tailNumber = tailNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.totalFlightHours = totalFlightHours;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTailNumber() { return tailNumber; }
    public void setTailNumber(String tailNumber) { this.tailNumber = tailNumber; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public int getTotalFlightHours() { return totalFlightHours; }
    public void setTotalFlightHours(int totalFlightHours) { this.totalFlightHours = totalFlightHours; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
