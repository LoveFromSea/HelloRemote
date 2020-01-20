package servlet;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<String,String> ite=new HashMap<String, String>();
        ite.put("nihao","123");
        ite.put("nibuhao","312");
        if (ite.containsKey("nihao"))
            System.out.println(123);
    }
}

