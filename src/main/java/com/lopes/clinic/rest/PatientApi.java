/**
 * 
 */
package com.lopes.clinic.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lopes.clinic.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientApi.
 */
public interface PatientApi extends Versionable {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@GetMapping("/patients")
	List<Patient> findAll();

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/patients/{id}")
	ResponseEntity<Patient> findOne(@PathVariable("id") Long id);

	/**
	 * Creates the.
	 *
	 * @param patient the patient
	 * @return the patient
	 */
	@PostMapping("/patients")
	@ResponseStatus(HttpStatus.CREATED)
	Patient create(@Valid @RequestBody Patient patient);

	/**
	 * Update.
	 *
	 * @param id      the id
	 * @param patient the patient
	 * @return the response entity
	 */
	@PutMapping("/patients/{id}")
	ResponseEntity<Patient> update(@PathVariable("id") Long id, @Valid @RequestBody Patient patient);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/patients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable("id") Long id);

}
