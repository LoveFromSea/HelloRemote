package ShoppingCart;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartItem> items = null;

    public ShoppingCart() {
        items = new HashMap<String, CartItem>();
    }

    public void add(CartItem cartItem) {
        String bookId = cartItem.getBook().getId();
        if (items.containsKey(bookId)) {
            CartItem scitem = (CartItem) items.get(bookId);
            scitem.setAllCount(scitem.getAllCount() + cartItem.getAllCount());
        } else {
            items.put(bookId, cartItem);
        }
    }

    public void remove(String bid) {
        if (items.containsKey(bid)) {
            CartItem scitem = (CartItem) items.get(bid);
            scitem.setAllCount(0);
            if (scitem.getAllCount() <= 0)
                items.remove(bid);
        }
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public double getPrice() {
        double totalPrice = 0;
        for (Iterator<CartItem> i = getItems().iterator(); i.hasNext(); ) {
            CartItem item = (CartItem) i.next();
            Book book = (Book) item.getBook();
            totalPrice += item.getAllCount() * book.getPrice();
        }
        return totalPrice;
    }

    public void clear() {
        items.clear();
    }
}
