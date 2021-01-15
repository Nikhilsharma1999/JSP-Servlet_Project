<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Product Inventory</title>
        </head>
        <body>
            <header>
                        <h2> Product Inventory </h2>
            </header>
            <br>
            <table >
                        <thead>
                            <tr>
                                <th style="border:1px solid black;">ID</th>
                                <th style="border:1px solid black;">Name</th>
                                <th style="border:1px solid black;">Rating</th>
                            </tr>
                        </thead>
                        <tbody>
                   
                            <c:forEach var="product" items="${listProduct}">

                                <tr>
                                    <td style="border:1px solid black;">
                                        <c:out value="${product.id}" />
                                    </td>
                                    <td style="border:1px solid black;">
                                        <c:out value="${product.name}" />
                                    </td>
                                    <td style="border:1px solid black;">
                                        <c:out value="${product.rating}" />
                                    </td>
                                   
                          <td><a href="edit?id=<c:out value='${product.id}' />"><button >Edit</button></a> &nbsp;<a href="delete?id=<c:out value='${product.id}' />"><button >Delete</button></a></td>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    <br>

            <a href="<%=request.getContextPath()%>/new" ><button >Add Product</button></a>
            <a href="<%=request.getContextPath()%>/download" ><button >Download List</button></a>
            
            <br>
        </body>
</html>