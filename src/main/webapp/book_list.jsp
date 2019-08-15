<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>这里是book_list.jsp页面</h3>
<table border="1" width="800" cellspacing="0" >
	<tr>
		<td>编号</td>
		<td>名字</td>
		<td>作者</td>
		<td>简介</td>
	</tr>
	
	<c:forEach items="${booklist }" var="bl" >
	<tr>
		<td>${bl.bookid }</td>
		<td><a href="bc/findbyid?bookid=${bl.bookid }" >${bl.bookName }</a></td>
		<td>${bl.bookAuth }</td>
		<td>
			${fn:substring(bl.summary,0,20) }${fn:length(bl.summary)>20?"...":"" }
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>