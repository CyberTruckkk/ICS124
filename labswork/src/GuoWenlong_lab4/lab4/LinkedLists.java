package GuoWenlong_lab4.lab4;

import ca.camosun.ics124.lab3.Stack;
import ca.camosun.ics124.lab4.List;

import java.util.NoSuchElementException;

public class LinkedLists<E> implements List<E>, Stack<E> {
    // s for test the result of add and remove
//    String s="list[  ]: ";
    int size = 0;
    List<E> list;
    //    E item;
    Node first;
    Node last;// useless

    public LinkedLists() {
        first = null;
        last = null;
        size = 0;
    }

    public void traverse(String s) {
        Node current = this.first;
        System.out.println("\n"+s);
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    /**
     * Test whether any elements are currently waiting on the stack.
     *
     * @return true if the stack is empty; false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return total number of elements stored in this collection.
     */
    @Override
    public int size() {
        int count = 0;
        Node<E> tails = this.first;
        while (tails != null) {
            tails = tails.next;
            count++;
        }
        return count;
    }

    /**
     * Add an element to the top of the stack.
     *
     * @param e- the element to add to this collection.
     * @throws IllegalStateException - if the stack cannot hold more elements
     * @throws NullPointerException  - if a null element is provided
     */
    @Override
    public void push(E e) {
        this.add(e);
    }

    /**
     * Removes the element from the top of the stack and returns it.
     *
     * @return Removes the element from the top of the stack and returns it.
     */
    @Override
    public E pop() {
        return this.remove(this.size);
    }

    /**
     * Returns (but does not remove) the element at the top of the stack.
     *
     * @return null if the stack is empty; otherwise, the most recently pushed element.
     */
    @Override
    public E peek() {
        return this.last();
    }

    /**
     * Remove all elements from this collection.
     * set both head and tail to null ,so can not  access to this abstract list
     */
    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * Get the element stored at the beginning of the list. This element is not removed from the collection.
     *
     * @return the first(head) element stored in this collection.
     * @throws NoSuchElementException - if the list is empty.
     */
    @Override
    public E first() throws NoSuchElementException {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    /**
     * Get the element stored at the beginning of the list. This element is not removed from the collection.     *
     *
     * @return the last (tail) element stored in this collection.
     * @throws NoSuchElementException - if the list is empty.
     */
    @Override
    public E last() throws NoSuchElementException {
        final Node<E> f = first;
        Node c = f;
        if (c == null) {
            System.out.println("first is null last() terminate");
            throw new NoSuchElementException("first is null last() terminate");
        } else {
            while (c.next != null) {
                c = c.next;
            }
        }
        return (E) c.item;
    }

    /**
     * @param -position of the element to retrieve ,if i <0,count from tail
     * @return the element at the given position
     * @throws IndexOutOfBoundsException -if index ∉ [-size(), size())
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        int index = 0;
        if (Math.abs(i) > this.size || i > size) {
            throw new IndexOutOfBoundsException("index ∉ [-size(), size())");
        } else if (i >= 0) {
            index = i;
        } else if (i < 0) {
            index = this.size() + i;
        }
        Node<E> x = first;
        for (int count = 0; count < index; count++) {
            x = x.next;
        }
        return x.item;
    }

    /**
     * Add the given element to the front of this list.
     * size++ once element added
     *
     * @param e - element to be added
     */
    @Override
    public void add(E e) {
        Node newNode = new Node<>(e);
        if (first == null) {
            this.first = newNode;
            return;
        }
        Node current = first;
        while (current.prev != null) {
            current = current.prev;
        }
        first = newNode;
        first.next = current;
        current.prev = first;
        size++;

    }

    /**
     * Inserts an element at the given position.
     *
     * @param e - element to be added
     * @param i - position at which the new element will be inserted
     * @throws IndexOutOfBoundsException- if index ∉ [-size(), size()]
     */
    @Override
    public void add(E e, int i) throws IndexOutOfBoundsException {
        int index = 0;
        if (Math.abs(i) > this.size() || i >= size()) {
            throw new IndexOutOfBoundsException("index ∉ [-size(), size()]");
        } else if (i >= 0) {
            index = i;
        } else if (i < 0) {
            index = this.size() + i;
        }
//        System.out.println("add index after check i><0, i= " + i + " after check i = " + index);
        Node<E> x = new Node<>(e);
        Node<E> c = first;
        Node<E> d = first;
        if (index > 0) {
            for (int k = 0; k < index; k++) {
                c = c.next;
            }
            d = c.next;
            d.prev = x;
            x.next = d;
            c.next = x;
            x.prev = c;
        }else if(index==0){
            add(e);
        }

    }

    /**
     * Removes the element at the given position from the list and returns it.
     * size -- ,once method executed
     *
     * @param i- position of the element to be removed
     * @return the element that was removed
     * @throws IndexOutOfBoundsException- if index ∉ [-size(), size())
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        int index = 0;
        if (Math.abs(i) > size() || i >= size() || first() == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (i >= 0) {
                index = i;
            } else {
                index = size() + i;
            }
        }
        Node<E> c = first;
        final Node<E> zero = first;
        if (index == 0) {
//            c = first.next;
//            first = first.next;
          first=  first.next;
          first.next=first.next;
            return zero.item;
        } else {
            for (int k = 0; k < index; k++) {
                c = c.next;
            }
            if (index < size()-1) {
                c.prev.next = c.next;
                c.next.prev = c.prev;
                return c.item;
            } else {
                final Node<E> tail = c;
                if (index == size()-1) {
                    c.prev.next = null;
                    c = null;
                }
                return tail.item;
            }
        }
    }

    /**
     * @param e the element to search for
     * @return position index
     * @throws NoSuchElementException if no return in if and else block
     */
    @Override
    public int indexOf(E e) throws NoSuchElementException {
        int counter = 0;
        if (e == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return counter;
                }
                counter++;
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (x.item.equals(e)) {
                    return counter;
                }
                counter++;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Reverses the order of all elements in this list.
     */
    @Override
    public void reverse() {
        Node temp = null;
        Node current = first;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            first = temp.prev;
        }
    }

    /**
     * Splits the list in two at the given position.
     * The element at that position and all following elements will be removed from this list and returned as part of a new list.
     *
     * @param i- position of the first element to be removed
     * @return a new list containing all elements that were removed
     * @throws IndexOutOfBoundsException - if index ∉ [-size(), size())
     */
    @Override
    public List<E> cut(int i) throws IndexOutOfBoundsException {
        int index = 0;
        if (Math.abs(i) > this.size() || i >= size) {
            throw new IndexOutOfBoundsException("index ∉ [-size(), size()]");
        } else if (i >= 0) {
            index = i;
        } else if (i < 0) {
            index = this.size() + i;
        }
        Node<E> x = first;
        for (int k = 0; k < index; k++) {
            x = x.next;
        }
        int num = this.size - index;
//        this.list = new LinkedLists<E>(num, x, last);
        return list;
    }
//        this.list = new LinkedLists();
//        try {
//            Node cutter = (Node) get(i);
//            list = new LinkedLists();
//        } catch (IndexOutOfBoundsException index) {
//            throw new IndexOutOfBoundsException("index ∉ [-size(), size())");
//        }
//        return this.list;
//    }
    //todo not finished ,get rid of list

    /**
     * @return
     */
    public String printOut() {
        String s = "";
//        E[] sArray = (E[]) new Object[size()];
        Node c = first;
        while (c.next != null) {
            s = s + ", " + c.item.toString();
            c = c.next;
        }
        return " list: [ " + s + ", " + c.item + " ] ";
    }
}

class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    public Node(E element) {
        this.item = element;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}