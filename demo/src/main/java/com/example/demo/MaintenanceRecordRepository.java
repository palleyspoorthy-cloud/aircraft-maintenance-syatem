package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Long> {
    // Allows searching records for a specific plane easily
    List<MaintenanceRecord> findByAircraftId(Long aircraftId);
}
