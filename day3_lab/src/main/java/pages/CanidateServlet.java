package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import pojo.User;

/**
 * Servlet implementation class CanidateServlet
 */
@WebServlet("/candidate_list")
public class CanidateServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	private UserDaoImpl user;

	public void init() throws ServletException {
		try {
			user = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("db error", e);
		}
	}

	public CanidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.print("candidate page");
		HttpSession hs = request.getSession();
		System.out.println("CandiatePage"+hs.isNew());
		System.out.println(hs.getId());
		try (PrintWriter pw = response.getWriter()) {
			List<User> userList = user.getAllUser();
			User user1 = (User)hs.getAttribute("user_info");
			int iCnt = 0;
			
			pw.print("<h1>Voter Name => " + user1.getFirst_name() + "</h1>");
			pw.print("<form action='vote' method='post'>");
			for (User user : userList) {
				pw.print("<input type='radio' name='candidatelist' value='" + (++iCnt) + "'>" + user.getFirst_name()
						+ "" + user.getLast_name() + "</input><br/>");
			}

			pw.print("<button type='submit'>Vote</button>");
			pw.print("</from>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
