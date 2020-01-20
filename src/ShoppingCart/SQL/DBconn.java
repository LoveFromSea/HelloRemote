package ShoppingCart.SQL;

import java.sql.*;

public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/forcart?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "yourpassword";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    public static void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int addUpdDel(String sql){
        int i=0;
        try {
            ps=conn.prepareStatement(sql);
            i=ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL增改删异常");
            e.printStackTrace();
        }
        return i;
    }
    public static ResultSet selectSQL(String sql){
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
        }catch (SQLException e){
            System.out.println("SQL数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        }catch (SQLException e){
            System.out.println("SQL数据库关闭异常");
            e.printStackTrace();
        }
    }
}
