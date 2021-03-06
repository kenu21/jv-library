<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
<jsp:include page="/index.jsp"/>
<div align="center">
    <h2> Select what you want to buy</h2>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Year</th>
            <th>Price</th>
            <th>Info</th>
            <th>Authors</th>
            <th>Rent</th>
        </tr>
        <c:forEach var="book" items="${allBooks}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>${book.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book/${book.id}">Info</a>
                </td>
                <td>${book.authors}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/rent/getbook?book_id=${book.id}">Rent</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
