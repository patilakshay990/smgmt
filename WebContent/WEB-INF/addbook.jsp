<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Book Information here</title>
</head>
<body>

<a href="viewusers.jsp">View All Records</a><br/>  
  

	<div class="row">

		<form action="" method="post">
			<input type="text" name="book_name"
				placeholder="Enter Book Name here"> <br> <input
				type="text" name="author_name"
				placeholder="Enter Book Author Name here"> <br> <input
				type="text" name="book_price" placeholder="Enter Book Price here">
			<br> <input type="submit" class="btn btn-primary" name="submit"
				value="Submit"> &nbsp;&nbsp;&nbsp; <input type="reset"
				value="Reset"> <br>

		</form>


	</div>

</body>
</html>