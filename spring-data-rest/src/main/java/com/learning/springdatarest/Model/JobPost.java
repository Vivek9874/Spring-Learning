package com.learning.springdatarest.Model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JobPost model class representing a job posting entity.
 * 
 * Lombok annotations are used to reduce boilerplate code:
 * - @Data: Generates getters, setters, toString(), equals(), and hashCode() methods.
 * - @NoArgsConstructor: Generates a no-argument constructor.
 * - @AllArgsConstructor: Generates a constructor with parameters for all fields.
 */
@Data  // Lombok: Generates getters/setters, toString(), equals(), and hashCode()
@NoArgsConstructor  // Lombok: Creates a no-argument constructor
@AllArgsConstructor // Lombok: Creates a constructor with all class fields as parameters
@Entity
public class JobPost {
	
	@Id
	private int postId;  // Unique identifier for the job post
	private String postProfile; // Title/role of the job (e.g., "Software Engineer")
	private String postDesc; // Detailed job description
	private int reqExperience; // Required years of experience
	
	@ElementCollection
	private List<String> postTechStack; // List of required technologies (e.g., ["Java", "Spring", "React"])
}
