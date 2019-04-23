package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Ãß°¡
import javax.websocket.Session;

import accounts.AccountsDAO;
import accounts.AccountsDTO;
import action.CommandAction;

public class AccountUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

		AccountsDAO dao = new AccountsDAO();

		System.out.println("id´Â?" + id);
		boolean success = dao.accountUpdate(id, password, nickname, email);

		request.setAttribute("id", id);
		request.setAttribute("success", success);

		return "/account/accountUpdate.jsp";
	}
}