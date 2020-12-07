
package finalproject2;

import java.util.Scanner;

/**
 *
 * @author Alex Vasil
 */
public class Main {
    static BookController book = BookController.getInstance();
    static StudentController student = StudentController.getInstance();
    
    public static void main(String[] args) {
        
        book.createBookTable();
        student.createStudentTable();
        student.createIssuedBooksTable();
        
        Book b1 = new Book("1234a", "Odyssey", "Homer", "N/A", 5, 0, "1488-01-01");
        Book b2 = new Book("1234b", "Catching Fire", "Suzanne Collins", "Scholastic Corporation", 5, 0, "2009-09-01");
        
        Student s1 = new Student(200, "Alex Vasil", "555-555-5555");
        Student s2 = new Student(202, "Veronica Vasil", "555-555-5555");
        Student s3 = new Student(201, "Nick", "123-456-7890");
        student.addStudent(s1);
        student.addStudent(s2);
        student.addStudent(s3);
        book.addBook(b1);
        book.addBook(b2);
        
        userControls();
    }
    
    /**
     * Gives options to the user from viewing the books, the issued books, the 
     * option to borrow a book, return a book and the librarian options.
     */
    public static void userControls() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("\nWelcome to the library!");
        System.out.println("1: View Books");
        System.out.println("2: View Issued Books");
        System.out.println("3: Borrow a Book");
        System.out.println("4: Return a Book");
        System.out.println("5: librarian Options?");
        System.out.println("0: Exit");
        
        int input = console.nextInt();
        
        switch (input) {
            case 1:
                System.out.println(BookController.viewCatalog());
                userControls();
                break;
            case 2:
                System.out.println(BookController.viewIssuedBooks());
                userControls();
                break;
            case 3:
                System.out.print("Enter your Student Id: ");
                input = console.nextInt();
                console.nextLine();
                System.out.print("Enter what book you want to borrow: ");
                String bookInput = console.nextLine();
                
                if (student.issueBook(book.getBook(bookInput), student.getStudent(input))) {
                    String strOut = String.format("You borrowed %s enjoy your book!\n", book.getBook(bookInput).getTitle());
                    System.out.println(strOut);
                } else {
                    System.out.println("Invalid Student Id or Book inputed.\n");
                }
                userControls();
                break;
            case 4:
                System.out.print("Enter your Student Id: ");
                input = console.nextInt();
                console.nextLine();
                System.out.println("Enter the name of the book you would like to return: ");
                bookInput = console.nextLine();
                if (student.returnBook(book.getBook(bookInput), student.getStudent(input))) {
                    String strOut = String.format("You returned %s thank you!\n", book.getBook(bookInput).getTitle());
                    System.out.println(strOut);
                } else {
                    System.out.println("You don't have that book borrowed.\n");
                }
                userControls();
                break;
            case 5:
                librarianControls();
                userControls();
                break;
            case 0:
                System.out.println("Thank you for visiting have a nice day!");
                break;
        }
    }
    
    /**
     * Controls that a librarian has, such as adding a new student, and a new book.
     */
    public static void librarianControls() {
        Scanner console = new Scanner(System.in);
        System.out.println("\nWelcome to the library!");
        System.out.println("1: Add Book");
        System.out.println("2: Add Student");
        System.out.println("9: Go back to Student Options?");
        System.out.println("0: Exit");
        int input = console.nextInt();
        
        switch (input) {
            case 1:
                System.out.print("Serial Number of the book: ");
                String serialNum = console.nextLine();
                System.out.print("Title of the book: ");
                String title = console.nextLine();
                System.out.print("Author of the book: ");
                String author = console.nextLine();
                System.out.print("Publisher of the book: ");
                String publisher = console.nextLine();
                System.out.print("Number of books: ");
                int quantity = console.nextInt();
                System.out.print("Number of books borrowed: ");
                int issuedQuant = console.nextInt();
                System.out.print("Date the book was bought: ");
                String dateOfPurchase = console.nextLine();
                book.addBook(new Book(serialNum, title, author, publisher, quantity, issuedQuant, dateOfPurchase));
                librarianControls();
                break;
            case 2:
                System.out.print("Student ID number: ");
                int studentId = console.nextInt();
                console.nextLine();
                System.out.print("Name of student: ");
                String studentName = console.nextLine();
                System.out.print("Contact number of the student: ");
                String contactNum = console.nextLine();
                student.addStudent(new Student(studentId, studentName, contactNum));
                librarianControls();
                break;
            case 9:
                return;
            case 0:
                System.out.println("Thank you for visiting have a nice day!");
                System.exit(0);
                break;
        }
    }
}
