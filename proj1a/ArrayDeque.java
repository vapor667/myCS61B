public class ArrayDeque<T> implements List<T>{
    private T[] items;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        head = 0;
        tail = 7;
        size = 0;
    }

    public void addFirst(T item) {
        items[tail] = item;
        tail = (tail - 1 + items.length) % items.length;
        ++size;
        if (size == items.length) {
            resize();
        }
    }

    public void addLast(T item) {
        items[head] = item;
        head = (head + 1) % items.length;
        ++size;
        if (size == items.length) {
            resize();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = tail + 1; i <= tail + size; ++i) {
            System.out.println(items[i % items.length]);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T temp = items[tail + 1];
        tail = (tail + 1) % items.length;
        --size;
        return temp;
    }

    public T removeLast() {
       if (isEmpty()) {
            return null;
        }
        T temp = items[head - 1];
        head = (head - 1 + items.length) % items.length;
        --size;
        return temp;
    }

    public T get(int index) {
        return items[(tail + index + 1) % items.length];
    }

    private void resize() {
        T[] temp_items = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, temp_items, 0, items.length);
        items = temp_items;
        head = 0;
        tail = items.length - 1;
    }
}
