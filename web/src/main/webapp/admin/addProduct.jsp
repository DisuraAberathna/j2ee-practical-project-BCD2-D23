<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/1/2025
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | Add Product</title>
</head>
<body>
<main>
    <h1>Add Product</h1>

    <form method="post" action="${pageContext.request.contextPath}/admin/add-product">
        <table>
            <tr>
                <th>Product Name</th>
                <td><input type="text" name="productName"/></td>
            </tr>
            <tr>
                <th>Product Description</th>
                <td><input type="text" name="productDescription"/></td>
            </tr>
            <tr>
                <th>Product Category</th>
                <td><input type="text" name="productCategory"/></td>
            </tr>
            <tr>
                <th>Product Price</th>
                <td><input type="number" name="productPrice"/></td>
            </tr>
            <tr>
                <th>Product Quantity</th>
                <td><input type="number" name="productQuantity"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form>
</main>
</body>
</html>
