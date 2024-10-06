package com.docker.candidate_service.response;

import com.docker.candidate_service.model.Candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponse {

	private Candidate candidate;
	
	private String message;
}