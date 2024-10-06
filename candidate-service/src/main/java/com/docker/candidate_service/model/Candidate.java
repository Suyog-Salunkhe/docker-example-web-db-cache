package com.docker.candidate_service.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate implements Serializable {

	@Id
	private Long candidateId;

	@Column
	private String candidateName;

	@Column
	private String organisationName;

	@Column
	private String designation;

	@Column
	private Double yearsOfExperience;

}
