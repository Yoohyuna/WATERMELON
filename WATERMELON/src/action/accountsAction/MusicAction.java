package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class MusicAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String id = request.getParameter("id");

		System.out.println("music 넘겨 받은 값 : id -> " + id);

		return "/demo-03-html/music.jsp";
	}

}