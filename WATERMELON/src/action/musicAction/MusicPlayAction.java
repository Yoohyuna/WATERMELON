package action.musicAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import track_info.Track_InfoDAO;

public class MusicPlayAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String next = request.getParameter("next");
		String pre = request.getParameter("pre");
		if (request.getParameter("t_ID") != null) {
			int t_ID = Integer.parseInt(request.getParameter("t_ID"));
			Track_InfoDAO dao = new Track_InfoDAO();
			String Directory = dao.TrackIdCheck(t_ID);
			System.out.println("Directory=>" + Directory);
			request.setAttribute("Directory", Directory);
			request.setAttribute("t_ID", t_ID);
		}

		request.setAttribute("next", next);
		request.setAttribute("pre", pre);

		return "/Music/MusicPlay.jsp";
	}
}
