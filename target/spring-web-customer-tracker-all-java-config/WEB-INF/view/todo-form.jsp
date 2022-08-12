<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 11/08/2022
  Time: 01:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>To-do List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-todo-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Custom Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Task</h3>

    <form:form action="saveTodo" modelAttribute="todo" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>Text:</label></td>
                <td><form:input path="text" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>


            </tbody>
        </table>


    </form:form>

    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/todo/list">Back to List</a>
    </p>
</div>

</body>
</html>
