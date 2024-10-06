package com.docker.candidate_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.candidate_service.model.Candidate;
import com.docker.candidate_service.request.CandidateRequest;
import com.docker.candidate_service.response.CandidateResponse;
import com.docker.candidate_service.service.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	private final CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping("/create")
	public ResponseEntity<CandidateResponse> createCandidate(@RequestBody CandidateRequest candidateRequest) {

		Candidate candidate = candidateService.createCandidate(candidateRequest);

		CandidateResponse candidateResponse = new CandidateResponse(candidate, "Candidate created successfully");

		return new ResponseEntity<>(candidateResponse, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CandidateResponse> findCandidateById(@PathVariable Long id) {

		Candidate candidate = candidateService.getCandidateById(id);
		String message = "Candidate not found";
		HttpStatus httpStatus = HttpStatus.NO_CONTENT;
		if (candidate != null) {
			message = "Candidate found";
			httpStatus = HttpStatus.OK;
		}
		CandidateResponse candidateResponse = new CandidateResponse(candidate, message);

		return new ResponseEntity<>(candidateResponse, httpStatus);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {

		candidateService.deleteCandidateById(id);

		return new ResponseEntity<>("Candidate deleted successfully with id : " + id, HttpStatus.CREATED);
	}

}