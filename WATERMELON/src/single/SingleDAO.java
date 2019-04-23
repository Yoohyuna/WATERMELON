package single;

import java.sql.*;
import java.util.*;


import single.DBConnectionMgr;
import single.SingleDTO;

public class SingleDAO {


	//DB 접속 경우 필요한 멤버변수 선언
	private DBConnectionMgr pool=null; 
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";//실행시킬 SQL구문 저장
	
	//생성자 통해서 연결
	public SingleDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB접속오류=>"+e);
		}
	}
	 
	public SingleDTO getSingleContent(int t_ID) {
		SingleDTO Single=null;
		
		try {
			con=pool.getConnection();
			System.out.println("노래 상세정보 불러오기");
			sql="select t1.t_ID, t1.musicName, t1.time, t1.artistID, t1.albumID, t2.artistName, t3.a_imgDir ";
			sql+="from Track_info t1, Artist t2, Album t3 ";
			sql+="where t1.artistID=t2.artistID and t1.albumID=t3.albumID and t_ID=? ";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, t_ID);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				Single = new SingleDTO();
				Single.setT_ID(rs.getInt("t_ID"));
				Single.setArtistID(rs.getInt("artistID"));
				Single.setAlbumID(rs.getInt("albumID"));
				
				Single.setMusicName(rs.getString("musicName"));
				Single.setTime(rs.getString("time"));
				Single.setArtistName(rs.getString("artistName"));
			
				Single.setA_imgDir(rs.getString("a_imgDir"));
				
			}
		}catch(Exception e) {
			System.out.println("public SingleDTO getSingleContent(int t_ID) 에러"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		return Single;
	}
	
	
	
}
