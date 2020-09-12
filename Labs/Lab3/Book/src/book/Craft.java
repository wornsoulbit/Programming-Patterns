package book;

/**
 * Class of a Craft book.
 * 
 * @author Alex Vasil
 */
public class Craft extends Book{

    private final double craftPriceBook = 19.99;
    
    /**
     * Constructor for a Craft book.
     * 
     * @param bookTitle Name of the book.
     */
    public Craft(String bookTitle) {
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
        return craftPriceBook;
    }

    /**
     * ToString method of a Craft book.
     * 
     * @return A formatted string of a Craft book.
     */
    @Override
    public String toString() {
        return "Book name: " + super.getBookTitle() + "\n" + "Book Price: " + craftPriceBook;
    }
    
}
