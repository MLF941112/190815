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
<h3>这里是book_add.jsp页面</h3>
<form action="bc/addbook" method="post" enctype="multipart/form-data"> 
	书名：<input type="text" name="bookName" value="山海经" /><br/>
	出版社：<input type="text" name="publicDept" value="清华大学出版社" /><br/>
	作者：<input type="text" name="bookAuth" value="佚名" /><br/>
	价格：<input type="text" name="bookPrice" value="30.00" /><br/>
	出版日期：<input type="text" name="publicDate" value="2019-11-11" /><br/>
	图片：<input type="file" name="pic" /><br/>
	简介：<textarea rows="10" cols="30" name="summary">hello world</textarea><br/>
	<input type="submit" value="增   加" />
</form>
</body>
</html>