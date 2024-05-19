package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Candidate;

public interface CandidateDao {
//add a method to list all candidates
	List<Candidate> getAllCandidates() throws SQLException;

	// add a method to increment votes
	String incrementCandidateVotes(int candidateId) throws SQLException;
	
	//top 2 candidates
	List<Candidate> topTwoCandidate() throws SQLException;
	
	//party and votes
	List<Candidate> partyVotes() throws SQLException;
}
