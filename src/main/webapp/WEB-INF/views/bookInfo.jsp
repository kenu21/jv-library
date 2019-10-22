<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Book info</title>
</head>
<body>
<h2>Book info</h2>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Authors</th>
    </tr>
    <tr>
        <td>${infoBook.id}</td>
        <td>${infoBook.title}</td>
        <td>${infoBook.year}</td>
        <td>${infoBook.price}</td>
        <td>${infoBook.authors}</td>
        <td>
            <a href="${pageContext.request.contextPath}/rent/getbook?book_id=${book.id}">Rent</a>
        </td>
    </tr>
</table>
</body>
</html>
