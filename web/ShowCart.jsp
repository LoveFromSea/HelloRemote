<%@ page import="ShoppingCart.ShoppingCart" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 黄文采
  Date: 2019/11/5
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ShoppingCart.Book" %>
<%@ page import="ShoppingCart.CartItem" %>
<html>
<head>
    <title>用户购物车信息</title>
</head>
<body>
<%
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    if (cart == null) {
        cart = new ShoppingCart();
        session.setAttribute("cart", cart);
    }
    ArrayList<CartItem> cartItems = new ArrayList<CartItem>(cart.getItems());
    double allMoney = 0;
%>
<p>Shopping Info</p>

<table>
    <tr>
        <td>
            书籍编号：
        </td>
        <td>
            书名：
        </td>
        <td>单价：</td>
        <td>数量：</td>
        <td>是否删除：</td>
    </tr>
    <%
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook();
    %>
    <tr>
        <td>
            <%=book.getId()%>
        </td>
        <td><%=book.getName()%>
        </td>
        <td><%=book.getPrice()%>
        </td>
        <td><%=cartItem.getAllCount()%>
        </td>
        <td><a href="/deleteItem?bid=<%=book.getId()%>">删除</a></td>
        <%
            allMoney += book.getPrice() * cartItem.getAllCount();
        %>
    </tr>
    <%
        }
    %>
</table>
<p>总价：<%=allMoney%>
</p>
<a href="BookCity.jsp">返回继续购物</a>
</body>
</html>
