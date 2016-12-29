package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public MemberDAO() {
		try{
			Context init = new InitialContext();
	  		ds = 
	  			(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}
	
	public int isMember(MemberBean member){
		String sql="SELECT PASSWORD FROM MEMBER WHERE ACCID=?";
		int result=-1;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getACCID());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("PASSWORD").equals(member.getPASSWORD())){
					result=1;//일치.
				}else{
					result=0;//불일치.
				}
			}else{
				result=-1;//아이디 존재하지 않음.
			}
		}catch(Exception ex){
			System.out.println("isMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	
	public boolean joinMember(MemberBean member){
		int result=0;
		long num = 0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement("select max(USER_NO) from REGISTER");
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				num = rs.getLong(1)+1;
			} else
			{
				num = 100001;
			}
			String sql="INSERT INTO REGISTER VALUES (?,?,?,?,?,?,?,sysdate)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, num);
			pstmt.setString(2, member.getACCID());
			pstmt.setString(3, member.getPASSWORD());
			pstmt.setString(4, member.getNAME());
			pstmt.setInt(5, member.getAGE());
			pstmt.setString(6, member.getGENDER());
			pstmt.setString(7, member.getEMAIL());			
			result=pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
		}catch(Exception ex){
			System.out.println("joinMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	public List getMemberList(){
		String sql="SELECT * FROM REGISTER";
		List memberlist=new ArrayList();
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				MemberBean mb=new MemberBean();
				mb.setUSER_NO(rs.getLong("USER_NO"));
				mb.setACCID(rs.getString("ACCID"));
				mb.setPASSWORD(rs.getString("PASSWORD"));
				mb.setNAME(rs.getString("NAME"));
				mb.setAGE(rs.getInt("AGE"));
				mb.setGENDER(rs.getString("GENDER"));
				mb.setEMAIL(rs.getString("EMAIL"));
				mb.setREGDATE(rs.getDate("REGDATE"));
				
				memberlist.add(mb);
			}
			
			return memberlist;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public MemberBean getDetailMember(String id){
		String sql="SELECT * FROM REGISTER WHERE USER_NO=?";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();
			
			MemberBean mb=new MemberBean();
			mb.setUSER_NO(rs.getLong("USER_NO"));
			mb.setACCID(rs.getString("ACCID"));
			mb.setPASSWORD(rs.getString("PASSWORD"));
			mb.setNAME(rs.getString("NAME"));
			mb.setAGE(rs.getInt("AGE"));
			mb.setGENDER(rs.getString("GENDER"));
			mb.setEMAIL(rs.getString("EMAIL"));
			mb.setREGDATE(rs.getDate("REGDATE"));
			
			return mb;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	
	public boolean deleteMember(String id){
	 String sql ="DELETE FROM REGISTER WHERE USER_NO=?";
	 int result = 0;
	 try{
	  con = ds.getConnection();
	  pstmt=con.prepareStatement(sql);
	  pstmt.setString(1,id);

	  result = pstmt.executeUpdate();
	  if(result != 0){
	   return true;
	  }

	 }
	 catch(Exception ex){
	  System.out.println("deleteMember 에러: " + ex);	
	 }

	 finally{
	 if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
	 }
	 return false;
	}	
}