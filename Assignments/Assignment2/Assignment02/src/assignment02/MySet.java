package assignment02;

import java.util.List;

/**
 * A implementation of Set.
 * 
 * @author Alex Vasil
 * @param <E> Class type.
 */
public class MySet<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     *
     */
    public MySet() {

    }

    /**
     * Constructor of MySet with a given array.
     * 
     * @param array Array to be added to the set.
     */
    public MySet(E[] array) {
        for (E element : array) {
            add(element);
        }
    }

    /**
     * Constructor of MySet with a given list.
     * 
     * @param otherList List to be added to the set.
     */
    public MySet(List<E> otherList) {
        otherList.forEach((element) -> { add(element); });
    }

    /**
     * Adds a element to a set.
     * 
     * @param element Element to be added to the set.
     * @return If it was added.
     */
    @Override
    public boolean add(E element) {
        if (head == null) {
            addElement(element);

            if (tail == null) {
                tail = head;
            }
            return true;
        } else {
            Node<E> current = head;
            boolean isDup = false;

            for (int i = 0; i < size; i++) {
                if (current.element.equals(element)) {
                    isDup = true;
                    break;
                }
                current = current.next;
            }

            if (!isDup) {
                addElement(element);
                return true;
            }
        }

        return false;
    }
    
    /**
     * Adds a given element to the set.
     * 
     * @param element To be added.
     */
    private void addElement(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Removes a element from a set.
     * 
     * @param element Element to be removed.
     * @return If it was removed.
     */
    @Override
    public boolean remove(E element) {
        Node<E> current = head;
        Node<E> temp = null;

        while (current != null && !current.element.equals(element)) {
            temp = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else {
            if (current == head) {
                head = head.next;
            } else if (size == 1) {
                head = tail = null;
            } else {
                temp.next = current.next;
            }
            size--;
            return true;
        }
    }

    /**
     * Combines two lists together. 
     * 
     * @param otherSet Set to be combined to the original set.
     * @return The combined set.
     */
    @Override
    public MySet<E> union(MySet<E> otherSet) {
        MySet<E> unionSet = new MySet<>();
        Node<E> originalSetHead = head;
        Node<E> otherSetHead = otherSet.head;

        while (originalSetHead != null) {
            unionSet.add(originalSetHead.element);
            originalSetHead = originalSetHead.next;
        }

        while (otherSetHead != null) {
            unionSet.add(otherSetHead.element);
            otherSetHead = otherSetHead.next;
        }
        
        return unionSet;
    }

    /**
     * Combines two lists elements that are the same in either list. 
     * 
     * @param otherSet Set to be combined to the original set.
     * @return The combined set.
     */
    @Override
    public MySet<E> intersection(MySet<E> otherSet) {
        MySet<E> interSet = new MySet<>();
        Node<E> originalSetHead = head; 
        Node<E> otherSetHead = otherSet.head; 

        while (originalSetHead != null) {
            while (otherSetHead != null) {
                if (originalSetHead.element.equals(otherSetHead.element)) {
                    interSet.add(otherSetHead.element);
                    break;
                }
                otherSetHead = otherSetHead.next;
            }
            otherSetHead = otherSet.head;
            originalSetHead = originalSetHead.next;
        }

        return interSet;
    }

    /**
     * Combines two lists elements that aren't the same in either list. 
     * 
     * @param otherSet Set to be combined to the original set.
     * @return The combined set.
     */
    @Override
    public MySet<E> difference(MySet<E> otherSet) {
        MySet<E> diffSet = new MySet<>();
        Node<E> originalSetHead = head;
        Node<E> otherSetHead = otherSet.head;
        boolean isUnique = true;

        while (originalSetHead != null) {
            while (otherSetHead != null) {
                if (originalSetHead.element.equals(otherSetHead.element)) {
                    isUnique = false;
                    break;
                }
                otherSetHead = otherSetHead.next;
            }

            if (isUnique) {
                diffSet.add(originalSetHead.element);
            }

            isUnique = true;
            otherSetHead = otherSet.head;
            originalSetHead = originalSetHead.next;
        }

        return diffSet;
    }

    /**
     * The size of the set.
     * 
     * @return The size of the set.
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Gets a element from the set.
     * 
     * @param index Element index to be obtained.
     * @return Element at the given index.
     */
    @Override
    public E get(int index) {
        if (size != 0 && index < size && index >= 0) {
            int i = 0;
            Node<E> current = head;
            while (i < index) {
                current = current.next;
                i++;
            }
            return current.element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Clears the entire list.
     */
    @Override
    public void clear() {
        while (head != null) {
            Node<E> temp = head;
            head = head.next;
            temp = null;
        }
    }

    /**
     * Checks if the list is empty.
     * 
     * @return If it's empty.
     */
    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    /**
     * Checks to see if element e is in the list.
     * 
     * @param e Element to be checked for in the list.
     * @return If element e is in the list.
     */
    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Gets the index of element e if it's in the list.
     * 
     * @param e Element to be checked if it's in the list.
     * @return The index of the first found element if it's in the list, otherwise 
     * it returns -1 if it's not in the list.
     */
    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.equals(e)) {
                return i;
            } else {
                current = current.next;
            }
        }
        return -1;
    }

    /**
     * Sets the element at a given index.
     * 
     * @param index Element to be replaced.
     * @param e Element that replaces the original element.
     */
    @Override
    public void set(int index, E e) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                current.element = e;
                break;
            } else {
                head = current.next;
            }
        }
    }
}
