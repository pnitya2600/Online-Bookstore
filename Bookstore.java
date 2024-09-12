import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bookstore {
    private List<Book> books;
    private List<User> users;

    public Bookstore() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Book Management Methods
    private void addBook(String title, String author, double price) {
        books.add(new Book(title, author, price));
    }

    private void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // User Management Methods
    private void registerUser(String username) {
        users.add(new User(username));
    }

    private void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    // Order Management Methods
    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private void addBookToCart(String username, Book book) {
        User user = findUser(username);
        if (user != null) {
            user.addToCart(book);
        } else {
            System.out.println("User not found.");
        }
    }

    private void placeOrder(String username) {
        User user = findUser(username);
        if (user != null) {
            Order order = new Order(user);
            System.out.println(order);
        } else {
            System.out.println("User not found.");
        }
    }

    // User Interface Methods
    private void handleAddBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        addBook(title, author, price);
    }

    private void handleAddBookToCart(Scanner scanner) {
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        displayBooks();
        System.out.print("Enter book title to add to cart: ");
        String bookTitle = scanner.nextLine();
        Book bookToAdd = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                bookToAdd = book;
                break;
            }
        }
        if (bookToAdd != null) {
            addBookToCart(userName, bookToAdd);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void handleUserRegistration(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        registerUser(username);
    }

    private void handlePlaceOrder(Scanner scanner) {
        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        placeOrder(user);
    }

    // Main Method
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        bookstore.addBook("The Cloud Computing Book: The Future of Computing Explained", " Douglas Comer ", 4492);
        bookstore.addBook("Mastering the Data Paradox", "Nitin Seth", 430);

        System.out.println("Welcome to the Bookstore");

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Register User");
            System.out.println("4. Display Users");
            System.out.println("5. Add Book to Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookstore.handleAddBook(scanner);
                    break;

                case 2:
                    bookstore.displayBooks();
                    break;

                case 3:
                    bookstore.handleUserRegistration(scanner);
                    break;

                case 4:
                    bookstore.displayUsers();
                    break;

                case 5:
                    bookstore.handleAddBookToCart(scanner);
                    break;

                case 6:
                    bookstore.handlePlaceOrder(scanner);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
