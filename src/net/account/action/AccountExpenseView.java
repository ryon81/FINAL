package net.account.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.account.db.AccountDAO;

public class AccountExpenseView implements Action
{	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		AccountDAO actdao = new AccountDAO();
		List actdata = new ArrayList();
		
		long num = Long.parseLong(request.getParameter("num"));
		Date startdate = new Date(16/12/01);
		Date enddate = new Date(16/12/01);
		
		actdata = actdao.getExpenseList(num, startdate, enddate);
		
		
		if (actdata==null)
		{
			System.out.println("지출 페이지 이동 실패");
			return null;
		}
		System.out.println("지출 페이지 이동 완료");
		
		request.setAttribute("actdata", actdata);
		forward.setRedirect(false);
		forward.setPath("./account/index.jsp");
		return forward;
	}
	
}