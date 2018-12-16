<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${year}년 ${semester}학기 신청 내역</h1>

	<table border="1">
		<tr>
			<td>교과코드</td>
			<td>교과목명</td>
			<td>구분</td>
			<td>학점</td>
		</tr>
		<c:forEach var="subject" items="${subjects}">
			<c:if test="${subject.year == year && subject.semester == semester}">
				<tr>
					<td>${subject.code}</td>
					<td>${subject.title}</td>
					<td>${subject.division}</td>
					<td>${subject.credit}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>