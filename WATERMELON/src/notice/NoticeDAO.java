package notice;

//DB���
import java.sql.*;


//ArrayList,List�� ����ϱ� ���ؼ�
import java.util.*;

import notice.NoticeDTO;


public class NoticeDAO {

	//DB ���� ��� �ʿ��� ������� ����
	private DBConnectionMgr pool=null; 
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";//�����ų SQL���� ����
	
	//������ ���ؼ� ����
	public NoticeDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB���ӿ���=>"+e);
		}
	}
	 
	
	//���ڵ� ������ ����.
	public int getNoticeCount(String search,String searchtext) { //->getMemberCount()
		int x=0;//���ڵ尹��
		
		try {
			con=pool.getConnection();
			///�˻�� �Է����� �������(�˻��о� ����X)
			if(search == null || search == "") {
				sql="select count(*) from notice";  //select count(*) from member
			}else { 
			   if(search.contentEquals("n_subject")) {
	           sql="select count(*) from notice  where n_subject like '%"+searchtext+"%' ";
			   }else {
			  sql="select count(*) from notice where n_content like '%"+searchtext+"%' ";	   
			   }
			}
			System.out.println("getNoticeCount �� �˻��� sql=>"+sql);
			//----------------------------------------------------------------------
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) { //�����ִ� ����� �ִٸ�
				x=rs.getInt(1);// ������=rs.get�ڷ���(�ʵ�� �Ǵ� �ε�����ȣ)
				                       //�ʵ���� �ƴϱ⶧���� select ~ from ���̿� ������ ����
			}
		}catch(Exception e) {
			System.out.println("getNoticeCount()�޼��� ��������"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return x;
	}
	
	// �� ��Ϻ���
	public List getNotice(int start, int end,String search,String searchtext) { 
		List NoticeList = null;// ArrayList articleList=null;

		try {
			con = pool.getConnection();
            //------------------------------------------------------------------------------
			if(search == null || search == "") {
				sql = "select * from notice order by n_Num desc limit ?,?"; // 1,10
			}else {
				if(search.contentEquals("n_subject")) {
			           sql="select * from notice where n_subject like '%"+searchtext
					                                    +"%' order by n_Num desc limit ?,?";
				}else { 
					  sql="select * from notice where n_content like '%"+searchtext
							                            +"%' order by n_Num desc limit ?,?";	   
				}
			}
			System.out.println("getNotice()�� sql=>"+sql);
			//------------------------------------------------------------------------------
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start - 1);// mysql�� ���ڵ������ ���������� 0���� ����
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {// ���ڵ尡 �����Ѵٸ�(�ּҸ��� 1��)

				NoticeList = new ArrayList(end);// 10->end������ŭ �����͸� ���� ���������϶�
				do {
					NoticeDTO article = makeNotice();
					NoticeList.add(article);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getNotice()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return NoticeList;
	}
	
	
	//����¡ ó���� ���� ���ִ� �޼��� �ۼ�
	public Hashtable pageList(String pageNum, int count) {
		
		Hashtable<String,Integer> pgList = new Hashtable<String, Integer>();
		
		int pageSize=10;
		int blockSize=2;
		
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);//����������->nowPage
	    //���۷��ڵ��ȣ ->limit ?,?
	    //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21
	    int startRow=(currentPage-1)*pageSize+1;		
	    int endRow=currentPage*pageSize;//1*10=10,2*10=20,3*10=30
	    int number=0; // beginPerPage -> �������� �����ϴ� �� ó���� ������ �Խù� ��ȣ
	    System.out.println("���� ���ڵ��(count)=>"+count);
	    number=count-(currentPage-1)*pageSize;
	    System.out.println("�������� number=>"+number);
	    
	  //�� ��������, ����, ���������� ���
	    int pageCount=count/pageSize+(count%pageSize==0?0:1);
	       //2.���������� 
	       //���� �������� ���->10->10���,3->3�� ���
	       int startPage=0;//1,2,3,,,,10 [������ 10],11,12,,,,,20
	       if(currentPage%blockSize!=0){ //1~9,11~19,21~29,,,
	    	   startPage=currentPage/blockSize*blockSize+1;
	       }else{ //10%10 (10,20,30,40~)
	    	   //             ((10/10)-1)*10+1=1
	    	  startPage=((currentPage/blockSize)-1)*blockSize+1; 
	       }
	       int endPage=startPage+blockSize-1;//1+10-1=10
	       System.out.println("startPage="+startPage+",endPage=>"+endPage);
	       //������ �����ؼ� ��ũ�ɾ ���
	       if(endPage > pageCount) endPage=pageCount;//������������=����������
	       
	     //~DAO -> �������� ������ ���õ� �ڵ� -> �׼�Ŭ������ ���� -> view(jsp)�� �������
	       pgList.put("pageSize", pageSize);
	       pgList.put("blockSize", blockSize);
	       pgList.put("currentPage", currentPage);
	       pgList.put("startRow", startRow);
	       pgList.put("endRow", endRow);
	       pgList.put("count", count);
	       pgList.put("number", number);
	       pgList.put("startPage", startPage);
	       pgList.put("endPage", endPage);
	       pgList.put("pageCount", pageCount);
	    
	    return pgList;
	}
	
	
	//�۾���
	public void insertNotice(NoticeDTO notice) { //~(MemberDTO mem)
		
		int n_Num=0;
		
		try {
			con=pool.getConnection();
			sql="select max(n_Num) from notice"; //�ִ밪+1=���� ������ �Խù���ȣ
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {//���� ���̺��� �����Ͱ� �Ѱ��� �����Ѵٸ�
				n_Num=rs.getInt(1)+1;
			}else { //�� ó���� ���ڵ尡 �Ѱ��� ���ٸ� ������ number=1
				n_Num=1;
			}
			
			sql="insert into notice(n_Num,n_subject,n_content,writedate,readCount)values(?,?,?,now(),?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n_Num);
			pstmt.setString(2, notice.getN_subject());
			pstmt.setString(3, notice.getN_content());
			pstmt.setInt(4, 0);
			//pstmt.setTimestamp(5, article.getReg_date());//������ ����ؼ� ����
			int insert=pstmt.executeUpdate();
			System.out.println("�۾��� ��������(insert)=>"+insert);
		}catch(Exception e) {
			System.out.println("insertNotice()�޼��� ��������=>"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
	}
	
	
	//�� �󼼺���
	public NoticeDTO getNoticeContent(int n_Num) {
		NoticeDTO notice=null;
		
		try {
			con=pool.getConnection();
			sql="update notice set readCount=readCount+1 where n_Num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n_Num);
			int update=pstmt.executeUpdate();
			System.out.println("��ȸ�� ��������(update)=>"+update);
			
			sql="select * from notice where n_Num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n_Num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//���ڵ尡 �����Ѵٸ�
				notice=makeNotice();
				
			}
		}catch(Exception e) {
			System.out.println("getNoticeContent()�޼��� ��������"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		return notice;
	}
	
	
	
	// �� �����ϱ�
	public void updateNotice(NoticeDTO notice) {
		 
		
		 try {
			 con=pool.getConnection();
			 sql="update notice set n_subject=?,n_content=? where n_Num=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, notice.getN_subject());
			 pstmt.setString(2, notice.getN_content());
			 pstmt.setInt(3, notice.getN_Num());
			 int update=pstmt.executeUpdate();
			 System.out.println("�Խ����� �ۼ��� ��������(update)="+update);
		 }catch(Exception e) {
			 System.out.println("updateNotice()�޼��� ��������=>"+e);
		 }finally {
			 pool.freeConnection(con, pstmt);
		 }
	}
		 
	
	
	// �� ����
	
	public int deleteNotice(int n_Num,String password, int role) {
		
		 String dbpasswd=null;//db���� ã�� ��ȣ�� ����
		 int x=-1;//�Խù��� ������������
		 
		 try {
			 con=pool.getConnection();
			 sql="select password from accounts where admin=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1, role);
		     rs=pstmt.executeQuery();
		     
		     if(rs.next()) {
		    	 dbpasswd=rs.getString("password");
		    	 System.out.println("dbpasswd=>"+dbpasswd);//Ȯ�ε� �ڿ��� �����Ұ�.
		    	 //db���� ��ȣ=���� �Է��� ��ȣ�� �´ٸ�
		    	 if(dbpasswd.equals(password)) {
		    		 sql="delete from notice where n_Num=?";
		    		
		    		 pstmt=con.prepareStatement(sql);
		    		 pstmt.setInt(1, n_Num);
		    		 int delete=pstmt.executeUpdate();
		    		 System.out.println("�Խ����� �ۻ��� ��������(delete)="+delete);//1����
		    		 x=1;
		    	 }else {
		    		 x=0;//���� ����
		    	 }
		     }//if(rs.next())->x=-1;
		 }catch(Exception e) {
			 System.out.println("deleteNotice()�޼��� ��������=>"+e);
		 }finally {
			pool.freeConnection(con, pstmt, rs); //��ȣ�� ã�� ������
		 }
		 return x;
	}

	
	
	//---------------------------�ߺ��� ���ڵ� �ѹ��� ���� �� �ִ� �޼���----
	private NoticeDTO makeNotice() throws Exception{
		NoticeDTO article=new NoticeDTO();
		article.setN_Num(rs.getInt("n_Num"));
		article.setN_subject(rs.getString("n_subject"));
		article.setN_content(rs.getString("n_content"));
		article.setWritedate(rs.getTimestamp("writedate"));
		article.setReadCount(rs.getInt("readCount"));
		return article;
	}
	
	
}
