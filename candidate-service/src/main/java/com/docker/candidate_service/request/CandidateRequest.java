package com.docker.candidate_service.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateRequest {

	private long id;
	
	private String name;

	private String organisationName;

	private String designation;
	
	private Double yearsOfExperience;
		
}