package book;

/**
 * Interface for methods of MyList.
 * 
 * @author Alex Vasil
 * @param <E> The MyList subtype.
 */
public interface MyList<E> {

    public void clear();

    public boolean isEmpty();

    public boolean contains(E e);

    public int indexOf(E e);

    public E get(int index);

    public void set(int index, E e);

    public int size();

    public void add(int index, E e);

    public E remove(int index);
}
