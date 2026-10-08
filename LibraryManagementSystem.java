import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void issueBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public void displayBook() {
        System.out.println(
                "ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Status: " + (available ? "Available" : "Issued")
        );
    }
}

class Library {

    private ArrayList<Book> books = new ArrayList<>();

    // Add book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- Library Books ---");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search book
    public void searchBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                System.out.println("Book found:");
                book.displayBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Issue book
    public void issueBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {

                if (book.isAvailable()) {
                    book.issueBook();
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return book
    public void returnBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {

                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Remove book
    public void removeBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    library.searchBook(id);

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    library.issueBook(id);

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    library.returnBook(id);

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    library.removeBook(id);

                    break;

                case 7:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}
