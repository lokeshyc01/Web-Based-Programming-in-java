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

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import static utils.DBUtils.*;

/**
 * Servlet implementation class AddPlayerForm
 */
@WebServlet(value="/add_player_form",loadOnStartup = 1)
public class AddPlayerForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDaoImpl teamDao;
	private PlayerDaoImpl playerDao;

	@Override
	public void destroy() {
		try {
			teamDao.cleanUp();
			playerDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			System.out.println("err in destroy of " + getClass() + " " + e);
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			// open db connection
			openConnection();
			teamDao = new TeamDaoImpl();
			playerDao = new PlayerDaoImpl();
			System.out.println(teamDao);
			System.out.println(playerDao);
		} catch (Exception e) {
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set content type
		response.setContentType("text/html");
		// 2. get PW
		try (PrintWriter pw = response.getWriter()) {
			// 3. get Session from WC
			HttpSession session = request.getSession();// new session
			pw.print("<h1>"+session.getId()+"</h1>");
			// 4. add dao instance/s under session scope
//			session.setAttribute("team_dao", teamDao);
//			session.setAttribute("player_dao", playerDao);
			session.setAttribute("team_dao",teamDao);
			session.setAttribute("player_dao", playerDao);
			// 5. get all abbrs from dao layer
			List<String> list = teamDao.getTeamsAbbreviations();
			//dyn form generation
			pw.print("<form action='process_add_player_form' method='post'>");
			pw.print("<h5> Choose a Team ");
			pw.print("<select name='team_abbr'>");
			for(String s : list)
				pw.print("<option value='"+s+"'>"+s+"</option>");
			pw.print("</select></h5>");
			pw.print("<h5>Enter Player Name :  <input type='text' name='nm'/></h5>");
			pw.print("<h5>Enter DoB :  <input type='date' name='dob'/></h5>");
			pw.print("<h5>Enter Natting Avg :  <input type='number' name='avg'/></h5>");
			pw.print("<h5>Enter Wickets Taken  <input type='number' name='wickets'/></h5>");
			pw.print("<h5> <input type='submit' value='Add New Player'/></h5>");
			pw.print("</form>");
		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

}
