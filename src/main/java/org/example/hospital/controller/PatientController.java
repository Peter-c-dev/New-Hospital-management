package org.example.hospital.controller;

import org.example.hospital.model.Patient;
import org.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// ... other necessary imports (like ResponseEntity, List)

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService; // Ensure this is present!

    @PostMapping
    public Patient addPatient(
            @RequestBody Patient patient,
            @RequestParam String wardName
    ) {
        // This line calls the service method, passing both arguments
        return patientService.addPatient(patient, wardName);
    }

    // ... all other controller methods (like getAllPatients, updateDiagnosis, etc.)
}

