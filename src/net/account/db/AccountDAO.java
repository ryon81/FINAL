package net.account.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AccountDAO 
{
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AccountDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}	
	//-----계좌관리----------------
	public List getActMgrList(long user_no)
	{
		String account_list_sql="select * from ACCOUNTMGR where USER_NO is ?";
				
		List list = new ArrayList();
		
		try
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(account_list_sql);
			pstmt.setLong(1, user_no);		
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				AccountBean account = new AccountBean();
				
				account.setUSER_NO(rs.getInt("USER_NO"));
				account.setBALANCE(rs.getInt("BALANCE"));
				account.setACCTYPE(rs.getString("ACCTYPE"));
				account.setINTEREST(rs.getInt("INTEREST"));
				account.setACCOUNTNO(rs.getLong("ACCOUNTNO"));
				account.setACCOUNT(rs.getString("ACOUNT"));
				account.setUSAGE(rs.getString("USAGE"));
				
				list.add(account);
			}
			return list;
		} catch (Exception ex)
		{
			System.out.println("getIncomeList 에러 : " + ex);
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;		
	}
	
	//-----수입내용 표시하기
	public List getIncomeList(long user_no)
	{
		String income_list_sql="select * from INCOME where USER_NO is ?";
				
		List list = new ArrayList();
		
		try
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(income_list_sql);
			pstmt.setLong(1, user_no);		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AccountBean account = new AccountBean();
				
				account.setUSER_NO(rs.getInt("USER_NO"));
				account.setAMOUNTS(rs.getInt("AMOUNTS"));
				account.setMEMO(rs.getString("MEMO"));
				account.setINC_DATE(rs.getDate("INC_DATE"));
				account.setACCOUNTNO(rs.getLong("ACCOUNTNO"));
				account.setCATEGORYNO(rs.getLong("CATEGORYNO"));			
				
				list.add(account);
			}
			return list;
		} catch (Exception ex)
		{
			System.out.println("getIncomeList 에러 : " + ex);
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;		
	}
	//-----지출내용 표시하기
	public List getExpenseList(long user_no, Date startdate, Date enddate)
	{		
		String expense_list_sql="select * from EXPENSES where EXP_DATE>= ? and EXP_DATE <= ? and USER_NO is ?";
				
		List list = new ArrayList();
		
		try
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(expense_list_sql);
			pstmt.setDate(1, startdate);
			pstmt.setDate(2, enddate);
			pstmt.setLong(3, user_no);		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AccountBean account = new AccountBean();
				
				account.setUSER_NO(rs.getInt("USER_NO"));
				account.setAMOUNTS(rs.getInt("AMOUNTS"));
				account.setMEMO(rs.getString("MEMO"));
				account.setEXP_DATE(rs.getDate("EXP_DATE"));
				account.setACCOUNTNO(rs.getLong("ACCOUNTNO"));
				account.setCATEGORYNO(rs.getLong("CATEGORYNO"));			
				
				list.add(account);
			}
			return list;
		} catch (Exception ex)
		{
			System.out.println("getExpenseList 에러 : " + ex);
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;		
	}
	
	//-----카테고리관리----------------
	public List getCatMgrList(long user_no)
	{
		String category_list_sql="select * from CATEGORYMGR where USER_NO is ?";
				
		List list = new ArrayList();
		
		try
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(category_list_sql);
			pstmt.setLong(1, user_no);		
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				AccountBean account = new AccountBean();
				
				account.setUSER_NO(rs.getInt("USER_NO"));
				account.setAMOUNTS(rs.getInt("AMOUNTS"));
				account.setMEMO(rs.getString("MEMO"));
				account.setINC_DATE(rs.getDate("INC_DATE"));
				account.setACCOUNTNO(rs.getLong("ACCOUNTNO"));
				account.setCATEGORYNO(rs.getLong("CATEGORYNO"));			
				
				list.add(account);
			}
			return list;
		} catch (Exception ex)
		{
			System.out.println("getIncomeList 에러 : " + ex);
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;		
	}
	
	//-----지출입력----------------
	public boolean ExpenseInsert(AccountBean account){
		
		long num = 0;
		String sql="";
		
		int result=0;
			
		try
		{
			con = ds.getConnection();
			pstmt=con.prepareStatement("select max(EXP_SQ) from EXPENSES");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getLong(1)+1;
			else
				num = 3000001;

			sql="insert into EXPENSES (EXP_SQ,USER_NO,AMONUTS,MEMO,ACCOUNTNO,CATEGORYNO,EXP_DATE) values(?,?,?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, account.getEXP_SQ());
			pstmt.setLong(2, account.getUSER_NO());
			pstmt.setLong(3, account.getAMOUNTS());
			pstmt.setString(4, account.getMEMO());
			pstmt.setLong(5, account.getACCOUNTNO());
			pstmt.setLong(6, account.getCATEGORYNO());
			pstmt.setDate(7, account.getEXP_DATE());			

			result=pstmt.executeUpdate();
			if(result==0)return false;

			return true;
		}catch(Exception ex){
			System.out.println("accountInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
			return false;
	}

	
	/*
	public List getAccountList(int page,int limit){
		
		String account_list_sql="select * from "+
		"(select rownum rnum,ACCOUNT_NUM,ACCOUNT_NAME,ACCOUNT_SUBJECT,"+
		"ACCOUNT_CONTENT,ACCOUNT_FILE,ACCOUNT_RE_REF,ACCOUNT_RE_LEV,"+
		"ACCOUNT_RE_SEQ,ACCOUNT_READCOUNT,ACCOUNT_DATE from "+
		"(select * from account order by ACCOUNT_RE_REF desc,ACCOUNT_RE_SEQ asc)) "+
		"where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		
		int startrow=(page-1)*10+1; //읽기 시작할 row 번호.
		int endrow=startrow+limit-1; //읽을 마지막 row 번호.		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(account_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AccountBean account = new AccountBean();
				account.setACCOUNT_NUM(rs.getInt("ACCOUNT_NUM"));
				account.setACCOUNT_NAME(rs.getString("ACCOUNT_NAME"));
				account.setACCOUNT_SUBJECT(rs.getString("ACCOUNT_SUBJECT"));
				account.setACCOUNT_CONTENT(rs.getString("ACCOUNT_CONTENT"));
				account.setACCOUNT_FILE(rs.getString("ACCOUNT_FILE"));
				account.setACCOUNT_RE_REF(rs.getInt("ACCOUNT_RE_REF"));
				account.setACCOUNT_RE_LEV(rs.getInt("ACCOUNT_RE_LEV"));
				account.setACCOUNT_RE_SEQ(rs.getInt("ACCOUNT_RE_SEQ"));
				account.setACCOUNT_READCOUNT(rs.getInt("ACCOUNT_READCOUNT"));
				account.setACCOUNT_DATE(rs.getDate("ACCOUNT_DATE"));
				list.add(account);
			}
			
			return list;
		}catch(Exception ex){
			System.out.println("getAccountList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	
	
	
	public int getListCount() {
		int x= 0;
		
		try{
			
			con=ds.getConnection();			
			pstmt=con.prepareStatement("select count(*) from account");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	//글 목록 보기
	public List getAccountList(int page,int limit){
	
		String account_list_sql="select * from "+
		"(select rownum rnum,ACCOUNT_NUM,ACCOUNT_NAME,ACCOUNT_SUBJECT,"+
		"ACCOUNT_CONTENT,ACCOUNT_FILE,ACCOUNT_RE_REF,ACCOUNT_RE_LEV,"+
		"ACCOUNT_RE_SEQ,ACCOUNT_READCOUNT,ACCOUNT_DATE from "+
		"(select * from account order by ACCOUNT_RE_REF desc,ACCOUNT_RE_SEQ asc)) "+
		"where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		
		int startrow=(page-1)*10+1; //읽기 시작할 row 번호.
		int endrow=startrow+limit-1; //읽을 마지막 row 번호.		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(account_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AccountBean account = new AccountBean();
				account.setACCOUNT_NUM(rs.getInt("ACCOUNT_NUM"));
				account.setACCOUNT_NAME(rs.getString("ACCOUNT_NAME"));
				account.setACCOUNT_SUBJECT(rs.getString("ACCOUNT_SUBJECT"));
				account.setACCOUNT_CONTENT(rs.getString("ACCOUNT_CONTENT"));
				account.setACCOUNT_FILE(rs.getString("ACCOUNT_FILE"));
				account.setACCOUNT_RE_REF(rs.getInt("ACCOUNT_RE_REF"));
				account.setACCOUNT_RE_LEV(rs.getInt("ACCOUNT_RE_LEV"));
				account.setACCOUNT_RE_SEQ(rs.getInt("ACCOUNT_RE_SEQ"));
				account.setACCOUNT_READCOUNT(rs.getInt("ACCOUNT_READCOUNT"));
				account.setACCOUNT_DATE(rs.getDate("ACCOUNT_DATE"));
				list.add(account);
			}
			
			return list;
		}catch(Exception ex){
			System.out.println("getAccountList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//글 내용 보기.
	public AccountBean getDetail(int num) throws Exception{
		
		AccountBean account = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					"select * from account where ACCOUNT_NUM = ?");
			pstmt.setInt(1, num);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				account = new AccountBean();
				account.setACCOUNT_NUM(rs.getInt("ACCOUNT_NUM"));
				account.setACCOUNT_NAME(rs.getString("ACCOUNT_NAME"));
				account.setACCOUNT_SUBJECT(rs.getString("ACCOUNT_SUBJECT"));
				account.setACCOUNT_CONTENT(rs.getString("ACCOUNT_CONTENT"));
				account.setACCOUNT_FILE(rs.getString("ACCOUNT_FILE"));
				account.setACCOUNT_RE_REF(rs.getInt("ACCOUNT_RE_REF"));
				account.setACCOUNT_RE_LEV(rs.getInt("ACCOUNT_RE_LEV"));
				account.setACCOUNT_RE_SEQ(rs.getInt("ACCOUNT_RE_SEQ"));
				account.setACCOUNT_READCOUNT(rs.getInt("ACCOUNT_READCOUNT"));
				account.setACCOUNT_DATE(rs.getDate("ACCOUNT_DATE"));
			}
			return account;
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//글 등록
	public boolean accountInsert(AccountBean account){
		
		int num =0;
		String sql="";
		
		int result=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement("select max(account_num) from account");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			sql="insert into account (ACCOUNT_NUM,ACCOUNT_NAME,ACCOUNT_PASS,ACCOUNT_SUBJECT,";
			sql+="ACCOUNT_CONTENT, ACCOUNT_FILE, ACCOUNT_RE_REF,"+
				"ACCOUNT_RE_LEV,ACCOUNT_RE_SEQ,ACCOUNT_READCOUNT,"+
				"ACCOUNT_DATE) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, account.getACCOUNT_NAME());
			pstmt.setString(3, account.getACCOUNT_PASS());
			pstmt.setString(4, account.getACCOUNT_SUBJECT());
			pstmt.setString(5, account.getACCOUNT_CONTENT());
			pstmt.setString(6, account.getACCOUNT_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("accountInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//글 답변
	public int accountReply(AccountBean account){
		
		String account_max_sql="select max(account_num) from account";
		String sql="";
		int num=0;
		int result=0;
		
		int re_ref=account.getACCOUNT_RE_REF();
		int re_lev=account.getACCOUNT_RE_LEV();
		int re_seq=account.getACCOUNT_RE_SEQ();
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(account_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())num =rs.getInt(1)+1;
			else num=1;
			
			sql="update account set ACCOUNT_RE_SEQ=ACCOUNT_RE_SEQ+1 where ACCOUNT_RE_REF=? ";
			sql+="and ACCOUNT_RE_SEQ>?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			result=pstmt.executeUpdate();
			
			re_seq = re_seq +1;
			re_lev = re_lev +1;
			
			sql="insert into account (ACCOUNT_NUM,ACCOUNT_NAME,ACCOUNT_PASS,ACCOUNT_SUBJECT,";
			sql+="ACCOUNT_CONTENT, ACCOUNT_FILE,ACCOUNT_RE_REF,ACCOUNT_RE_LEV,ACCOUNT_RE_SEQ,";
			sql+="ACCOUNT_READCOUNT,ACCOUNT_DATE) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, account.getACCOUNT_NAME());
			pstmt.setString(3, account.getACCOUNT_PASS());
			pstmt.setString(4, account.getACCOUNT_SUBJECT());
			pstmt.setString(5, account.getACCOUNT_CONTENT());
			pstmt.setString(6, ""); //답장에는 파일을 업로드하지 않음.
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			pstmt.executeUpdate();
			return num;
		}catch(SQLException ex){
			System.out.println("accountReply 에러 : "+ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return 0;
	}
	
	//글 수정
	public boolean accountModify(AccountBean modifyaccount) throws Exception{
		
		String sql="update account set ACCOUNT_SUBJECT=?,ACCOUNT_CONTENT=? where ACCOUNT_NUM=?";
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyaccount.getACCOUNT_SUBJECT());
			pstmt.setString(2, modifyaccount.getACCOUNT_CONTENT());
			pstmt.setInt(3, modifyaccount.getACCOUNT_NUM());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("accountModify 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
			}
		return false;
	}
	
	//글 삭제
	public boolean accountDelete(int num){
		
		String account_delete_sql="delete from account where ACCOUNT_num=?";
		
		int result=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(account_delete_sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("accountDelete 에러 : "+ex);
		}	finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null) con.close();
				}
				catch(Exception ex){}
			
		}
		
		return false;
	}
	
	//조회수 업데이트
	public void setReadCountUpdate(int num) throws Exception{
		
		String sql="update account set ACCOUNT_READCOUNT = "+
			"ACCOUNT_READCOUNT+1 where ACCOUNT_NUM = "+num;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			try{
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			}
			catch(Exception ex){}
		
	}
	}
	
	//글쓴이인지 확인
	public boolean isAccountWriter(int num,String pass){
		
		String account_sql="select * from account where ACCOUNT_NUM=?";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(account_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			
			if(pass.equals(rs.getString("ACCOUNT_PASS"))){
				return true;
			}
		}catch(SQLException ex){
			System.out.println("isAccountWriter 에러 : "+ex);
		}
	finally{
			try{
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			}
			catch(Exception ex){}
		
	}
		return false;
	}
*/
}
	
