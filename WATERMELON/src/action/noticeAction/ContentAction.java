package action.noticeAction;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import notice.*;


//content.jsp에서 처리한 자바코드부분을 대신 처리해주는 액션클래스
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		   int role = Integer.parseInt(request.getParameter("role"));
		   int n_Num=Integer.parseInt(request.getParameter("n_Num"));
		   String pageNum=request.getParameter("pageNum");
		   
		   NoticeDAO dbPro=new NoticeDAO();
		   NoticeDTO notice=dbPro.getNoticeContent(n_Num);
		  
		 
		   request.setAttribute("role", role);
		   request.setAttribute("pageNum", pageNum);
		   request.setAttribute("notice", notice);
		
		   // ref, re_step, re_level 도 전달 X
		   
		return "/notice/content.jsp";
	}

}




