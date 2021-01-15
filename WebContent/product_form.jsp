<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Product Inventory</title>
         
        </head>

        <body>

            <header><h2> Product Inventory  </h2>
            </header>
            <div>
                <div >
                    
                        <c:if test="${product != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${product == null}">
                            <form action="insert" method="post">
                        </c:if>
                            <h2>
                                <c:if test="${product != null}">
                                    Edit Product
                                </c:if>
                                <c:if test="${product == null}">
                                    Add New Product
                                </c:if>
                            </h2>
                        
                        <c:if test="${product != null}">
                            <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                        </c:if>

                        <fieldset >
                            <label>Product Name</label> <input type="text" value="<c:out value='${product.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset >
                            <label>Product Rating</label> <input type="number" value="<c:out value='${product.rating}' />" class="form-control" name="rating" required="required">
                        </fieldset>

                        <button type="submit" >Save</button>
                        </form>
                    
                </div>
            </div>
        </body>

        </html>