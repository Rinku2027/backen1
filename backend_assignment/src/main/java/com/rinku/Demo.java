package com.rinku;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Demo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String instructions;
	private boolean success;

	public Demo(Long id, String instructions, boolean success) {
		this.id = id;
		this.instructions = instructions;
		this.success = success;
	}

	public Demo() {

	}


	public Long getId() {
		return id;
	}

	public String getInstructions() {
		return instructions;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}