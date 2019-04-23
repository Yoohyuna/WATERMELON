package action.singleAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

import single.SingleDAO;
import single.SingleDTO;

public class SingleAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			
		
		
		SingleDAO dao = new SingleDAO();
		int t_ID = Integer.parseInt(request.getParameter("t_ID"));
		System.out.println(t_ID);
		SingleDTO single = dao.getSingleContent(t_ID);
//
		System.out.println(single.getT_ID());
		request.setAttribute("single", single);

		//int artistID = Integer.parseInt(request.getParameter("artistID"));
		         
         
         String artistName = single.getArtistName();
         String a_imgDir = single.getA_imgDir();
          
         
         request.setAttribute("artistName", artistName);
         request.setAttribute("a_imgDir", a_imgDir);
		 System.out.println("a_imgDir="+a_imgDir);  
		 System.out.println("artistName="+artistName);
         
         

		return "/demo-03-html/single.jsp";
	}

}
