package page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stuff.Customer;
import stuff.CustomerDao;
import stuff.CustomerDaoImpl;
import stuff.Navigation;

@WebServlet("/users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDao customerDao = new CustomerDaoImpl();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			Navigation.setAttributes(request, c);

			request.setAttribute("customer_list", customerDao.getCustomers());
			
			request.getRequestDispatcher("users.jsp").forward(request, response);
		}
		else
			response.sendRedirect("welcome");
	}
}