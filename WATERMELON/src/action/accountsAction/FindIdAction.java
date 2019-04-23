package action.accountsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가

import accounts.AccountsDAO;
import accounts.AccountsDTO;
import action.CommandAction;

public class FindIdAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		String id = null;
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		AccountsDAO dao = new AccountsDAO();
		AccountsDTO dto = dao.findIdorPassword(null, name, email);
		if(dto!=null) {
			id = dto.getId();
		}
		
		request.setAttribute("id", id);

		return "/account/findId.jsp";
	}
}