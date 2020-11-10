package com.lopes.clinic.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lopes.clinic.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientRepository.
 */
@Repository
public class PatientRepository {

	/** The patients. */
	private List<Patient> patients;

	/**
	 * Instantiates a new patient repository.
	 */
	public PatientRepository() {
		this.patients = new ArrayList<>();
		patients.add(new Patient(1L, "Anderson", 38));
		patients.add(new Patient(2L, "Helena", 11));
		patients.add(new Patient(3L, "Elaine", 32));
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Patient> findAll() {
		return patients;
	}

	/**
	 * Save.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 */
	public boolean save(Patient patient) {
		patient.setId(patients.size() + 1L);
		this.patients.add(patient);
		return true;
	}

}
