<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Product Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    Add a Product
</h1>

<c:url var="addAction" value="/order/order/add"></c:url>

<form:form action="${addAction}" commandName="order">
    <table>
        <c:if test="${!empty order.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <%--<form:hidden path="id" />--%>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="customer">
                    <spring:message text="Customer ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="customer"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="product">
                    <spring:message text="Product"/>
                </form:label>
            </td>
            <td>
                <form:input path="product"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="orderDate">
                    <spring:message text="Order date"/>
                </form:label>
            </td>
            <td>
                <form:input path="orderDate"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="amount">
                    <spring:message text="Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty order.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Order"/>"/>
                </c:if>
                <c:if test="${empty order.id}">
                    <input type="submit"
                           value="<spring:message text="Add Order"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Orders List</h3>
<c:if test="${!empty listOrders}">
    <table class="tg">
        <tr>
            <th width="80">Order ID</th>
            <th width="80">Customer ID</th>
            <th width="120">Customer Name</th>
            <th width="120">Customer Surname</th>
            <th width="120">Customer Phone</th>
            <th width="120">Customer email</th>
            <th width="120">Product Type</th>
            <th width="120">Product Material</th>
            <th width="120">Product Size</th>
            <th width="120">Product Color</th>
            <th width="120">Product Date of last change</th>
            <th width="80">Order Date</th>
            <th width="120">Order Amount</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOrders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.customer.id}</td>
                <td>${order.customer.name}</td>
                <td>${order.customer.surname}</td>
                <td>${order.customer.email}</td>
                <td>${order.customer.phone}</td>
                <td>${order.product}</td>
                <c:forEach items="${listProduct}" var="product">
                    <li>${product.id}</li>
                    <li>${product.type}</li>
                    <li>${product.size}</li>
                    <li>${product.material}</li>
                    <li>${product.color}</li>
                    <li>${product.dateOfLastChange}</li>
                </c:forEach>
                <td>${order.orderDate}</td>
                <td>${order.amount}</td>
                <td><a href="<c:url value='/order/edit/${order.id}' />">Edit</a></td>
                <td><a href="<c:url value='/order/remove/${order.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>