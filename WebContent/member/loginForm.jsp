<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�α��� ������</title>
</head>
<body>
<form name="loginform" action="./MemberLoginAction.am" method="post">
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>�α��� ������</font></b>
		</td>
	</tr>
	<tr><td>���̵� : </td><td><input type="text" name="ACCID"/></td></tr>
	<tr><td>��й�ȣ : </td><td><input type="password" name="PASSWORD"/></td></tr>
	<tr>
		<td colspan="2" align=center>
			<input type="button" value="�α���" onclick="location.href='javascript:loginform.submit()'"/>&nbsp;&nbsp;
			<input type="button" value="ȸ������" onclick="location.href='MemberJoin.am'">
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>