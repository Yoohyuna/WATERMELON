package action.noticeAction;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
//�߰�
import notice.*;
import java.sql.Timestamp;//�߰��� �κ�(�ð�)

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	     //�ѱ�ó��
	     request.setCharacterEncoding("utf-8");
	     int role=Integer.parseInt(request.getParameter("role"));
	     
	     NoticeDTO notice=new NoticeDTO();
	    
	     notice.setN_subject(request.getParameter("n_subject"));
	     notice.setN_content(request.getParameter("n_content"));
	     
	     //readcount->default�� ������ ����� �ڵ����� 0�� ����.
	  
	  NoticeDAO dbPro=new NoticeDAO();
	  dbPro.insertNotice(notice);
	  
	  request.setAttribute("role", role);
	  
	  return "notice/writePro.jsp";
		
	}
}
