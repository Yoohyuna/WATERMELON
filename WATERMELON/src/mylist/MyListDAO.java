package mylist;

//DB사용
import java.sql.*;
import java.util.*;
import mylist.MyListDTO;
import notice.DBConnectionMgr;


public class MyListDAO {

	
	private DBConnectionMgr pool=null; 
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";
	
	
	//생성자 통해서 연결
		public MyListDAO() {
			try {
				pool=DBConnectionMgr.getInstance();
				System.out.println("pool=>"+pool);
			}catch(Exception e) {
				System.out.println("DB접속오류=>"+e);
			}
		}

		
		
	// 담긴 곡 갯수를 구함.
		public int getMyListCount(String id) { 
			int x=0;
			
			try {
				con=pool.getConnection();
				System.out.println("con="+con);
				sql="select count(*) from board";  //select count(*) from member
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) { //보여주는 결과가 있다면
					x=rs.getInt(1);// 변수명=rs.get자료형(필드명 또는 인덱스번호)
					                       //필드명이 아니기때문에 select ~ from 사이에 나오는 순서
				}
			}catch(Exception e) {
				System.out.println("getArticleCount()메서드 에러유발"+e);
			}finally {
				pool.freeConnection(con,pstmt,rs);
			}
			return x;
		}
		
	
	// 곡 담기
	
	// 곡 뿌리기
	
	// 곡 삭제하기
	
	
	
}
