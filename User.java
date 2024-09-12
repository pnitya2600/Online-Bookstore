import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Book> cart;

    public User(String username) {
        this.username = username;
        this.cart = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Book> getCart() {
        return cart;
    }

    public void addToCart(Book book) {
        cart.add(book);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Book book : cart) {
            total += book.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Username: " + username;
    }
}
