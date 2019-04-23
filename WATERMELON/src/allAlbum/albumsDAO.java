package allAlbum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class albumsDAO {

	private DBConnectionMgr pool=null; 
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";//실행시킬 SQL구문 저장
	
	//생성자 통해서 연결
	public albumsDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB접속오류=>"+e);
		}
	}
	
	private albumsDTO makeAlbum() throws Exception{
		albumsDTO album=new albumsDTO();
		album.setAlbumID(rs.getInt("albumID"));
		album.setA_imgDir(rs.getString("a_imgDir"));
		album.setAlbumName(rs.getString("albumName"));
		album.setA_content(rs.getString("a_content"));
		return album;
	}

	
	public List printAlbum(int albumID) {
		List article=new ArrayList();
		albumsDTO albums = null;
		
		try {
			con=pool.getConnection();
			if (albumID==0) {
				sql="select a_imgDir, albumName, albumID from Album";
				pstmt=con.prepareStatement(sql);
			}else {
				sql="select a_imgDir, albumName, albumID from Album where albumID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, albumID);
			}
			System.out.println(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				albums=new albumsDTO();
				albums.setA_imgDir(rs.getString("a_imgDir"));
				albums.setAlbumName(rs.getString("albumName"));	
				albums.setAlbumID(rs.getInt("albumID"));
				article.add(albums);
			}
			
		}catch(Exception e) {
			System.out.println("printAlbum()메서드 에러유발"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		
		return article;
		
	}
	
	
	public List printArtist(int albumID) {
		List article=new ArrayList();
		albumsDTO albums = null;
		
		try {
			con=pool.getConnection();
			if (albumID==0) {
				sql="select artistName from Artist";
				pstmt=con.prepareStatement(sql);
			}else {
				sql="select artistName from Artist where albumID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, albumID);
			}
			System.out.println(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				albums=new albumsDTO();
				albums.setArtistName(rs.getString("artistName"));
				article.add(albums);
			}
			
		}catch(Exception e) {
			System.out.println("printArtist()메서드 에러유발"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		
		return article;
		
	}
	
	
	public albumsDTO printSingleAlbum(int albumID) {
		albumsDTO album=null;
		
		try {
			con=pool.getConnection();
			
				sql="select albumName, a_content, a_imgDir, albumID from Album where albumID="+albumID;
			
				pstmt=con.prepareStatement(sql);
				//pstmt.setInt(1, albumID);
				rs=pstmt.executeQuery();
			
				System.out.println(sql);
						
			while(rs.next()) {
				album=makeAlbum();		
						
			}
			
		}catch(Exception e) {
			System.out.println("printSingleAlbum()메서드 에러유발"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		return album;		
	}
	
	
	

	public List albumList(int albumID) {
		
		List article=new ArrayList();
		albumsDTO albums = null;
		
		try {
			
			
				con=pool.getConnection();			
				sql="select t1.genreID, t1.musicName, t1.time, t1.albumID, t2.genreName from Track_info t1, Genre t2 where t1.genreID=t2.genreID and albumID="+albumID;
				pstmt=con.prepareStatement(sql);
				//pstmt.setInt(1, albumID);
			
			
			rs=pstmt.executeQuery();
			System.out.println(sql);
			
			while(rs.next()) {
				albums=new albumsDTO();
				albums.setMusicName(rs.getString("musicName"));
				albums.setTime(rs.getString("time"));					
				albums.setGenreID(rs.getInt("genreID"));
				albums.setAlbumID(rs.getInt("albumID"));		
				albums.setGenreName(rs.getString("genreName"));
				article.add(albums);
			}
			
		}catch(Exception e) {
			System.out.println("albumList()메서드 에러유발"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		
		return article;
		
	}
	

}
