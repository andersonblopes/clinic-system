/**
 * 
 */
package com.lopes.clinic.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lopes.clinic.rest.exception.ClinicSystemApiException;
import com.lopes.clinic.rest.exception.PatientNotFoundException;

// TODO: Auto-generated Javadoc

/**
 * The type Patient advice.
 */
@ControllerAdvice
public class PatientAdvice {

	/**
	 * Not found.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PatientNotFoundException.class)
	public void notFound() {

	}

	/**
	 * Bad request.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ClinicSystemApiException.class)
	public void badRequest() {

	}

}
