package ShoppingCart;


import ShoppingCart.SQL.DBconn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ControlCart", urlPatterns = {
        "/addToCart", "/viewBookDetails", "/deleteItem"
})
public class CartDo extends HttpServlet {
    ServletContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.endsWith("/viewBookDetails")) {
            showProductDetail(req, resp);
        } else if (uri.endsWith("/deleteItem")) {
            deleteItem(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = "0";
        int allCount = 1;
        try {
            bookId = req.getParameter("bid");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        Book book = getBook(bookId);
        if (book != null) {//&& allCount >= 0
            CartItem cartItem = new CartItem(book, allCount);
            HttpSession session = req.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            cart.add(cartItem);
            String page = req.getParameter("page");
            if (page == null) {
                page = "1";
            } else {
            }
            resp.sendRedirect("/BookCity.jsp?page=" + page);
        }
    }

    private void showProductDetail(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String bookId = "0";
        try {
            bookId = req.getParameter("bid");
        } catch (Exception e) {
            System.out.println(e);
        }
        Book book = getBook(bookId);
        if (book != null) {
            HttpSession session = req.getSession();
            session.setAttribute("book", book);
            resp.sendRedirect("showProduct.jsp");

        }
    }

    private Book getBook(String bookId) {
        DBconn.init();
        try {
            ResultSet rs = DBconn.selectSQL("SELECT bid,bprice,bname,bshop,bimg from books where bid='" + bookId + "'");
            while (rs.next()) {
                double price = Double.parseDouble(rs.getString("bprice"));
                Book book = new Book(rs.getString("bid"), rs.getString("bname"), price, rs.getString("bshop"), rs.getString("bimg"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void deleteItem(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        try {
            String id = req.getParameter("bid");
            CartItem item = null;
            for (CartItem bookItem : cart.getItems()) {
                if (bookItem.getBook().getId().equals(id)) {
                    item = bookItem;
                    break;
                }
            }
            cart.remove(item.getBook().getId());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        session.setAttribute("cart", cart);
        resp.sendRedirect("/ShowCart.jsp");
    }
}
