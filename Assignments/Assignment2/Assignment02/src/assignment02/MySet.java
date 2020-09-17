package assignment02;

import java.awt.List;

/**
 *
 * @author Alex Vasil
 * @param <E>
 */
public class MySet<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MySet() {

    }

    public MySet(E[] array) {
        for (E element : array) {
            add(element);
        }
    }

    public MySet(List otherList) {
            
    }

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

    private void addElement(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public boolean remove(E element) {
        Node<E> current = head;
        Node<E> temp = null;
        
        while (current != null && !current.element.equals(element)) {
            temp = current;
            current = current.next;
        }
        
        if (current == null) 
            return false;
        if (temp == null) 
            temp = current;
        
        temp.next = current.next;
        size--;
        return true;
    }

    @Override
    public MySet<E> union(MySet<E> otherSet) {
        return new MySet<>();
    }

    @Override
    public MySet<E> intersection(MySet<E> otherSet) {
        return new MySet<>();
    }

    @Override
    public MySet<E> difference(MySet<E> otherSet) {
        return new MySet<>();
    }

    public int size() {
        return size;
    }

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
}
