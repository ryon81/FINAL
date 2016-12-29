package net.member.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.account.action.Action;
import net.account.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	request.setCharacterEncoding("euc-kr");
		 	
		 	ActionForward forward = new ActionForward();
		 	
			MemberDAO memberdao=new MemberDAO();
	   		MemberBean member=new MemberBean();
	   		
	   		boolean result=false;
	   			   		
	   		member.setACCID(request.getParameter("ACCID"));
	   		member.setPASSWORD(request.getParameter("PASSWORD"));
	   		member.setNAME(request.getParameter("NAME"));
	   		member.setAGE(Integer.parseInt(request.getParameter("AGE")));
	   		member.setGENDER(request.getParameter("GENDER"));
	   		member.setEMAIL(request.getParameter("EMAIL"));	   		
	   			   		
	   		result=memberdao.joinMember(member);
	   		
	   		if(result==false){
	   			System.out.println("회원가입 실패");
		   		return null;
		   	}
	   		
	   		//회원가입 성공.
	   		forward.setRedirect(true);
	   		forward.setPath("./MemberLogin.am");
	   		return forward;
	}
}