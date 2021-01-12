<%-- 
    Document   : list
    Created on : Dec 17, 2020, 9:06:12 PM
    Author     : HP Z620
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">



        <title>JSP Page</title>
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: rgb(121,82,179)">

                <a  class="navbar-brand"> Student Registration CRUD </a>		

            </nav>
        </header>
        <br>





        <div class="container" >

            <h3 class="text-center">List of Students</h3>
            <hr>
            <div class="container text-left">

                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Student</a>

            </div>
            <br>


            <table class="table table-bordered table-striped table-hover" >
                <thead class="table-light">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Address</th>
                        <th>Phone number</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="user" items="${students}">

                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="********" /></td>
                            <td><c:out value="${user.address}" /></td>
                            <td><c:out value="${user.contact}" /></td>
                            <td><a href="edit?id=<c:out value='${user.id}' />"type="button" class="btn btn-warning">Edit</a> 
                                <a href="delete?id=<c:out value='${user.id}'  />"type="button" class="btn btn-danger">Delete</a></td>
                       </tr>

                    </c:forEach>

                </tbody>

            </table>

        </div>

    </body>
</html>
