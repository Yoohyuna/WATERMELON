package action.noticeAction;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import accounts.AccountsDTO;
import action.CommandAction;
//�߰�
import notice.*;
import java.util.*;

//list.water=action.ListAction ����
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int role = Integer.parseInt(request.getParameter("role"));
		String pageNum = request.getParameter("pageNum"); // �߰� (�˻��о�, �˻���) String
		String search = request.getParameter("search");
		String searchtext = request.getParameter("searchtext");
		
		
		
		int count = 0;// �ѷ��ڵ��
		List noticeList = null;// ȭ�鿡 ����� ���ڵ带 ������ ����

		NoticeDAO dbPro = new NoticeDAO();
		count = dbPro.getNoticeCount(search, searchtext); // sql������ ���� �޶�����.
		System.out.println("���� �˻��� ���ڵ��(count)=>" + count);

		Hashtable<String, Integer> pgList = dbPro.pageList(pageNum, count);

		if (count > 0) {
			System.out.println(pgList.get("startRow") + "," + pgList.get("endRow"));
			noticeList = dbPro.getNotice(pgList.get("startRow"), pgList.get("pageSize"), search, searchtext); // ù��°
																												// ���ڵ��ȣ,�ҷ��ð���
			// endRow(X)
		} else {
			noticeList = Collections.EMPTY_LIST; // �ƹ��͵� ���� �� list ��ü ��ȯ
		}

		// 2. request ��ü�� ����

		request.setAttribute("role", role);
		request.setAttribute("search", search); // �˻��о�
		request.setAttribute("searchtext", searchtext); // �˻���
		request.setAttribute("pgList", pgList); // ����¡ó�� 10������
		request.setAttribute("noticeList", noticeList); // ${articleList}

		// 3. �����ؼ� �̵��� �� �ֵ��� ����
		return "/notice/notice.jsp"; // /board/list.jsp request.getAttribute("currentPage")=${currentPage}
	}

}
