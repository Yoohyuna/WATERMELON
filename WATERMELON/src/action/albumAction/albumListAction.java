package action.albumAction;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import allAlbum.albumsDAO;
import allAlbum.albumsDTO;
//추가

import java.util.*;

//list.water=action.ListAction 설정
public class albumListAction implements CommandAction {
	int albumID=0;
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List article=null;
		
		System.out.println("albumListAction실행");
		
			   albumsDAO dao= new albumsDAO();
			   article=new ArrayList();
			  
			   int albumID=Integer.parseInt(request.getParameter("albumID"));
			   			  
			   System.out.println(request.getParameter("albumID"));
			   			  
			   article = dao.albumList(albumID);
			   
			   request.setAttribute("article", article); 			   
			  
			   
//			   String a_imgDir = article.getA_imgDir();
//			   String albumName = dto.getAlbumName();
			   			   
//			   System.out.println(a_imgDir);
//			   System.out.println(albumName);			   			  			   		   
		    
		    		    		
//		    request.setAttribute("album", albumName); 
		
		//3. 공유해서 이동할 수 있도록 설정
		return "/demo-03-html/single-album.jsp"; 
		}

}
