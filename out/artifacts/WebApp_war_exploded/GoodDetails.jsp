<%--
  Created by IntelliJ IDEA.
  User: 黄文采
  Date: 2019/10/27
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="ShoppingCart.SQL.DBconn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String bid = request.getParameter("bid");
%>
<%
    DBconn.init();
    ResultSet rs = DBconn.selectSQL("SELECT bprice,bname,bshop,bimg from books where bid='" + bid + "'");
%>
<h1>物品信息</h1>
<table border="1" width="800">
    <tr>
        <td>
            书籍编号
        </td>
        <td>
            书名
        </td>
        <td>单价</td>
        <td>图片</td>
        <td>附属书店</td>
        <td>加入购物车</td>
    </tr>
    <%
        //遍历结果
        while (rs.next()) {
    %>
    <tr>
        <td><%=bid%>
        </td>
        <td><%=rs.getString("bname")%>
        </td>
        <td><%=rs.getString("bprice")%>
        </td>
        <td><img src="<%=rs.getString("bimg")%>" alt="<%=rs.getString("bname")%>"></td>
        <td><%=rs.getString("bshop")%>
        </td>
        <form action="/addToCart" method="post">
            <input type="hidden" name="bid" value="<%=bid%>"/>
            <td><input type="submit" value="加入购物车"/></td>
        </form>
    </tr>
    <%
            return;
        }
    %>
</table>
</body>
</html>
