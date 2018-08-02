package page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stuff.Customer;
import stuff.Navigation;

@WebServlet("/training")
public class Training extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("customer") != null) {
			Customer c = (Customer) session.getAttribute("customer");
			Navigation.setAttributes(request, c);

			int opacity = 6;
			
			if (c.getLevel() < 2) {
				request.setAttribute("sel_sty", "style=\"opacity: ." + opacity + ";\"");
				opacity -= 2;
				request.setAttribute("sel_msg", "( unlocks at level 2 )");
			}
			if (c.getLevel() < 3) {
				request.setAttribute("adv_sty", "style=\"opacity: ." + opacity + ";\"");
				opacity -= 2;
				request.setAttribute("adv_msg", "( unlocks at level 3 )");
			}
			if (c.getLevel() < 4) {
				request.setAttribute("fre_sty", "style=\"opacity: ." + opacity + ";\"");
				opacity -= 2;
				request.setAttribute("fre_msg", "( unlocks at level 4 )");
			}
			
			request.getRequestDispatcher("training.jsp").forward(request, response);
		}
		else
			response.sendRedirect("welcome");
	}
}