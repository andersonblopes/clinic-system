package com.lopes.clinic.rest.exception;

// TODO: Auto-generated Javadoc

/**
 * The type Patient not found exception.
 */
public class PatientNotFoundException extends RuntimeException {

	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Patient not found exception.
	 *
	 * @param message the message
	 */
	public PatientNotFoundException(String message) {
		super(message);
	}
}