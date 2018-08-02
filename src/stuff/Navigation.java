package stuff;

import javax.servlet.http.HttpServletRequest;

public class Navigation {
	public static void setAttributes(HttpServletRequest request, Customer c) {
		if (!c.getName().equals(""))
			request.setAttribute("name", c.getName());
		else
			request.setAttribute("name", c.getUsername());
		request.setAttribute("level", c.getLevel());

		request.setAttribute("id", c.getId());
		request.setAttribute("is_enterprise", c.getIsEnterprise());
	}
}
