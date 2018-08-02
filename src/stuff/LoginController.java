package stuff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao customerDao = new CustomerDaoImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, password);
		Customer c = customerDao.validateCustomer(login);
		
		if(submitType.equals("Login") && c != null && c.getName() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", c);
			
			response.sendRedirect("home");
		}
		else if(submitType.equals("Register")) {
			c.setName(request.getParameter("name"));
			c.setUsername(request.getParameter("username"));
			c.setPassword(request.getParameter("password"));
			if (!request.getParameter("is-enterprise").equals(""))
				c.setIsEnterprise(1);
			customerDao.register(c);
			
			request.setAttribute("notice", "Registration done. Please login.");
			request.setAttribute("notice_display", "style=\"display: block;\"");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("notice", "Data Not Found. Please register.");
			request.setAttribute("notice_display", "style=\"display: block;\"");
			request.setAttribute("username", username);
			request.getRequestDispatcher("register.jsp?account=personal").forward(request, response);
		}
	}
}
