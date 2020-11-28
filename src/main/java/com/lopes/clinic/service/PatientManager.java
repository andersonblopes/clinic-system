package com.lopes.clinic.service;

import com.lopes.clinic.model.Patient;
import com.lopes.clinic.model.repository.PatientRepository;
import com.lopes.clinic.rest.exception.ClinicSystemApiException;
import com.lopes.clinic.rest.exception.PatientNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO: Auto-generated Javadoc

/**
 * The type Patient manager.
 */
@Service
public class PatientManager {

    /**
     * The constant LOG.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PatientManager.class);

    /**
     * The Patient repository.
     */
    private final PatientRepository patientRepository;

    /**
     * Instantiates a new Patient manager.
     *
     * @param patientRepository the patient repository
     */
    public PatientManager(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Create patient.
     *
     * @param patient the patient
     * @return the patient
     */
    public Patient create(Patient patient) {

        LOG.info("Invoke save with {}", patient);

        if (patient == null || patient.getId() != null) {
            throw new ClinicSystemApiException("Patient cannot created!");
        }

        if (isDuplicated(patient)) {
            throw new ClinicSystemApiException("Patient already exists!");
        }

        return patientRepository.save(patient);
    }

    /**
     * Update patient.
     *
     * @param id      the id
     * @param patient the patient
     * @return the patient
     */
    public Patient update(Long id, Patient patient) {

        Optional<Patient> patientFound = patientRepository.finById(id);

        if (patientFound.isEmpty()) {

            LOG.error("Patient with id {} not found!", id);

            throw new PatientNotFoundException("");

        }

        LOG.info("Patient found: {}", patientFound);
        patientFound.get().setName(patient.getName());
        patientFound.get().setAge(patient.getAge());

        return patientRepository.save(patientFound.get());

    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    /**
     * Find by id patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient findById(Long id) {

        LOG.info("Invoke findOne with {}", id);

        Optional<Patient> patientFound = patientRepository.finById(id);

        if (patientFound.isEmpty()) {

            LOG.error("Patient with id {} not found!", id);

            throw new PatientNotFoundException("");

        }

        return patientFound.get();

    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Long id) {

        LOG.info("Invoke delete with {}", id);

        findById(id);

        patientRepository.remove(id - 1);

    }

    /**
     * Is duplicated boolean.
     *
     * @param patient the patient
     * @return the boolean
     */
    private boolean isDuplicated(Patient patient) {

        LOG.info("Invoke isDuplicated with {}", patient);

        List<Patient> patients = findAll();

        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(patient.getName()) && !p.getId().equals(patient.getId())) {
                return true;
            }
        }
        return false;
    }

}
