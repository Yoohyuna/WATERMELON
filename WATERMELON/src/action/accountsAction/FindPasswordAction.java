package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가

import accounts.AccountsDAO;
import accounts.AccountsDTO;
import action.CommandAction;

public class FindPasswordAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		// 한글처리
		request.setCharacterEncoding("utf-8");

		String password = null;

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		AccountsDAO dao = new AccountsDAO();
		AccountsDTO dto = dao.findIdorPassword(id, name, email);
		if (dto != null) {
			password = dto.getPassword();
		}

		request.setAttribute("id", id);
		request.setAttribute("password", password);

		return "/account/findPassword.jsp";
	}
}