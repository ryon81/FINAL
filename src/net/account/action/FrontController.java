package net.account.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{ 
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/AccoutWrite.aj"))
		{
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_write.jsp");
		} else if (command.equals("/BoardReplyAction.bo"))
		{
			action = new AccoutReplyAction();
			try
			{
				forward = action.execute(request, response);				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		} else if(command.equals("/BoardDelete.aj"))
		{
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./accout/qna_accout_delete.jsp");			
		} else if(command.equals("/BoardModify.aj"))
		{
			action = new AccoutModifyView();
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		} else if(command.equals("/AccoutAddAction.aj"))
		{
			action = new AccoutAddAction();
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		} else if(command.equals("/AccoutReplyView.aj"))
		{
			action = new AccoutReplyView();
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		} else if(command.equals("/AccoutModifyAction.aj"))
		{
			action = new AccoutModifyAction();
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		} else if(command.equals("/AccoutDeleteAction.aj"))
		{
			action = new AccoutDeleteAction();
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		} else if(command.equals("/AccoutList.aj"))
		{			
			action = new AccoutListAction();			
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		} else if(command.equals("/AccoutDetailAction.aj"))
		{
			action = new AccoutDetailAction();
			try
			{
				forward = action.execute(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
		
		if(forward != null)
		{	
			if(forward.isRedirect())
			{
				response.sendRedirect(forward.getPath());
			} else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}			
		}
			
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcess(request, response);
	}
}
