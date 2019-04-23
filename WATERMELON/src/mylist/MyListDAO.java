package mylist;

//DB���
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
	
	
	//������ ���ؼ� ����
		public MyListDAO() {
			try {
				pool=DBConnectionMgr.getInstance();
				System.out.println("pool=>"+pool);
			}catch(Exception e) {
				System.out.println("DB���ӿ���=>"+e);
			}
		}

		
		
	// ��� �� ������ ����.
		public int getMyListCount(String id) { 
			int x=0;
			
			try {
				con=pool.getConnection();
				System.out.println("con="+con);
				sql="select count(*) from board";  //select count(*) from member
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) { //�����ִ� ����� �ִٸ�
					x=rs.getInt(1);// ������=rs.get�ڷ���(�ʵ�� �Ǵ� �ε�����ȣ)
					                       //�ʵ���� �ƴϱ⶧���� select ~ from ���̿� ������ ����
				}
			}catch(Exception e) {
				System.out.println("getArticleCount()�޼��� ��������"+e);
			}finally {
				pool.freeConnection(con,pstmt,rs);
			}
			return x;
		}
		
	
	// �� ���
	
	// �� �Ѹ���
	
	// �� �����ϱ�
	
	
	
}
