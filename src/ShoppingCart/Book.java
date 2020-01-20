package ShoppingCart;

import java.io.Serializable;

public class Book implements Serializable {
    private String id;
    private String name;
    private double price;
    private String shop;
    private String img;

    public Book(String id, String name, double price, String shop, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
        this.img = img;
    }
    public Book(){}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
