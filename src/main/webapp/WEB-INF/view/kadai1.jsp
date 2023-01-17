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
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode=request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			Kadai1 ka1 = (Kadai1)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>新規会員登録</h3>
		<form action="Kadai1c2" method="post">
			名前：<input type="text" name="name" value="<%=ka1.getName()%>"><br>
			年齢：<input type="text" name="age" value="<%=ka1.getAge() %>"><br>
			性別：<input type="radio" name="gne" value="男">男
				  <input type="radio" name="gne" value="女">女
				   <input type="radio" name="gne" value="その他">その他	<br>
			電話番号：<input type="text"name="pn" value="<%=ka1.getPn() %>"><br> 
			メール：<input type="email" name="mail" value="<%=ka1.getMail()%>"><br>
			パスワード：<input type="password" name="password"><br>
			<input type="submit" value="登録">
		</form>
		<%
		}else{
		%>
		<h3>新規会員登録</h3>
	<form action="Kadai1c2" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="text"name="age"><br>
		性別：<input type="radio" name="gne" value="男">男
				  <input type="radio" name="gne" value="女">女
				   <input type="radio" name="gne" value="その他">その他	<br>
		電話番号：<input type="text" name="pn"><br>
		メール：<input type="email" name="mail"><br>
		パスワード：<input type="password" name="password"><br>
		<input type="submit" value="登録">
	</form>
	<%
		}
		%>
</body>
</html>