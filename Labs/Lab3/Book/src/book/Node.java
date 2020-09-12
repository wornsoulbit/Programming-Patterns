package book;

/**
 * Nodes for each individual element.
 *
 * @author Alex Vasil
 * @param <E> The Node subtype.
 */
public class Node<E> {

    E element;
    Node<E> next;

    public Node(E o) {
        element = o;
    }
}
