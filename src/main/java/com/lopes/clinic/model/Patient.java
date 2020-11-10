package com.lopes.clinic.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc

/**
 * The Class Patient.
 */
public class Patient {

	/** The id. */
	private Long id;

	/** The name. */
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
	private String name;

	@Min(value = 1, message = "Age should not be less than 1")
	@Max(value = 150, message = "Age should not be greater than 150")
	private int age;

	/**
	 * Instantiates a new patient.
	 */
	public Patient() {
	}

	/**
	 * Instantiates a new patient.
	 *
	 * @param id   the id
	 * @param name the name
	 * @param age  the age
	 */
	public Patient(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
