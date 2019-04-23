package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accounts.AccountsDAO;
import action.CommandAction;

public class AccountDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password_confirm = request.getParameter("password_confirm");

		int check = 100;

		if (!password.equals(password_confirm) || password_confirm.equals("") || password_confirm.equals(null)) {
			check = -1;
			request.setAttribute("check", check);
			return "/account/accountDeletePro.jsp";
		}

		AccountsDAO dao = new AccountsDAO();

		check = dao.deleteAccount(id, password);

		request.setAttribute("check", check);

		return "/account/accountDeletePro.jsp";
	}
}
