package action.albumAction;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import allAlbum.albumsDAO;
import allAlbum.albumsDTO;


import java.util.*;

//list.water=action.ListAction 설정
public class singleAlbumAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		System.out.println("singleAlbumAction실행");
				albumsDAO dao= new albumsDAO();
			//			  
				int albumID=Integer.parseInt(request.getParameter("albumID"));
			   
				System.out.println(albumID);
				
			  albumsDTO album=dao.printSingleAlbum(albumID); 			  

//			   System.out.println(a_imgDir);
//			   System.out.println(albumName);
			 
			  request.setAttribute("album", album);
			  
			  String albumName = album.getAlbumName();
			  String a_imgDir = album.getA_imgDir();
			  
			 // System.out.println("albumName"+albumName);
			 
			  request.setAttribute("albumName", albumName);
			  request.setAttribute("a_imgDir", a_imgDir);
			 // request.setAttribute("albumID", albumID);
			  
			  
		/*
		 * 
		 * String albumName = albums.getAlbumName(); String a_content =
		 * albums.getA_content(); String a_imgDir = albums.getA_imgDir();
		 * 
		 * // request.setAttribute("article", article);
		 * request.setAttribute("albumName", albumName);
		 * request.setAttribute("a_content", a_content);
		 * request.setAttribute("a_imgDir", a_imgDir);
		 */
			  
//		    request.setAttribute("album", albumName); 
			   //System.out.println(albums.getA_content());
		    
		//3. 공유해서 이동할 수 있도록 설정
		return "/demo-03-html/single-album.jsp"; 
		}

}
