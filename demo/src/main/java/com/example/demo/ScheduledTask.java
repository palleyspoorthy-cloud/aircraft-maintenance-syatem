package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class ScheduledTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aircraftTail;    // e.g., VT-A01
    private String checkType;       // e.g., A-Check, Avionics Upgrade
    private LocalDate targetDate;
    private String assignedEngineer; // e.g., Technician 03
    private String taskPriority;     // High, Medium, Low
    private String scheduleStatus;   // Scheduled, In-Progress, Deferred

    public ScheduledTask() {}

    public ScheduledTask(String aircraftTail, String checkType, LocalDate targetDate, 
                         String assignedEngineer, String taskPriority, String scheduleStatus) {
        this.aircraftTail = aircraftTail;
        this.checkType = checkType;
        this.targetDate = targetDate;
        this.assignedEngineer = assignedEngineer;
        this.taskPriority = taskPriority;
        this.scheduleStatus = scheduleStatus;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAircraftTail() { return aircraftTail; }
    public void setAircraftTail(String aircraftTail) { this.aircraftTail = aircraftTail; }
    public String getCheckType() { return checkType; }
    public void setCheckType(String checkType) { this.checkType = checkType; }
    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }
    public String getAssignedEngineer() { return assignedEngineer; }
    public void setAssignedEngineer(String assignedEngineer) { this.assignedEngineer = assignedEngineer; }
    public String getTaskPriority() { return taskPriority; }
    public void setTaskPriority(String taskPriority) { this.taskPriority = taskPriority; }
    public String getScheduleStatus() { return scheduleStatus; }
    public void setScheduleStatus(String scheduleStatus) { this.scheduleStatus = scheduleStatus; }
}
