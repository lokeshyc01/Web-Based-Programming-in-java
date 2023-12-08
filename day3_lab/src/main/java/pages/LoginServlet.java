package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojo.User;

@WebServlet(value = "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	private UserDaoImpl user;

	public LoginServlet() {
		super();

	}

	public void init() throws ServletException {
		try {
			user = new UserDaoImpl();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("erro in db connection ", e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		response.sendRedirect("login.html");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("em");
		String password = request.getParameter("pass");

		try (PrintWriter pw = response.getWriter()){
			User validatedUser = user.authenticateUser(email, password);
			
			if(validatedUser != null)
			{
				if(validatedUser.getRole().equals("admin"))
				{
//					pw.print("<a href = admin_page></a>");
					response.sendRedirect("admin_page");
				}
				else
				{
//					alreddy voted
					
					if(validatedUser.isStatus())
					{
						response.sendRedirect("candidate_list");
					}
					else
					{
						user.updateStatus(email);
					}
//					not voted
					
				}
			}
			else
			{
				pw.print("<a href='voter_registration.html'>Register ME!!</a>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
