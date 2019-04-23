package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;


public class SignAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		String Login_id = "";
		if (id != null) {
			Login_id = id;
		}
		request.setAttribute("Login_id", Login_id);
		return "/account/sign.jsp";
	}
}