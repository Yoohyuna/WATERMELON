package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가

import accounts.AccountsDAO;
import action.CommandAction;

public class SignInAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		// 한글처리
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		AccountsDAO dao = new AccountsDAO();
		boolean loginCheck = dao.loginCheck(id, password);
		System.out.println("loginCheck=>"+loginCheck);
		request.setAttribute("id", id);
		request.setAttribute("loginCheck", loginCheck);

		return "/account/SignIn.jsp";
	}
}