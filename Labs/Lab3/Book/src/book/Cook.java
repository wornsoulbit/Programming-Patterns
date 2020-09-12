package book;

/**
 * Class of a Cook book.
 * 
 * @author Alex Vasil
 */
public class Cook extends Book {

    private final double cookBookPrice = 12.99;
    
    /**
     * Constructor for a Cook book.
     * 
     * @param bookTitle Name of the book.
     */
    public Cook(String bookTitle) {
        super(bookTitle);
        setPrice();
    }

    /**
     * Sets the price of the book.
     * 
     * @return The price of the book.
     */
    @Override
    public double setPrice() {
        return cookBookPrice;
    }

    /**
     * ToString method of a Cook book.
     * 
     * @return A formatted string of a Cook book.
     */
    @Override
    public String toString() {
        return "Book name: " + super.getBookTitle() + "\n" + "Book Price: " + cookBookPrice;
    }
    
}
