package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accounts.AccountsDAO;
import accounts.AccountsDTO;
import action.CommandAction;

public class AccountListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String id = request.getParameter("id");

		AccountsDAO dao = new AccountsDAO();

		AccountsDTO dto = dao.getAccount(id);

		request.setAttribute("id", dto.getId());
		request.setAttribute("password", dto.getPassword());
		request.setAttribute("nickname", dto.getNickname());
		request.setAttribute("name", dto.getName());
		request.setAttribute("email", dto.getEmail());
		
		return "/account/accountList.jsp";
	}
}