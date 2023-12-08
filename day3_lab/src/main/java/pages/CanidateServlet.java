package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CanidateServlet
 */
@WebServlet("/candidate_list")
public class CanidateServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    
    public CanidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.print("candidate pagge");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h1>In Candidate List</h1>");
		}
	}

	
	
}
