/**
 * 
 */
package com.lopes.clinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lopes.clinic.model.Patient;
import com.lopes.clinic.model.repository.PatientRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientManager.
 *
 * @author ander
 */
@Service
public class PatientManager {

	/** The patient repository. */
	private PatientRepository patientRepository;

	/**
	 * Instantiates a new patient manager.
	 *
	 * @param patientRepository the patient repository
	 */
	public PatientManager(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	/**
	 * Save.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 */
	public boolean save(Patient patient) {
		if (!isDuplicated(patient)) {
			return patientRepository.save(patient);
		}
		return false;
	}

	/**
	 * Checks if is duplicated.
	 *
	 * @param patient the patient
	 * @return true, if is duplicated
	 */
	private boolean isDuplicated(Patient patient) {
		for (Patient p : findAll()) {
			if (p.getName().equalsIgnoreCase(patient.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

}
