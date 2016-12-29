<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>로그인 페이지</title>
</head>
<body>
<form name="loginform" action="./MemberLoginAction.am" method="post">
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>로그인 페이지</font></b>
		</td>
	</tr>
	<tr><td>아이디 : </td><td><input type="text" name="ACCID"/></td></tr>
	<tr><td>비밀번호 : </td><td><input type="password" name="PASSWORD"/></td></tr>
	<tr>
		<td colspan="2" align=center>
			<input type="button" value="로그인" onclick="location.href='javascript:loginform.submit()'"/>&nbsp;&nbsp;
			<input type="button" value="회원가입" onclick="location.href='MemberJoin.am'">
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>