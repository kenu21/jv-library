<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
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
        </tr>
        <c:forEach var="book" items="${allBooks}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>${book.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book/info?id=${book.id}">Info</a>
                </td>
                <td>${book.authors}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
