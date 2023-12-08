package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/voter_register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl user;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		try {
			user = new UserDaoImpl();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("erro in db connection ", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("em");
		String fname = request.getParameter("fn");
		String lname = request.getParameter("ln");
		String password = request.getParameter("pass");
		String date = request.getParameter("dob");

		try {
			try (PrintWriter pw = response.getWriter()) {

				int year = Period.between(LocalDate.now(), LocalDate.parse(date)).getYears();
				System.out.println(year);
				if (year >= 21) {
					user.registerVoter(fname, lname, email, password, LocalDate.parse(date));
				} else {
					System.out.println("Here arrived");
					pw.print(
							"<h1>Invalid Date entered!! <a href='voter_registration.html'>Click here to Re-register</a>");
				}
			}

			response.sendRedirect("login.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("voter_registration.html");
		}

	}

}
