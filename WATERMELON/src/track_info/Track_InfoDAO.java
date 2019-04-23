package track_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import accounts.AccountsDTO;
import accounts.DBConnectionMgr;

public class Track_InfoDAO {

	private DBConnectionMgr pool = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";

	public Track_InfoDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			System.out.println("DB���ӿ���=>" + e);
		}
	}

	public String TrackIdCheck(int t_ID) {
		// 1.DB����
		String Directory = null;
		// 2.�����ų SQL->��ȯ�� ó��
		try {
			con = pool.getConnection();
			sql = "select musicDir from track_info where t_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Directory = rs.getString("musicDir");
			}
		} catch (Exception e) {
			System.out.println("TrackIdCheck()���� ��������->" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return Directory;
	}

}