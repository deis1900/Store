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
    Add a Invoice
</h1>

<c:url var="addAction" value="/invoice/invoice/add"></c:url>

<form:form action="${addAction}" commandName="invoice">
    <table>
        <c:if test="${!empty invoice.id}">
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
                <form:label path="products">
                    <spring:message text="Product"/>
                </form:label>
            </td>
            <td>
                <form:input path="products"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="checkDate">
                    <spring:message text="Invoice date"/>
                </form:label>
            </td>
            <td>
                <form:input path="checkDate"/>
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
                <c:if test="${!empty invoice.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Invoice"/>"/>
                </c:if>
                <c:if test="${empty invoice.id}">
                    <input type="submit"
                           value="<spring:message text="Add Invoice"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Invoices List</h3>
<c:if test="${!empty listInvoices}">
    <table class="tg">
        <tr>
            <th width="80">Invoice ID</th>
            <th width="120">Customer Name</th>
            <th width="120">Customer Surname</th>
            <th width="120">Customer Phone</th>
            <th width="120">Customer email</th>
            <th width="80">Product ID</th>
            <th width="120">Product Type</th>
            <th width="120">Product Material</th>
            <th width="120">Product Size</th>
            <th width="120">Product Color</th>
            <th width="120">Product Date of last change</th>
            <th width="80">Invoice Date</th>
            <th width="120">Invoice Amount</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listInvoices}" var="invoices">
            <tr>
                <td>${invoices.id}</td>
                <td>${invoices.customer.name}</td>
                <td>${invoices.customer.surname}</td>
                <td>${invoices.customer.email}</td>
                <td>${invoices.customer.phone}</td>
                <c:forEach items="${invoice.products}" var="product">
                    <li>${product.toString()}</li>
                    <li>${product.type}</li>
                    <li>${product.size}</li>
                    <li>${product.material}</li>
                    <li>${product.color}</li>
                    <li>${product.dateOfLastChange}</li>
                </c:forEach>
                <td>${invoices.checkDate}</td>
                <td>${invoices.amount}</td>
                <td><a href="<c:url value='/invoices/edit/${invoices.id}' />">Edit</a></td>
                <td><a href="<c:url value='/invoices/remove/${invoices.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>