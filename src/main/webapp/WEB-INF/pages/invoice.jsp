<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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
                    <%--<form:hidden path="id"/>--%>
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
                <td if="${fields.hasErrors('customer')}" errors="*{customer}">Customer Error</td>
        </tr>
            <%--Вместо List<Products>--%>
            <%--<form:label path="products">--%>
            <%--<spring:message text="List Products"/>--%>
            <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
            <%--<form:input path="products" list/>--%>
            <%--</td>--%>
            <%--</tr>--%>
        <tr>
            <td>
                <form:label path="checkDate">
                    <spring:message text="Invoice date"/>
                </form:label>
            </td>
            <td>
                <form:input path="checkDate"/>
            </td>
                <%--<td th:if="${#fields.hasErrors('checkDate')}" th:errors="*{checkDate}">Date Error</td>--%>
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
                <%--<td if="${fields.hasErrors('amount')}" th:errors="*{amount}">Amount Error</td>--%>
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
        <tr>
            <td>
                <h4></h4>
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
            <th width="120">Product ID</th>
            <th width="120">Product Type</th>
            <th width="120">Product Material</th>
            <th width="120">Product Size</th>
            <th width="120">Product Color</th>
            <th width="120">Product Date of last change</th>
            <th width="120">Invoice Amount</th>
            <th width="80">Invoice Date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listInvoices}" var="invoice">
            <tr>
                <td>${invoice.id}</td>
                <td>${invoice.customer.name}</td>
                <td>${invoice.customer.surname}</td>
                <td>${invoice.customer.phone}</td>
                <td>${invoice.customer.email}</td>
                    <%--<c:forEach items="${invoice.products}" var="product">--%>
                    <%--<td>${product.id}</td>--%>
                    <%--<td>${product.type}</td>--%>
                    <%--<td>${product.material}</td>--%>
                    <%--<td>${product.size}</td>--%>
                    <%--<td>${product.color}</td>--%>
                    <%--<td>${product.dateOfLastChange}</td>--%>
                    <%--</c:forEach>--%>
                <td>${invoice.amount}</td>
                <td>${invoice.checkDate}</td>
                <td><a href="<c:url value='/invoices/edit/${invoice.id}' />">Edit</a></td>
                <td><a href="<c:url value='/invoices/remove/${invoice.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>