package com.app.dao;

import static com.app.utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public CandidateDaoImpl() throws SQLException {
		// open cn
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3 = cn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst4 = cn.prepareStatement("select party, sum(votes) from candidates group by party");
		System.out.println("candidate dao created....");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidateList = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidateList.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidateList;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		// set IN param : candidate id
		pst2.setInt(1, candidateId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Votes updated...";
		return "Votes updation failed !!!!!!!!!!!!";
	}
	


	@Override
	public List<Candidate> topTwoCandidate() throws SQLException {
		List<Candidate> list = new ArrayList<>();
		ResultSet rs3 = pst3.executeQuery();
		while(rs3.next())
			list.add(new Candidate(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getInt(4)));
		return list;
	}

	@Override
	public List<Candidate> partyVotes() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		ResultSet rs4 = pst4.executeQuery();
		while(rs4.next())
			candidates.add(new Candidate(rs4.getString(3),rs4.getInt(0)));
		return null;
	}
	
	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		
	}

}
