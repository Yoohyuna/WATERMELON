package action.noticeAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int role=Integer.parseInt(request.getParameter("role"));
		
		
		request.setAttribute("role", role);
		
		return "/notice/notice_form.jsp";
	}

}


