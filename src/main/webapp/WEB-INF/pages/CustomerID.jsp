<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Client Page</title>
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
    Order client with Id = ${id}
</h1>
<c:if test="${!empty invoices}">
<table class="tg">
    <tr>
        <th width="80">Customer ID</th>
        <th width="120">Customer Name</th>
        <th width="120">Customer Surname</th>
        <th width="120">Customer Phone</th>
        <th width="120">Customer Email</th>
        <th width="80">Invoice ID</th>
        <th width="120">Invoice Amount</th>
        <th width="120">Invoice Check Date</th>
        <th width="80">Product ID</th>
        <th width="120">Product Type</th>
        <th width="120">Product Material</th>
        <th width="120">Product Size</th>
        <th width="120">Product Color</th>
        <th width="120">Product Date of Last Change</th>
    </tr>
    <c:forEach items="${invoices}" var="invoice">
        <tr>
            <td>${invoice.customer.id}</td>
            <td>${invoice.customer.name}</td>
            <td>${invoice.customer.surname}</td>
            <td>${invoice.customer.phone}</td>
            <td>${invoice.customer.email}</td>
            <td>${invoice.id}</td>
            <td>${invoice.amount}</td>
            <td>${invoice.checkDate}</td>

            <%--<c:forEach items="${invoice.products}" var="product">--%>
                <%--<td>${product.id}</td>--%>
                <%--<td>${product.type}</td>--%>
                <%--<td>${product.material}</td>--%>
                <%--<td>${product.size}</td>--%>
                <%--<td>${product.color}</td>--%>
                <%--<td>${product.dateOfLastChange}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
    </c:forEach>
    </c:if>
</table>
</body>
</html>
