package com.lopes.clinic.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lopes.clinic.model.Patient;
import com.lopes.clinic.service.PatientManager;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientResource.
 */
@RestController
public class PatientResource implements PatientApi {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(PatientResource.class);

	/** The patient manager. */
	private PatientManager patientManager;

	/**
	 * Instantiates a new patient resource.
	 *
	 * @param patientManager the patient manager
	 */
	public PatientResource(PatientManager patientManager) {
		this.patientManager = patientManager;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Patient> findAll() {

		LOG.info("Invoke findAll");

		return patientManager.findAll();
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Patient> findOne(Long id) {

		LOG.info("Invoke findOne with {}", id);

		Patient patient = patientManager.findById(id);

		return ResponseEntity.ok(patient);
	}

	/**
	 * Creates the.
	 *
	 * @param patient the patient
	 * @return the response entity
	 */
	@Override
	public Patient create(Patient patient) {

		LOG.info("Invoke create with {}", patient);

		return patientManager.create(patient);

	}

	/**
	 * Update.
	 *
	 * @param id      the id
	 * @param patient the patient
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Patient> update(Long id, Patient patient) {

		LOG.info("Invoke update with id: {} and patient: {}", id, patient);

		Patient patientUpdated = patientManager.update(id, patient);

		LOG.info("Patient {} updated: {}", id, patient);

		return ResponseEntity.ok(patientUpdated);

	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(Long id) {

		LOG.info("Invoke delete with id: {}", id);

		patientManager.delete(id);

	}

}
