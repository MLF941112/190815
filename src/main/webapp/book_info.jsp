<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function prebuybook(bookid) {
	location="uc/findaccount?bookid="+bookid;
}
</script>
</head>
<body>

<h3>这里是book_info.jsp页面</h3>
书名：${book.bookName }<br/>
出版社：${book.publicDept }<br/>
价格：${book.bookPrice }<br/>
出版日期：<fmt:formatDate value="${book.publicDate }" pattern="yyyy-MM-dd"/> <br/>
作者：${book.bookAuth }<br/>
图片：<img src="${book.imgPath }" width="200" /><br/>
简介：${book.summary }<br/>
<input type="button" value="直接购买" onclick="prebuybook('${book.bookid}')" />
</body>
</html> 