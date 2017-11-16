<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 16.10.17
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Customer Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Customer
</h1>

<c:url var="addAction" value="/customer/customer/add" ></c:url>

<form:form action="${addAction}" commandName="customer">
    <table>
        <c:if test="${!empty customer.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <%--<form:hidden path="id" />--%>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surname">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surname" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">
                    <spring:message text="Phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phone" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty customer.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Customer"/>" />
                </c:if>
                <c:if test="${empty customer.name}">
                    <input type="submit"
                           value="<spring:message text="Add Customer"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Customers List</h3>
<c:if test="${!empty listCustomers}">
    <table class="tg">
        <tr>
            <th width="80">Customer ID</th>
            <th width="120">Customer Name</th>
            <th width="120">Customer Surname</th>
            <th width="120">Customer Phone</th>
            <th width="120">Customer email</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCustomers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.surname}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td><a href="<c:url value='/customer/edit/${customer.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/customer/remove/${customer.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>