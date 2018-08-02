package page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stuff.Customer;
import stuff.MessageDao;
import stuff.MessageDaoImpl;
import stuff.Navigation;

@WebServlet("/messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			Navigation.setAttributes(request, c);

			MessageDao messageDao = new MessageDaoImpl();
			request.setAttribute("message_list", messageDao.getMessages(Integer.toString(c.getId())));

			request.getRequestDispatcher("messages.jsp").forward(request, response);
		}
		else
			response.sendRedirect("welcome");
	}
}