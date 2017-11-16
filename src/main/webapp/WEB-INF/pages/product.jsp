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
    <title>Product Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Product
</h1>

<c:url var="addAction" value="/product/product/add" ></c:url>

<form:form action="${addAction}" commandName="product">
    <table>
        <c:if test="${!empty product.type}">
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
                <form:label path="type">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="type" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="material">
                    <spring:message text="Material"/>
                </form:label>
            </td>
            <td>
                <form:input path="material" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="size">
                    <spring:message text="Size"/>
                </form:label>
            </td>
            <td>
                <form:input path="size" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="color">
                    <spring:message text="Color"/>
                </form:label>
            </td>
            <td>
                <form:input path="color" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateOfLastChange">
                    <spring:message text="Date of last change"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateOfLastChange" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.type}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>" />
                </c:if>
                <c:if test="${empty product.type}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Products List</h3>
<c:if test="${!empty listProducts}">
    <table class="tg">
        <tr>
            <th width="80">Product ID</th>
            <th width="120">Product Type</th>
            <th width="120">Product Material</th>
            <th width="120">Product Size</th>
            <th width="120">Product Color</th>
            <th width="120">Product Date of last change</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.type}</td>
                <td>${product.material}</td>
                <td>${product.size}</td>
                <td>${product.color}</td>
                <td>${product.dateOfLastChange}</td>
                <td><a href="<c:url value='/product/edit/${product.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/product/remove/${product.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>