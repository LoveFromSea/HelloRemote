package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Initialize HelloServlet");
    }

    int a=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("doGet");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>HelloServlet</h1><br>");
        out.println("<p>Hello,"+a+"</p>");
        a=a+1;
        out.flush();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy it!");
    }
}
