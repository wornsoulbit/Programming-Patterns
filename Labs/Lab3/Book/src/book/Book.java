package book;

/**
 * Class of a book.
 *
 * @author Alex Vasil
 */
public abstract class Book {

    protected String bookTitle;
    protected double bookPrice;

    /**
     * Class of a book with the title of a book.
     *
     * @param bookTitle Name of the book.
     */
    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Sets the price of a book.
     *
     * @return the price of the book.
     */
    public abstract double setPrice();

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Gets the price of the book.
     *
     * @return The price of the book.
     */
    public double getBookPrice() {
        return bookPrice;
    }

    /**
     * ToString method of a Book.
     *
     * @return A formatted string of a Book.
     */
    @Override
    public String toString() {
        return "Book name: " + bookTitle + "\n" + "Book Price: " + bookPrice;
    }
}
