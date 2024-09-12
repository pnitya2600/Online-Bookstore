import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private List<Book> cart;

    public Order(User user) {
        this.user = user;
        this.cart = new ArrayList<>(user.getCart());
    }

    public double getTotalCost() {
        double total = 0;
        for (Book book : cart) {
            total += book.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order for " + user.getUsername() + " - Total Cost: $" + getTotalCost();
    }
}
