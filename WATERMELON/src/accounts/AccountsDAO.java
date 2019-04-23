package accounts;

//DBConnectionMgr(DB����,����), BoardDTO(�Ű�����,��ȯ��)
//DB���
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import notice.DBConnectionMgr;

public class AccountsDAO { // MemberDAO

	private DBConnectionMgr pool = null;// 1.����
	// �߰�
	// �������� ������ ��� �ʿ��� �������
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";// �����ų SQL���� ����
	// 2.�����ڸ� ���ؼ� ����=>������

	public AccountsDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			System.out.println("DB���ӿ���=>" + e);
		}
	}// ������

	// �䱸�м��� ���� ȸ���α����� üũ�� ���ִ� �޼��� �ʿ�->
	// ����) public ��ȯ�� �޼����(�ڷ���(String) 2��)
	// select id,passwd from member where id='nup' and passwd='1234';

	public boolean loginCheck(String id, String password) {
		// 1.DB����
		boolean check = false;
		// 2.�����ų SQL->��ȯ�� ó��
		try {
			con = pool.getConnection();
			sql = "select id,password from accounts where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			check = rs.next();// �����Ͱ� ����->true, ������ ->false
		} catch (Exception e) {
			System.out.println("logCheck()���� ��������->" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return check;
		// 3.DB��������
	}

	// ȸ������->�ߺ� id�� üũ�� ���ִ� �޼��尡 �ʿ�
	// select id from member where id='nup';
	public boolean checkId(String id) {
		// 1.DB����
		boolean check = false;
		// 2.�����ų SQL->��ȯ�� ó��
		try {
			con = pool.getConnection();
			sql = "select id from accounts where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			check = rs.next();// �����Ͱ� ����->true, ������ ->false
		} catch (Exception e) {
			System.out.println("checkId()���� ��������->" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return check;
		// 3.DB��������
	}

	// ȸ������-> ��й�ȣ�� ��й�ȣ Ȯ�ζ��� ��ġ�ϴ��� üũ ���ִ� �޼��尡 �ʿ�

	public boolean checkPassword(String password, String password_confirm) {

		boolean check = false;

		try {
			if (password.equals(password_confirm)) {
				check = true;
			}
		} catch (Exception e) {
			System.out.println("checkPassword()���� ��������->" + e);
		}
		return check;
		// 3.DB��������
	}

// 4)ȸ������->insert into member values(?,?,?,?~);=>��ȯ�� 1,0
// AccountsDTO->1.���̺��� �ʵ庰�� ����,��� 2.�޼����� �Ű������� ��ȯ������ ���
	public boolean memberInsert(AccountsDTO account) {// ������ �Է��� �� ��ü��

		boolean check = false;// ȸ������ ��������
		// 2.�����ų SQL->��ȯ�� ó��
		try {
			con = pool.getConnection();
			// ----Ʈ����� ó��-----------------------------
			con.setAutoCommit(false);// �ڵ� commit�� �ϵ� ���ϵ��� ����
			// -------------------------------------------------
			sql = "insert into accounts(id, password, nickname, name, email, admin) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// String id, password, nickname, name, email; int admin;
			pstmt.setString(1, account.getId()); // (1,"test")
			pstmt.setString(2, account.getPassword());
			pstmt.setString(3, account.getNickname());
			pstmt.setString(4, account.getName());
			pstmt.setString(5, account.getEmail());
			pstmt.setInt(6, 0);// �Ϲ� ȸ���� 0 -> default : 0

			int insert = pstmt.executeUpdate();// ��ȯ 1 (����), 0 (����)
			con.commit();// ���������� insert �۵��ȴ�.
			if (insert > 0) {// if(insert==1)
				check = true;// ������ ����Ȯ��
			}
		} catch (Exception e) {
			System.out.println("memberInsert()���� ��������->" + e);
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return check;
	}

// 5)ȸ������->Ư�� ȸ�� ã��->nup
// ����)select * from member where id='nup';
	public AccountsDTO getAccount(String id) {

		AccountsDTO account = null;// id���� �ش�Ǵ� ���ڵ� �Ѱ��� ������ ��ü����

		try {
			con = pool.getConnection();
			sql = "select * from accounts where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// ã�� ���ڵ尡 �Ѱ� if(rs.next()) �Ѱ��̻� ->while(rs.next())
			if (rs.next()) {
				account = new AccountsDTO();
				// ã�� �ʵ尪->Setter Method����->���� ���->Getter Method
				account.setId(rs.getString("id")); // <%=account.getId()%>
				account.setPassword(rs.getString("password"));
				account.setNickname(rs.getString("nickname"));
				account.setName(rs.getString("name"));
				account.setEmail(rs.getString("email"));
				account.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			System.out.println("getAccount()�������=>" + e);// �α����Ϸ� �ۼ�->���
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return account;
	}

// 6)ã�� �����͸� ����->ȸ�����԰� ����
// update ���̺�� set �ʵ��=��,,, where ���ǽ�
	public boolean accountUpdate(String id, String password, String nickname, String email) {

		boolean check = false;// ȸ������ ��������
		// 2.�����ų SQL->��ȯ�� ó��
		try {
			con = pool.getConnection();
			// ----Ʈ����� ó��-----------------------------
			con.setAutoCommit(false);// �ڵ� commit�� �ϵ� ���ϵ��� ����
			// -------------------------------------------------
			sql = "update accounts set password=?,nickname=?,email=? where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, nickname);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			
			int update = pstmt.executeUpdate();// ��ȯ 1 (����), 0 (����)
			con.commit();// ���������� update �۵��ȴ�.
			if (update == 1) {
				check = true;// ��������
			}
			if (password.equals(null) || password.equals("")) {
				check = false; // ��й�ȣ�� �Ѿ��(���޹���) ���� �ΰ��� ��� ���� ���з� ��ȯ
			}
		} catch (Exception e) {
			System.out.println("accountUpdate()���� ��������->" + e);
		} finally {
			pool.freeConnection(con, pstmt);// rs�� ����.(select�� �ƴ�)
		}
		return check;
	}

// 7)ȸ�� Ż��->�����ų sql������ �ִ�
// select passwd from member where id=?
// ����)delete from member where id='nup';
	public int deleteAccount(String id, String password) {
		String dbpasswd = "";// DB�󿡼� ã�� ��ȣ�� ����
		int x = -1;// ȸ��Ż�� ����

		try {
			con = pool.getConnection();
			con.setAutoCommit(false);// Ʈ�����ó��
			// 1.id���� �ش��ϴ� ��ȣ���� ã��
			pstmt = con.prepareStatement("select password from accounts where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// ��ȣ�� �����Ѵٸ�
			if (rs.next()) {
				dbpasswd = rs.getString("password");// rs.getString(1);
				// dbpasswd(DB�󿡼� ã����ȣ)==passwd(���󿡼� �Է��� ��)
				if (dbpasswd.equals(password)) {
					pstmt = con.prepareStatement("delete from accounts where id=?");
					pstmt.setString(1, id);
					int delete = pstmt.executeUpdate();
					con.commit();
					x = 1;// ȸ��Ż�� ����
				} else {
					x = 0;// ȸ��Ż�� ����->��ȣ�� Ʋ�����
				}
			} /*
				 * else { x=-1;//��ȣ�� �������� ���� ��� }
				 */
		} catch (Exception e) {
			System.out.println("deleteAccount() ���࿡��=>" + e); // con.rollback();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;// 1,0,-1
	}

	// ���̵� ��й�ȣ �� ����ڿ��� �����ֱ� ���� DTO�� set�޼��带 ���ִ� �޼���

	// ���̵� ��й�ȣ ã�� �޼��� ( ���̵� �Ǵ� ��й�ȣ�� ã������ true ��ã���� false )
	public AccountsDTO findIdorPassword(String id, String name, String email) {
		AccountsDTO dto = null;
		String sql = "";
		try {
			con = pool.getConnection();
			// idã�� sql��
			if (id == null) {
				this.sql = "select id from accounts where name=? and email=?";
				pstmt = con.prepareStatement(this.sql);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
			} else {
				// passwordã�� sql��
				sql = "select password from accounts where id=? and name=? and email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, email);
			}
			rs = pstmt.executeQuery();
			// ã�� ���ڵ尡 �Ѱ� if(rs.next()) �Ѱ��̻� ->while(rs.next())
			if (rs.next()) {
				dto = new AccountsDTO();
				if (id == null) {
					dto.setId(rs.getString("id"));
					System.out.println("ã�� ���̵� ���� ?" + rs.getString("id"));
				} else {
					dto.setPassword(rs.getString("password"));
					System.out.println("ã�� ��й�ȣ ���� ?" + rs.getString("password"));
				}

			}
		} catch (Exception e) {
			System.out.println("findIdorPassword()�������=>" + e);// �α����Ϸ� �ۼ�->���
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return dto;
	}
}