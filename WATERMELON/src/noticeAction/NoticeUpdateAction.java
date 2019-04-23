package noticeAction;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
//�߰�
import action.CommandAction;
import notice.*;

import java.sql.Timestamp; // �߰��� �κ�(�ð�)

public class NoticeUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//�ѱ�ó��
	     request.setCharacterEncoding("utf-8");
	     String pageNum=request.getParameter("pageNum");
	     int role=Integer.parseInt(request.getParameter("role"));
	     
	     NoticeDTO notice=new NoticeDTO();
	     
	     notice.setN_Num(Integer.parseInt(request.getParameter("n_Num")));
	     notice.setN_subject(request.getParameter("n_subject"));
	     notice.setN_content(request.getParameter("n_content"));
	     
	     System.out.println("���� ��ȣ=>"+notice.getN_Num()+"���� ����=>"+notice.getN_subject()+"���� ����=>"+notice.getN_content());
	     
	     NoticeDAO dbPro=new NoticeDAO();
	     dbPro.updateNotice(notice);
	     
	     request.setAttribute("role", role);
	     request.setAttribute("pageNum", pageNum);

	     
	     //response.sendRedirect("http://localhost:8090/JspBoard2/list.do"); // response.sendRedirect("/index.jsp");
	     return "notice/updatePro.jsp"; // 
	}

}




