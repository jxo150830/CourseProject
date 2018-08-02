package stuff;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/enterprise")
public class EnterpriseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDao customerDao = new CustomerDaoImpl();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			if (c.getIsEnterprise() == 1) {
				Navigation.setAttributes(request, c);
	
				request.setAttribute("customer_list", customerDao.getCustomers(c.getId()));
	
				request.getRequestDispatcher("enterprise.jsp").forward(request, response);
			}
			else
				response.sendRedirect("training");
		}
		else
			response.sendRedirect("welcome");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			if (c.getIsEnterprise() == 1)
				processRequest(request, response);
			else
				response.sendRedirect("training");
		}
		else
			response.sendRedirect("welcome");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDao customerDao = new CustomerDaoImpl();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			if (c.getIsEnterprise() == 1) {
				int amount = Integer.parseInt(request.getParameter("amount"));
				Random random = new Random();
				char[] characters = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
				
				for (int i = 0; i < amount; i++) {
					char[] username = new char[12];
					char[] password = new char[12];
					for (int j = 0; j < 12; j++) {
						username[j] = characters[random.nextInt(characters.length)];
						password[j] = characters[random.nextInt(characters.length)];
					}
					Customer d = new Customer();
					d.setName("");
					d.setUsername(new String(username));
					d.setPassword(new String(password));
					d.setEnterprise(c.getId());
					customerDao.register(d);
				}
		
				if (amount != 1)
					request.setAttribute("notice", amount + " accounts created.");
				else
					request.setAttribute("notice", amount + " account created.");
				request.setAttribute("notice_display", "style=\"display: block;\"");
		
				processRequest(request, response);
			}
			else
				response.sendRedirect("training");
		}
		else
			response.sendRedirect("welcome");
	}
}
