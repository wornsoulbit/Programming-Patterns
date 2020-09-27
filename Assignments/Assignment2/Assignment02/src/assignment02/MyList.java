package assignment02;


/**
 *
 * @author Alex Vasil
 * @param <E>
 */
public interface MyList<E> {
    
    /**
     * Clears the main list.
     */
    public void clear();

    /**
     * Checks if a list is empty.
     * @return 
     */
    public boolean isEmpty();

    /**
     * Checks to see if the list contains element E.
     * 
     * @param e Element to be checked if it's in the list.
     * @return If e is in the list or not.
     */
    public boolean contains(E e);

    /**
     * Index of a specific element.
     * 
     * @param e Element to be searched.
     * @return The index of the given Element e.
     */
    public int indexOf(E e);

    /**
     * Gets an element at a specified index.
     * 
     * @param index Index to be obtained.
     * @return The element at the given index.
     */
    public E get(int index);

    /**
     * Sets an element at a given index.
     * 
     * @param index Index of element to be replaced.
     * @param e Element e to replace the element at the given index.
     */
    public void set(int index, E e);

    /**
     * The size of the list.
     * 
     * @return The size of the list.
     */
    public int size();
    
    /**
     * Adds a element to a list.
     * 
     * @param element Element to be added.
     * @return If it was added.
     */
    public boolean add(E element);

    /**
     * Removes a element from a list.
     * 
     * @param element Element to be removed.
     * @return If it was removed.
     */
    public boolean remove(E element);

    /**
     * Combines two lists together. 
     * 
     * @param otherSet Set to be combined to the original set.
     * @return The combined set.
     */
    public MySet<E> union(MySet<E> otherSet);

    /**
     * Combines two lists elements that are the same in either list. 
     * 
     * @param otherSet Set to be combined to the original set.
     * @return The combined set.
     */
    public MySet<E> intersection(MySet<E> otherSet);

    /**
     * Combines two lists elements that aren't the same in either list. 
     * 
     * @param otherSet Set to be combined to the original set.
     * @return The combined set.
     */
    public MySet<E> difference(MySet<E> otherSet);
}
