package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partNumber;  // e.g., ENG-001
    private String partName;    // e.g., Engine Filter
    private int currentStock;
    private int minimumStock;   // Triggers low stock alert flag if currentStock <= minimumStock
    private String warehouseLocation;

    public SparePart() {}

    public SparePart(String partNumber, String partName, int currentStock, int minimumStock, String warehouseLocation) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
        this.warehouseLocation = warehouseLocation;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    public int getCurrentStock() { return currentStock; }
    public void setCurrentStock(int currentStock) { this.currentStock = currentStock; }
    public int getMinimumStock() { return minimumStock; }
    public void setMinimumStock(int minimumStock) { this.minimumStock = minimumStock; }
    public String getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(String warehouseLocation) { this.warehouseLocation = warehouseLocation; }
}
