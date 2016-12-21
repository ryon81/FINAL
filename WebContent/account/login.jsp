<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="loginsession.jsp" method="post">
<center>
	<Table align="center" border="1">
		<tr>
			<td> 아이디 </td>
			<td colspan="2"> <input type="text" name="lid"/></td>
		</tr>
		<tr>
			<td> 비밀번호 </td>
			<td colspan="2"> <input type="text" name="pass"/></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="새사용자"/></td>
			<td align="center"><input type="submit" value="로그인"/></td>
			<td align="center"><input type="submit" value="종료"/></td>			
		</tr>	
	</Table>
</center>
</form>
</body>
</html>