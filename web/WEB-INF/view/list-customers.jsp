<%--
  Created by IntelliJ IDEA.
  User: 49228
  Date: 9/12/2020
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customers</title>
    <!--reference style sheet-->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
    <div id ="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>

            <div id = "container">
                <div id = "content">
                    <!--put button: Add Customer-->
                    <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
                    class="add-button"
                    />

                    <!--add html table here-->
                    <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email Name</th>
                        <th>Action</th>
                    </tr>
                    <!--loop over and print customers -->
                    <c:forEach var="tempCustomer" items="${customers}">
                        <!--construct an update link with customer id-->
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                            <td>
                                <!--display Link-->
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                onclick="if(!(confirm('ARE YOU SURE WANT TO DELETE THIS CUSTOMER?!'))) return false"
                                >Delete</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </table>

                </div>

            </div>

    </div>
</body>
</html>
