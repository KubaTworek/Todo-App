<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 10/08/2022
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>To-do List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Custom Relationship Manager</h2>
        </div>
        <div>
<security:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}/login">Login</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout">
    </form:form>
</security:authorize>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <input type="button" value="Add Task" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>

            <table>
                <tr>
                    <th>Text</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempTodo" items="${todos}">



                        <c:url var="updateLink" value="/todo/showFormForUpdate">
                            <c:param name="todoId" value="${tempTodo.id}"/>
                        </c:url>

                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/todo/delete">
                            <c:param name="todoId" value="${tempTodo.id}" />
                        </c:url>



                    <tr>
                        <td>${tempTodo.text}</td>
                        <security:authorize access="hasRole('ADMIN')">
                        <td>
                            <a href="${updateLink}">Update</a>
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this task?'))) return false">Delete</a>
                        </td>
                        </security:authorize>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

</body>
</html>
