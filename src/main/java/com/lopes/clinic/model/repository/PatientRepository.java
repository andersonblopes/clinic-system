package com.lopes.clinic.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lopes.clinic.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientRepository.
 */
@Repository
public class PatientRepository {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(PatientRepository.class);

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

		LOG.info("Return findAll with {}", patients);

		return patients;
	}

	/**
	 * Save.
	 *
	 * @param patient the patient
	 * @return the patient
	 */
	public Patient save(Patient patient) {

		LOG.info("Invoke save with {}", patient);

		if (patient.getId() == null) {

			patient.setId(patients.size() + 1L);

			this.patients.add(patient);

		}

		return patient;
	}

	/**
	 * Fin by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Patient> finById(Long id) {

		LOG.info("Invoke finById with {}", id);

		Optional<Patient> patientFound = Optional.empty();

		for (Patient p : patients) {

			if (p.getId().equals(id)) {

				patientFound = Optional.of(p);
				break;

			}

		}

		LOG.info("Return finById with {}", patientFound);

		return patientFound;

	}

	/**
	 * Removes the.
	 *
	 * @param id the id
	 */
	public void remove(Long id) {

		LOG.info("Invoke remove with {}", id);

		patients.remove(id.intValue());
	}

}
