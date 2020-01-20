package ShoppingCart;


import java.io.Serializable;

public class CartItem implements Serializable {
    private Book book;
    private int allCount;
//    private double price;
    public CartItem(Book book){
        this.book=book;
        allCount=1;
    }
    public CartItem(Book book,int count){
        this.allCount=count;
        this.book=book;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

}
