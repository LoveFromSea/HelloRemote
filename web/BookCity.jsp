<%--
  Created by IntelliJ IDEA.
  User: 黄文采
  Date: 2019/10/25
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="ShoppingCart.SQL.DBconn" %>
<%
    String username;
    String p = request.getParameter("page");
    username = (String) request.getSession().getAttribute("uname");
    if (p == null) {
        p = "1";
    }
    int count = Integer.parseInt(p);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function tips() {
        alert("加入成功！");
    }
</script>
<h1>
    Hello,<%=username%>!!
</h1>
<%
    if (session.getAttribute("uname") == null) {
%>
<script type="text/javascript" language="javascript">
    alert("您还没有登录，请登录...");
    top.location.href = "login.jsp";
</script>
<%
    }
%>
<%
    DBconn.init();
    ResultSet rs = DBconn.selectSQL("SELECT bid,bname,bprice from books limit " + (count - 1) * 50 + "," + (50 * count));
%>

<table border="3" width="800">
        <%
            //遍历结果
            while (rs.next()) {
        %>
    <tr>
        <td><%=rs.getString("bid")%>
        </td>
        <%
            String title = rs.getString("bname");
            if (title.length() >= 20) {
                title = rs.getString("bname").substring(0, 20);
            }
        %>
        <td><a href="GoodDetails.jsp?bid=<%=rs.getString("bid")%>"><%=title%>
        </a>
        </td>
        <td><%=rs.getString("bprice")%>
        </td>
        <form action="/addToCart" method="post">
            <input type="hidden" name="bid" value="<%=rs.getString("bid")%>"/>
            <td><input onclick="tips()" type="submit" value="加入购物车"/></td>
        </form>

    </tr>
        <%
            }
        %>
    <span id="backPage"></span>
        <%
       if (count>=2){
    %>
    <script type="text/javascript" language="javascript">
        document.getElementById("backPage").innerHTML = "<a href=\"BookCity.jsp?page=<%=count-1%>\">上一页</a>";
    </script>
        <%
       }
    %>
        <%=p%>
    <a href="BookCity.jsp?page=<%=count+1%>">下一页</a>
    <a href="ShowCart.jsp">查看购物车</a>
</body>
</html>
