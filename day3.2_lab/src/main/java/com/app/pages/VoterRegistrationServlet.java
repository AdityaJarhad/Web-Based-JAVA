package com.app.pages;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
@WebServlet("/VoterRegistrationServlet")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
			openConnection(config.getInitParameter("db_url"), config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			userDao = new UserDaoImpl();

		} catch (Exception e) {
			throw new ServletException("error in init..." + getClass());
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			System.out.println("err in destroy of " + getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession();
			// 3. get req param
			String name = request.getParameter("fn");
			String lname = request.getParameter("ln");
			String email = request.getParameter("em");
			String passw = request.getParameter("pass");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			int age = Period.between(dob, LocalDate.now()).getYears();
			if (age >= 21) {
				// create voter instance
				User newUser = new User(name, lname, email, passw, Date.valueOf(dob));
				// assign the role as voter
//				newUser.setRole("voter");//not needed
				// invoke user dao for inserting voter detail
				String regStatus = userDao.voterRegistration(newUser);
				pw.print("<h1>" + regStatus + "</h1>");

			}

		} catch (Exception e) {
			throw new ServletException("Invalid age ! Below 18 are not eligible for voting");
		}
	}

}
