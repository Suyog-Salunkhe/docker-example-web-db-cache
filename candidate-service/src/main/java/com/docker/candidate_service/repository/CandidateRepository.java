package com.docker.candidate_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.docker.candidate_service.model.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {

}
