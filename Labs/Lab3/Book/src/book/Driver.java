package book;

import java.util.stream.IntStream;

/**
 * Driver class for Lab2.
 *
 * @author Alex Vasil
 */
public class Driver {

    public static void main(String[] args) {

        Book[] arrayBooks = {new Cook("Cook Book 1"), new Cook("Cook Book 2"), new Cook("Cook Book 3"),
            new Cook("Cook Book 4"), new Craft("Craft Book 1"), new Craft("Craft Book 2"), new Craft("Craft Book 3")};

        Cook cookBook = new Cook("Awesome Cook Book");
        Craft craftBook = new Craft("Awesome Craft Book");

        System.out.println(cookBook);

        System.out.println(craftBook);

        MyLinkedList<Book> linkedListBooks = new MyLinkedList<>(arrayBooks);

        MyLinkedList<Book> linkedBooks = new MyLinkedList<>();

        //<editor-fold defaultstate="collapsed" desc="Adding Books to linkedBooks List">
        linkedBooks.add(0, new Cook("Cook Book 1"));
        linkedBooks.add(0, new Cook("Cook Book 2"));
        linkedBooks.add(0, new Cook("Cook Book 3"));
        linkedBooks.add(0, new Craft("Craft Book 1"));
        linkedBooks.add(0, new Craft("Craft Book 2"));
        linkedBooks.add(0, new Craft("Craft Book 3"));
//</editor-fold>

        System.out.println("\nNone Array Linked Books");
        displayList(linkedBooks);
        System.out.println("\nLinked Array Books");
        displayList(linkedListBooks);
        
        System.out.println("\nAdded a new book then removed a Craft book.");
        linkedListBooks.add(0, new Cook("Cook Book 4"));
        
        System.out.println("\nQuestion 5 & 6:");
        Craft craftBook2 = new Craft("Craft Book 4");
        linkedListBooks.add(2, craftBook2);
        linkedListBooks.remove(1);
        displayList(linkedListBooks);
    }

    public static void displayList(MyLinkedList e) {
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }
    }
}
