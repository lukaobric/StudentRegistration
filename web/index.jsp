<%-- 
    Document   : index
    Created on : Dec 17, 2020, 9:46:16 AM
    Author     : HP Z620
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
       
        <body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: rgb(121,82,179)">
			<div>
				<a  class="navbar-brand"> Student Registration CRUD </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Student Name</label> <input type="text"
						value="<c:out value='${student.name}' />" class="form-control"
                                                name="sname" required="required" placeholder="Student Name">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> 
                                        <input type="password" value=" <c:out value='${student.password}' />" class="form-control"
                                               name="password" placeholder="Password">	
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${student.address}' />" class="form-control"
                                                name="address" placeholder="Address">
				</fieldset>

                                    <fieldset class="form-group">
					<label>Phone Number</label> <input type="text"
						value="<c:out value='${student.contact}' />" class="form-control"
                                                name="pnumber" placeholder="Phone Number">
                                    </fieldset></br>            
                                                
				<button type="submit" class="btn btn-success">Submit</button>
				<button type="reset" class="btn btn-warning">Reset</button>
                                </form>
			</div>
		</div>
	</div>
    </body>
</html>
