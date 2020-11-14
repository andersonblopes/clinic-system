package com.lopes.clinic.rest.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientNotFoundException.
 */
public class PatientNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new patient not found exception.
	 *
	 * @param message the message
	 */
	public PatientNotFoundException(String message) {
		super(message);
	}
}