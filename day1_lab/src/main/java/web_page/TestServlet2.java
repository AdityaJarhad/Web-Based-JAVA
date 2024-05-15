package web_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

/*
 * run time annotation, class level, mandatory annnotation meant for web container
 * when you deploy a web app , WC creates a map
 * key --url password
 * value --F.Q. servlet class name(web_pages.TestServlet
 * URL --http://host:port/day1_lab/hello
 * --http = app layer protocol
 * --host = DNS qualified host name(www.abc.com) OR IP address
 * --port = TCP port no (def port - 8080)
 * --URI/path = /day1_lab/hello
 * /day1_lab = context(web app) root
 *  /hello = URL pattern
*/
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("in init from "+getClass());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy "+getClass());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet"+getClass());
		// 1. set response content type
		response.setContentType("text/html");
		//2. Get PW from HttpServlet Response
		//to send buffered text contents --> to the client
		try(PrintWriter pw = response.getWriter()){
			// add dynamic content's to PW's buffer
			pw.print("<h4>Hello from servlet 2 again..."+LocalDateTime.now()+"</h4>");
		}
	}

}
