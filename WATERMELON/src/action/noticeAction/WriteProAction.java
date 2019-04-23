package action.noticeAction;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
//추가
import notice.*;
import java.sql.Timestamp;//추가할 부분(시간)

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	     //한글처리
	     request.setCharacterEncoding("utf-8");
	     int role=Integer.parseInt(request.getParameter("role"));
	     
	     NoticeDTO notice=new NoticeDTO();
	    
	     notice.setN_subject(request.getParameter("n_subject"));
	     notice.setN_content(request.getParameter("n_content"));
	     
	     //readcount->default로 설정한 관계로 자동으로 0이 들어간다.
	  
	  NoticeDAO dbPro=new NoticeDAO();
	  dbPro.insertNotice(notice);
	  
	  request.setAttribute("role", role);
	  
	  return "notice/writePro.jsp";
		
	}
}
