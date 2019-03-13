<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
 <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/lzy_property_manager" user="root"  password="root"/>
        <sql:query dataSource="${snapshot}" var="result">
        SELECT d_name from a_department;
        </sql:query>
        <select name="account" size="1">
            <c:forEach var="row" items="${result.rows}">
            <option value="<c:out value="${row.d_name}"/>"><c:out value="${row.d_name}"/></option>
            </c:forEach>
        </select>
    </body>
</html>