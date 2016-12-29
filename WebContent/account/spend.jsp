<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "net.account.db.*" %>
<%
	AccountBean accbn = (AccountBean)request.getAttribute("page");
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
			<td align = "center"> <label for="sDate">시작날짜</label> <input id="sDate" type="date" value="yyyy-mm-dd">
			 </td>
			 <td align = "center"> <label for="eDate">종료날짜</label> <input id="eDate" type="date" value="yyyy-mm-dd">
			 <input id="apply" type="submit" value="적용"/>
			 </td>			
		</tr>
		<tr>
			<td colspan = "2" align = "left">  
				<jsp:include page="chart_exp.jsp"/>
			</td>
		</tr>
		<tr>
			<td colspan = "2">
				<table border = "0" width = "100%">
					<tr>
						
					</tr>
					<tr>
						<td>
							항목 <%-- <%=accbn.getMEMO() %> --%>
						</td>
					</tr>
					<tr>
						<td>
							입력
						</td>
					</tr>
				</table>
			</td>
		</tr>		
	</table>

</body>
</html>