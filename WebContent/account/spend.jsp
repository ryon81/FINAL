<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "net.account.db.*" %>
<%
	AccountBean accbn = (AccountBean)request.getAttribute("actdata");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/mystyle.css">

</head>
<body>
	<table border = "1" width = "100%" height = "100%">
		<tr>
			<td align = "center"> ��¥ �Է� </td>			
		</tr>
		<tr>
			<td align = "left"> �� </td>
		</tr>
		<tr>
			<td>
				<table border = "0" width = "100%">
					<tr>
						<td>
							�׷���
						</td>
					</tr>
					<tr>
						<td>
							�׸� <%=accbn.getEXP_DATE() %>
						</td>
					</tr>
					<tr>
						<td>
							�Է�
						</td>
					</tr>
				</table>
			</td>
		</tr>		
	</table>

</body>
</html>