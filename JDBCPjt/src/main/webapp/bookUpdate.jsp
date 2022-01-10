<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Update Page</title>
</head>
<body>
	<form action="bookModify" method="post">
		
		Book Name : <input type="text" name="book_name"><br>
		Book Location : <input type="text" name="book_location"><br>
		<input type="submit" value="Update Book">
		
	</form>
</body>
</html>