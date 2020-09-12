package book;

/**
 * Class of a Linked List.
 *
 * @author Alex Vasil
 * @param <E> The MyLinkedList subtype.
 */
public class MyLinkedList<E> implements MyList<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     *
     */
    public MyLinkedList() {
        
    }

    /**
     * Adds each element of the array to the list.
     * 
     * @param elements Elements to be added to the list.
     */
    public MyLinkedList(E elements[]) {
        for (E element : elements) 
            add(0, element);
    }

    /**
     * Adds a element to the beginning of the list.
     * 
     * @param e Element to be added.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Adds a element to the end of the list.
     * 
     * @param e Element to be added.
     */
    public void addLast(E e) {
        if (tail == null) {
            head = tail = new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }

        size++;
    }

    /**
     * Gets the first element in the list.
     * 
     * @return The first element in the list.
     */
    public E getFirst() {
        return head.element;
    }

    /**
     * Gets last element in the list.
     * 
     * @return The last element in the list.
     */
    public E getLast() {
        return tail.element;
    }

    /**
     * Removes the first element in the list.
     * 
     * @return A new list with the first element removed.
     */
    public E removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }

            return temp.element;
        }
    }

    /**
     * Removes the last element in the list.
     * 
     * @return A list with the last element removed.
     */
    public E removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> current = head;
            Node<E> temp = tail;

            if (size == 1) {
                head = tail = null;
            } else {
                for (int i = 0; i < size - 2; i++) {
                    current = current.next;
                    temp = tail;
                    tail = current;
                    tail.next = null;
                }
                size--;
            }
            return temp.element;
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
     * Gets an element at a given index.
     * 
     * @param index Element to be got.
     * @return The element at the index.
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

    /**
     * The size of the list.
     * 
     * @return The size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds a new element at a given index.
     * 
     * @param index The position of the element.
     * @param e The element.
     */
    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<E> temp = temp = current.next;

            current.next = new Node<>(e);
            (current.next).next = temp;

            size++;
        }
    }

    /**
     * Removes an element at a given index.
     * 
     * @param index The element to be removed.
     * @return 
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;

            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;

            previous.next = current.next;

            size--;

            return current.element;
        }
    }
}
