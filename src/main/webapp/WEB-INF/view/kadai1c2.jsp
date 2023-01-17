<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.Kadai1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		Kadai1 ka=(Kadai1)session.getAttribute("input_data");
	%>
	名前：<%=ka.getName() %><br>
	年齢：<%=ka.getAge() %><br>
	性別：<%=ka.getGne() %><br>
	電話番号：<%=ka.getPn() %><br>
	メールアドレス：<%=ka.getMail() %><br>
	パスワード：**********<br>
	<a href="Kadai1c3">OK</a><br>
	<a href="Kadai1">戻る</a>
</body>
</html>