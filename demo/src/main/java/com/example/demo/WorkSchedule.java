package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aircraft aircraft; // Links schedule directly to an active fleet asset

    private String checkType;       // e.g., A-Check, Engine Refurbishment
    private LocalDate scheduledDate;
    private String assignedTo;      // Technician Name
    private String priority;        // High, Medium, Low
    private String status;          // Scheduled, Deferred, Completed

    public WorkSchedule() {}

    public WorkSchedule(Aircraft aircraft, String checkType, LocalDate scheduledDate, String assignedTo, String priority, String status) {
        this.aircraft = aircraft;
        this.checkType = checkType;
        this.scheduledDate = scheduledDate;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Aircraft getAircraft() { return aircraft; }
    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public String getCheckType() { return checkType; }
    public void setCheckType(String checkType) { this.checkType = checkType; }
    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }
    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
