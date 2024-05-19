package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. set conttype
		response.setContentType("text/html");
		//2. set pw
		try(PrintWriter pw = response.getWriter())
		{
			//3.get httpSession from WC
			HttpSession hs = request.getSession();
			//name of admin
			User user = (User) hs.getAttribute("user_info");
			pw.print("<h4>Hello "+user.getFirstName()+" "+user.getLastName()+"</h4>");
			pw.print("<h4>You logged in as admin!</h4>");
			pw.print("<h2>Top two candidates having max votes</h2>");
			//candidate list	
			CandidateDaoImpl dao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
			List<Candidate> candidates = dao.topTwoCandidate();
			for(Candidate c : candidates)
				pw.print("<h2>"+c.getCandidateId()+" "+c.getCandidateName()+"</h2>");
			
			//partywise votes
			pw.println("Party and votes");
			List<Candidate> partVoteList = dao.partyVotes();
			for (Candidate c : partVoteList) {
				pw.print("<h4>"+c.getParty()+" "+c.getVotes()+"</h4>");
			}
			
		} catch (Exception e) {
			throw new ServletException("Error during admin login");
		}
		
	}

}
