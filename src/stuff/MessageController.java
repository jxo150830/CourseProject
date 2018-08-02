package stuff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDao customerDao = new CustomerDaoImpl();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			Navigation.setAttributes(request, c);

			if (request.getParameter("id") != null) {
				Customer d = customerDao.getCustomer(Integer.parseInt(request.getParameter("id")));

				request.setAttribute("profile_id", d.getId());
				if (!d.getName().equals(""))
					request.setAttribute("profile_name", d.getName());
				else
					request.setAttribute("profile_name", d.getUsername());
				request.setAttribute("profile_level", d.getLevel());
				request.setAttribute("profile_is_enterprise", d.getIsEnterprise());
				if (d.getIsEnterprise() == 1)
					request.setAttribute("profile_enterprise", "");
				else if (d.getEnterprise() != 0)
					request.setAttribute("profile_enterprise", " member of <a href=\"profile?id=" + d.getEnterprise() + "\">" + customerDao.getEnterpriseName(d.getEnterprise()) + "</a>");

				request.setAttribute("profile_color", d.getColor());
				request.setAttribute("profile_about", d.getAbout());
				
				request.getRequestDispatcher("profile.jsp?id=" + request.getParameter("id")).forward(request, response);
				// response.sendRedirect("profile?id=" + request.getParameter("receiver"));
			}
			else
				response.sendRedirect("/CourseProject/profile?id=" + c.getId());
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
		CustomerDao customerDao = new CustomerDaoImpl();
		MessageDao messageDao = new MessageDaoImpl();
		HttpSession session = request.getSession();

		Message message = new Message();
		message.setSender((Customer) session.getAttribute("customer"));
		message.setReceiver(customerDao.getCustomer(Integer.parseInt(request.getParameter("receiver"))));
		message.setDate(new java.util.Date().toString());
		message.setSubject(request.getParameter("subject"));
		message.setBody(request.getParameter("body"));
		
		messageDao.createMessage(message);

		request.setAttribute("notice", "Message sent.");
		request.setAttribute("notice_display", "style=\"display: block;\"");
		processRequest(request, response);
	}
}
