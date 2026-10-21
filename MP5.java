import java.util.Scanner;

class LibraryException extends Exception {

    public LibraryException(String message) {

        super(message);

    }

}

class Book {

    private int id;

    private String title;

    private int totalCopies;

    private int availableCopies;

    private int borrowedCopies;

    public Book(int id, String title, int totalCopies) {
this.id = id;

        this.title = title;

        this.totalCopies = totalCopies;

        this.availableCopies = totalCopies;

        this.borrowedCopies = 0;

    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public int getAvailableCopies() { return availableCopies; }

    public int getBorrowedCopies() { return borrowedCopies; }

    public void borrowCopy() throws LibraryException {

        if (availableCopies <= 0) {

            throw new LibraryException("Error: No copies available.");

        }

        availableCopies--;

        borrowedCopies++;

    }

    public void returnCopy() throws LibraryException {

        if (borrowedCopies <= 0) {

            throw new LibraryException("Error: No borrowed copies to return.");

        }

        borrowedCopies--;

        availableCopies++;

    }

}

public class MP5 {



    private static Book findBook(Book[] books, int id) throws LibraryException {

        for (Book b : books) {

            if (b.getId() == id) {

                return b;

            }

        }

        throw new LibraryException("Error: Book not found.");

    }

    public static void main(String[] args) {

        

        Book[] books = {

            new Book(1, "Java Basics", 2),

            new Book(2, "Algorithms", 1),

            new Book(3, "Databases", 0)

        };

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\nMenu: 1 Borrow | 2 Return | 3 Find | 4 List | 0 Exit");

            System.out.print("Enter choice: ");

            String input = scanner.nextLine().trim();

            try {

              

                double parsedVal = Double.parseDouble(input);

                if (Double.isNaN(parsedVal) || Double.isInfinite(parsedVal)) {

                    throw new NumberFormatException();

                }

                int choice = (int) parsedVal;

                switch (choice) {

                    case 1: { 

                        System.out.print("Enter Book ID: ");

                        int id = Integer.parseInt(scanner.nextLine().trim());

                        Book book = findBook(books, id);

                        book.borrowCopy();

                        System.out.println("Available " + book.getAvailableCopies() + ", borrowed " + book.getBorrowedCopies());

                        break;

                    }

                    case 2: { 

                        System.out.print("Enter Book ID: ");

                        int id = Integer.parseInt(scanner.nextLine().trim());

                        Book book = findBook(books, id);

                        book.returnCopy();

                        System.out.println("Available " + book.getAvailableCopies() + ", borrowed " + book.getBorrowedCopies());

                        break;

                    }

                    case 3: { 

                        System.out.print("Enter Book ID: ");

                        int id = Integer.parseInt(scanner.nextLine().trim());

                        Book book = findBook(books, id);

                        System.out.println("Available " + book.getAvailableCopies() + ", borrowed " + book.getBorrowedCopies());

                        break;

                    }

                    case 4: { 

                        for (Book b : books) {

                            System.out.println("ID " + b.getId() + " " + b.getTitle() + " - Available " + b.getAvailableCopies() + ", borrowed " + b.getBorrowedCopies());

                        }

                        break;

                    }

                    case 0: { 

                        running = false;

                        break;

                    }

                    default:

                        System.out.println("Error: Invalid menu option.");

                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Error: Enter a valid number.");

            } catch (LibraryException e) {

                System.out.println(e.getMessage());

            } finally {

                

            }

        }

        scanner.close();

    }

}
 
