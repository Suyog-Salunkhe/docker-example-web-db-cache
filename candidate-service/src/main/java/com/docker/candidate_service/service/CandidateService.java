package com.docker.candidate_service.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.docker.candidate_service.model.Candidate;
import com.docker.candidate_service.repository.CandidateRepository;
import com.docker.candidate_service.request.CandidateRequest;

@Service
public class CandidateService {

	private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);

	@Autowired
	private CandidateRepository candidateRepository;

	public Candidate createCandidate(CandidateRequest candidateRequest) {

		Candidate candidate = Candidate.builder()
				.candidateId(candidateRequest.getId())
				.candidateName(candidateRequest.getName())
				.designation(candidateRequest.getDesignation())
				.organisationName(candidateRequest.getOrganisationName())
				.yearsOfExperience(candidateRequest.getYearsOfExperience()).build();

		return saveCandidate(candidate);
	}

	@Cacheable(value = "candidates", key = "#id")
	public Candidate getCandidateById(Long id) {
		logger.info("Fetching candidate for id: " + id);
		Optional<Candidate> candidate = candidateRepository.findById(id);
		return candidate.orElse(null);
	}

	@CachePut(value = "candidates", key = "#candidate.id")
	public Candidate saveCandidate(Candidate candidate) {
		logger.info("Saving candidate - id: {}", candidate.getCandidateId());
		return candidateRepository.save(candidate);
	}

	@CacheEvict(value = "candidates", key = "#id")
	public void deleteCandidateById(Long id) {
		logger.info("Deleting candidate - id: {}", id);
		candidateRepository.deleteById(id);
	}

}
