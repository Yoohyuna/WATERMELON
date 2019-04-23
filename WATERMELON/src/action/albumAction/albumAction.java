package action.albumAction;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import allAlbum.albumsDAO;
import allAlbum.albumsDTO;
//추가

import java.util.*;

//list.water=action.ListAction 설정
public class albumAction implements CommandAction {
	int albumID=0;
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List article=null;
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:)");
			   albumsDAO dao= new albumsDAO();
			   article=new ArrayList();
			  
			   System.out.println(request.getParameter("albumID"));
			   
			   if (request.getParameter("albumID")==null) {
				int albumid=1;
			}else {
				int albumid=Integer.parseInt(request.getParameter("albumID"));
			}
			   article = dao.printAlbum(albumID);
			  
			   
//			   String a_imgDir = article.getA_imgDir();
//			   String albumName = dto.getAlbumName();

//			   System.out.println(a_imgDir);
//			   System.out.println(albumName);
			   			  			   
		    request.setAttribute("article", article); 
		    		    		
//		    request.setAttribute("album", albumName); 
		
		//3. 공유해서 이동할 수 있도록 설정
		return "/demo-03-html/parts/browse/all-albums.jsp"; 
		}

}
