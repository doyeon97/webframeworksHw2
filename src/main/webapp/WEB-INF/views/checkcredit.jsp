<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check credit</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세보기</td>
		</tr>
		<c:forEach var="creditsPerSemester" items="${creditsPerSemesters}">
			<tr>
				<td>${creditsPerSemester.year}</td>
				<td>${creditsPerSemester.semester}</td>
				<td>${creditsPerSemester.totalCredit}</td>
				<td><a
					href="${pageContext.request.contextPath}/checkcreditsPerSemester?year=${creditsPerSemester.year}&semester=${creditsPerSemester.semester}">링크</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>