package action.noticeAction;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import notice.*;

public class NoticeDeleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int role=Integer.parseInt(request.getParameter("role"));
		int n_Num=Integer.parseInt(request.getParameter("n_Num"));
		String pageNum=request.getParameter("pageNum");
		String password=request.getParameter("password"); 
		System.out.println("삭제 액션의 role=> "+role);
	
		System.out.println("n_Num=>"+n_Num+",password=>"+password+",pageNum=>"+pageNum);
		  
		NoticeDAO dbPro=new NoticeDAO();
		int check=dbPro.deleteNotice(n_Num, password, role);//암호찾고->웹상의 암호체크
		  
		request.setAttribute("role", role);
		request.setAttribute("check", check); 
		request.setAttribute("pageNum", pageNum);
		 
		 
		  return "notice/deletePro.jsp";
	}

}

