package ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShoppingCart.UserLogin",urlPatterns ="/u-login")
public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uName=req.getParameter("username");
        String uPwd=req.getParameter("pwd");
        req.getSession().setAttribute("uname",uName);
        req.getSession().setAttribute("upwd",uPwd);
        if (uName.equals("user1")&&uPwd.equals("123")){
            resp.sendRedirect("BookCity.jsp");
        }else {
            resp.sendRedirect("login.jsp");
        }
    }
}
