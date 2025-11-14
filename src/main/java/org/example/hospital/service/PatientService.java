package org.example.hospital.service;

import org.example.hospital.model.Patient;
import org.example.hospital.model.Ward; // <-- NEW IMPORT
import org.example.hospital.repository.PatientRepository;
import org.example.hospital.repository.WardRepository; // <-- NEW IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // <-- NEW IMPORT (for Optional used with findById)

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private WardRepository wardRepository;


    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    public Patient addPatient(Patient patient, String wardName) {


        Optional<Ward> wardOptional = Optional.ofNullable(wardRepository.findByName(wardName));

        if (wardOptional.isPresent()) {



            return patientRepository.save(patient);
        } else {

            throw new IllegalArgumentException("Ward named '" + wardName + "' not found.");
        }
    }


    public Patient updateDiagnosis(Long id, String diagnosis) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setDiagnosis(diagnosis);
                    return patientRepository.save(patient);
                })
                .orElseThrow(() -> new IllegalArgumentException("Patient ID " + id + " not found."));
    }


    public void dischargePatient(Long id) {
        patientRepository.deleteById(id);
    }
}