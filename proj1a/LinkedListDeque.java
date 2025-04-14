public class LinkedListDeque<T> implements List<T> {

    private class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;
        public Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }
        public T getRecursive(int index) {
            if (index == 0) {
                return item;
            }
            return next.getRecursive(index - 1);
        }
    }

    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> first = new Node<>(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        ++size;
    }

    @Override
    public void addLast(T item) {
        Node<T> last = new Node<>(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void printDeque() {
        Node<T> n = sentinel.next;
        while (n != sentinel) {
            System.out.println(n.item);
            n = n.next;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T val = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        --size;
        return val;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T val = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        --size;
        return val;
    }

    @Override
    public T get(int index) {
        Node<T> n = sentinel.next;
        for (int i = 0; i < index; ++i) {
            n = n.next;
        }
        return n.item;
    }

    public T getRecursive(int index) {
        return sentinel.next.getRecursive(index);
    }
}
