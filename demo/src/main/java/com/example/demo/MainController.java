package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired 
    private AircraftRepository aircraftRepository;
    
    @Autowired 
    private MaintenanceRecordRepository maintenanceRecordRepository;
    
    @Autowired 
    private SparePartRepository sparePartRepository;

    @GetMapping("/") 
    public String defaultRootPage() { 
        return "login"; 
    }
    
    @GetMapping("/login") 
    public String viewLoginPage() { 
        return "login"; 
    }
    
    @GetMapping("/dashboard") 
    public String viewDashboardPage(Model model) { 
        model.addAttribute("aircraftList", aircraftRepository.findAll()); 
        return "dashboard"; 
    }
    
    @GetMapping("/aircrafts") 
    public String viewAircraftInventoryPage(Model model) { 
        model.addAttribute("aircraftList", aircraftRepository.findAll()); 
        model.addAttribute("newAircraft", new Aircraft()); 
        return "aircrafts"; 
    }
    
    @PostMapping("/aircrafts/add")
    public String addNewAircraftToFleet(@RequestParam String tailNumber, 
                                        @RequestParam String model, 
                                        @RequestParam String manufacturer, 
                                        @RequestParam int totalFlightHours, 
                                        @RequestParam String status) {
        aircraftRepository.save(new Aircraft(tailNumber, model, manufacturer, totalFlightHours, status));
        return "redirect:/aircrafts";
    }

    @GetMapping("/maintenance")
    public String viewMaintenanceRecordsPage(Model model) {
        model.addAttribute("recordsList", maintenanceRecordRepository.findAll());
        model.addAttribute("aircraftList", aircraftRepository.findAll());
        return "records"; 
    }

    @GetMapping("/inventory")
    public String viewInventoryPage(Model model) {
        var allParts = sparePartRepository.findAll();
        model.addAttribute("partsList", allParts);
        model.addAttribute("lowStockAlerts", allParts.stream()
            .filter(p -> p.getCurrentStock() <= p.getMinimumStock())
            .collect(Collectors.toList()));
        return "inventory";
    }

    @PostMapping("/inventory/add")
    public String addNewPartToStock(@RequestParam String partNumber, 
                                    @RequestParam String partName, 
                                    @RequestParam String warehouseLocation, 
                                    @RequestParam int currentStock, 
                                    @RequestParam int minimumStock) {
        sparePartRepository.save(new SparePart(partNumber, partName, currentStock, minimumStock, warehouseLocation));
        return "redirect:/inventory";
    }
}
