package stuff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/settings")
public class SettingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			Navigation.setAttributes(request, c);

			request.setAttribute("checked_4b4b4b", "");
			request.setAttribute("checked_6082b6", "");
			request.setAttribute("checked_8a9a5b", "");
			request.setAttribute("checked_cd5c5c", "");
			
			if (c.getColor().equals("4b4b4b"))
				request.setAttribute("checked_4b4b4b", "checked");
			else if (c.getColor().equals("6082b6"))
				request.setAttribute("checked_6082b6", "checked");
			else if (c.getColor().equals("8a9a5b"))
				request.setAttribute("checked_8a9a5b", "checked");
			else if (c.getColor().equals("cd5c5c"))
				request.setAttribute("checked_cd5c5c", "checked");
			
			request.setAttribute("about", c.getAbout());

			request.getRequestDispatcher("settings.jsp").forward(request, response);
		}
		else
			response.sendRedirect("welcome");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDao customerDao = new CustomerDaoImpl();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");

			String newName = request.getParameter("new-name");
			String newUsername = request.getParameter("new-username");
			String newPassword = request.getParameter("new-password");
			String currentPassword = request.getParameter("current-password");
			String color = request.getParameter("color");
			String about = request.getParameter("about");
			
			if (c.getPassword().equals(currentPassword)) {
				if (newName.equals(""))
					newName = c.getName();
				if (newUsername.equals(""))
					newUsername = c.getUsername();
				if (newPassword.equals(""))
					newPassword = c.getPassword();
				request.setAttribute("notice", "");
			}
			else {
				newName = c.getName();
				newUsername = c.getUsername();
				newPassword = c.getPassword();
				if (!currentPassword.equals(""))
					request.setAttribute("notice", "<br>Account settings not saved due to password mismatch.");
				else
					request.setAttribute("notice", "");
			}
			
			customerDao.changeSettings(c.getId(), newName, newUsername, newPassword, color, about);
			session.setAttribute("customer", customerDao.getCustomer(c.getId()));
	
			request.setAttribute("notice", "Settings saved." + request.getAttribute("notice"));
			request.setAttribute("notice_display", "style=\"display: block;\"");
			
			processRequest(request, response);
		}
		else
			response.sendRedirect("welcome");
	}
}
