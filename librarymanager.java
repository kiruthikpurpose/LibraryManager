import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String name;
    String author;
    int copies;
    double price;

    Book(String name, String author, int copies, double price) {
        this.name = name;
        this.author = author;
        this.copies = copies;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Author: " + author + ", Copies: " + copies + ", Price: " + price;
    }
}

class LibraryManagementSystem {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> lentBooks = new ArrayList<>(); // list of lent books and lender names

    public void librarianMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.print("Enter book name: ");
            String name = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter number of copies: ");
            int copies = scanner.nextInt();
            System.out.print("Enter book price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume the newline
            books.add(new Book(name, author, copies, price));
        }
    }

    public void lenderMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the lender: ");
        String lenderName = scanner.nextLine();
        System.out.print("Enter the name of the book to lend: ");
        String bookName = scanner.nextLine();

        boolean bookFound = false;
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(bookName) && book.copies > 0) {
                book.copies--;
                lentBooks.add(bookName + " lent to " + lenderName);
                bookFound = true;
                System.out.println("Book lent successfully.");
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book not available or out of stock.");
        }
    }

    public void viewBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void viewLentBooks() {
        System.out.println("Lent books:");
        for (String record : lentBooks) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Librarian Mode");
            System.out.println("2. Lender Mode");
            System.out.println("3. View Books");
            System.out.println("4. View Lent Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    system.librarianMode();
                    break;
                case 2:
                    system.lenderMode();
                    break;
                case 3:
                    system.viewBooks();
                    break;
                case 4:
                    system.viewLentBooks();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
