package com.lopes.clinic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lopes.clinic.model.Patient;
import com.lopes.clinic.service.PatientManager;

// TODO: Auto-generated Javadoc

/**
 * The type Patient controller.
 */
@Controller
public class PatientController {

	/**
	 * The constant LOG.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

	/**
	 * The Patient manager.
	 */
	private final PatientManager patientManager;

	/**
	 * Instantiates a new Patient controller.
	 *
	 * @param patientManager the patient manager
	 */
	public PatientController(PatientManager patientManager) {
		this.patientManager = patientManager;
	}

	/**
	 * Find all model and view.
	 *
	 * @return the model and view
	 */
	@GetMapping("/patients")
	public ModelAndView findAll() {

		LOG.info("Invoke findAll");

		ModelAndView view = new ModelAndView();
		view.setViewName("patients");
		view.addObject("patients", patientManager.findAll());

		LOG.info("return findAll with {}", view);

		return view;
	}

	/**
	 * Create patient string.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/new-patient")
	public String createPatient(Model model) {

		LOG.info("Invoke createPatient with {}", model);

		model.addAttribute("patient", new Patient());
		return "new-patient";
	}

	/**
	 * Create patient string.
	 *
	 * @param patient  the patient
	 * @param result   the result
	 * @param redirect the redirect
	 * @param model    the model
	 * @return the string
	 */
	@PostMapping("/patient")
	public String createPatient(@Validated @ModelAttribute Patient patient, BindingResult result,
			RedirectAttributes redirect, Model model) {

		LOG.info("Invoke createPatient with {}", patient);

		if (result.hasErrors()) {
			return "new-patient";
		}

		if (patientManager.create(patient).getId() != null) {
			redirect.addFlashAttribute("message", "Patient successfully created.");
			return "redirect:patients";
		}

		model.addAttribute("message", "Patient already included.");

		return "new-patient";
	}

}
