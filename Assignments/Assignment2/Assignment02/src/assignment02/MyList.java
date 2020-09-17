package assignment02;


/**
 *
 * @author Alex Vasil
 * @param <E>
 */
public interface MyList<E> {

    public boolean add(E element);

    public boolean remove(E element);

    public MySet<E> union(MySet<E> otherSet);

    public MySet<E> intersection(MySet<E> otherSet);

    public MySet<E> difference(MySet<E> otherSet);
}
