package notice;

//DB사용
import java.sql.*;


//ArrayList,List을 사용하기 위해서
import java.util.*;

import notice.NoticeDTO;


public class NoticeDAO {

	//DB 접속 경우 필요한 멤버변수 선언
	private DBConnectionMgr pool=null; 
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";//실행시킬 SQL구문 저장
	
	//생성자 통해서 연결
	public NoticeDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB접속오류=>"+e);
		}
	}
	 
	
	//레코드 갯수를 구함.
	public int getNoticeCount(String search,String searchtext) { //->getMemberCount()
		int x=0;//레코드갯수
		
		try {
			con=pool.getConnection();
			///검색어를 입력하지 않은경우(검색분야 선택X)
			if(search == null || search == "") {
				sql="select count(*) from notice";  //select count(*) from member
			}else { 
			   if(search.contentEquals("n_subject")) {
	           sql="select count(*) from notice  where n_subject like '%"+searchtext+"%' ";
			   }else {
			  sql="select count(*) from notice where n_content like '%"+searchtext+"%' ";	   
			   }
			}
			System.out.println("getNoticeCount 의 검색어 sql=>"+sql);
			//----------------------------------------------------------------------
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) { //보여주는 결과가 있다면
				x=rs.getInt(1);// 변수명=rs.get자료형(필드명 또는 인덱스번호)
				                       //필드명이 아니기때문에 select ~ from 사이에 나오는 순서
			}
		}catch(Exception e) {
			System.out.println("getNoticeCount()메서드 에러유발"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return x;
	}
	
	// 글 목록보기
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
			System.out.println("getNotice()의 sql=>"+sql);
			//------------------------------------------------------------------------------
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start - 1);// mysql은 레코드순번이 내부적으로 0부터 시작
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 레코드가 존재한다면(최소만족 1개)

				NoticeList = new ArrayList(end);// 10->end갯수만큼 데이터를 담을 공간생성하라
				do {
					NoticeDTO article = makeNotice();
					NoticeList.add(article);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getNotice()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return NoticeList;
	}
	
	
	//페이징 처리를 따로 해주는 메서드 작성
	public Hashtable pageList(String pageNum, int count) {
		
		Hashtable<String,Integer> pgList = new Hashtable<String, Integer>();
		
		int pageSize=10;
		int blockSize=2;
		
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);//현재페이지->nowPage
	    //시작레코드번호 ->limit ?,?
	    //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21
	    int startRow=(currentPage-1)*pageSize+1;		
	    int endRow=currentPage*pageSize;//1*10=10,2*10=20,3*10=30
	    int number=0; // beginPerPage -> 페이지별 시작하는 맨 처음에 나오는 게시물 번호
	    System.out.println("현재 레코드수(count)=>"+count);
	    number=count-(currentPage-1)*pageSize;
	    System.out.println("페이지별 number=>"+number);
	    
	  //총 페이지수, 시작, 종료페이지 계산
	    int pageCount=count/pageSize+(count%pageSize==0?0:1);
	       //2.시작페이지 
	       //블럭당 페이지수 계산->10->10배수,3->3의 배수
	       int startPage=0;//1,2,3,,,,10 [다음블럭 10],11,12,,,,,20
	       if(currentPage%blockSize!=0){ //1~9,11~19,21~29,,,
	    	   startPage=currentPage/blockSize*blockSize+1;
	       }else{ //10%10 (10,20,30,40~)
	    	   //             ((10/10)-1)*10+1=1
	    	  startPage=((currentPage/blockSize)-1)*blockSize+1; 
	       }
	       int endPage=startPage+blockSize-1;//1+10-1=10
	       System.out.println("startPage="+startPage+",endPage=>"+endPage);
	       //블럭별로 구분해서 링크걸어서 출력
	       if(endPage > pageCount) endPage=pageCount;//마지막페이지=총페이지수
	       
	     //~DAO -> 실질적인 업무에 관련된 코딩 -> 액션클래스로 전달 -> view(jsp)에 최종출력
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
	
	
	//글쓰기
	public void insertNotice(NoticeDTO notice) { //~(MemberDTO mem)
		
		int n_Num=0;
		
		try {
			con=pool.getConnection();
			sql="select max(n_Num) from notice"; //최대값+1=실제 저장할 게시물번호
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {//현재 테이블에서 데이터가 한개라도 존재한다면
				n_Num=rs.getInt(1)+1;
			}else { //맨 처음에 레코드가 한개라도 없다면 무조건 number=1
				n_Num=1;
			}
			
			sql="insert into notice(n_Num,n_subject,n_content,writedate,readCount)values(?,?,?,now(),?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n_Num);
			pstmt.setString(2, notice.getN_subject());
			pstmt.setString(3, notice.getN_content());
			pstmt.setInt(4, 0);
			//pstmt.setTimestamp(5, article.getReg_date());//웹에서 계산해서 저장
			int insert=pstmt.executeUpdate();
			System.out.println("글쓰기 성공유무(insert)=>"+insert);
		}catch(Exception e) {
			System.out.println("insertNotice()메서드 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
	}
	
	
	//글 상세보기
	public NoticeDTO getNoticeContent(int n_Num) {
		NoticeDTO notice=null;
		
		try {
			con=pool.getConnection();
			sql="update notice set readCount=readCount+1 where n_Num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n_Num);
			int update=pstmt.executeUpdate();
			System.out.println("조회수 증가유무(update)=>"+update);
			
			sql="select * from notice where n_Num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n_Num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//레코드가 존재한다면
				notice=makeNotice();
				
			}
		}catch(Exception e) {
			System.out.println("getNoticeContent()메서드 에러유발"+e);
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		return notice;
	}
	
	
	
	// 글 수정하기
	public void updateNotice(NoticeDTO notice) {
		 
		
		 try {
			 con=pool.getConnection();
			 sql="update notice set n_subject=?,n_content=? where n_Num=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, notice.getN_subject());
			 pstmt.setString(2, notice.getN_content());
			 pstmt.setInt(3, notice.getN_Num());
			 int update=pstmt.executeUpdate();
			 System.out.println("게시판의 글수정 성공유무(update)="+update);
		 }catch(Exception e) {
			 System.out.println("updateNotice()메서드 에러유발=>"+e);
		 }finally {
			 pool.freeConnection(con, pstmt);
		 }
	}
		 
	
	
	// 글 삭제
	
	public int deleteNotice(int n_Num,String password, int role) {
		
		 String dbpasswd=null;//db에서 찾은 암호를 저장
		 int x=-1;//게시물의 삭제성공유무
		 
		 try {
			 con=pool.getConnection();
			 sql="select password from accounts where admin=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1, role);
		     rs=pstmt.executeQuery();
		     
		     if(rs.next()) {
		    	 dbpasswd=rs.getString("password");
		    	 System.out.println("dbpasswd=>"+dbpasswd);//확인된 뒤에는 삭제할것.
		    	 //db상의 암호=웹상에 입력한 암호가 맞다면
		    	 if(dbpasswd.equals(password)) {
		    		 sql="delete from notice where n_Num=?";
		    		
		    		 pstmt=con.prepareStatement(sql);
		    		 pstmt.setInt(1, n_Num);
		    		 int delete=pstmt.executeUpdate();
		    		 System.out.println("게시판의 글삭제 성공유무(delete)="+delete);//1성공
		    		 x=1;
		    	 }else {
		    		 x=0;//삭제 실패
		    	 }
		     }//if(rs.next())->x=-1;
		 }catch(Exception e) {
			 System.out.println("deleteNotice()메서드 에러유발=>"+e);
		 }finally {
			pool.freeConnection(con, pstmt, rs); //암호를 찾기 때문에
		 }
		 return x;
	}

	
	
	//---------------------------중복된 레코드 한번에 담을 수 있는 메서드----
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
