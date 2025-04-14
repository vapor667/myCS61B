public class ArrayDeque<T> implements List<T> {
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

    @Override
    public void addFirst(T item) {
        items[tail] = item;
        tail = (tail - 1 + items.length) % items.length;
        ++size;
        if (size == items.length) {
            resize();
        }
    }

    @Override
    public void addLast(T item) {
        items[head] = item;
        head = (head + 1) % items.length;
        ++size;
        if (size == items.length) {
            resize();
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = tail + 1; i <= tail + size; ++i) {
            System.out.println(items[i % items.length]);
        }
    }

    @Override
    public T removeFirst() {
        tail = (tail + 1) % items.length;
        T temp = items[tail];
        --size;
        if (size == items.length / 2 - 1 && items.length >= 32) {
            esize();
        }
        return temp;
    }

    @Override
    public T removeLast() {
        head = (head - 1 + items.length) % items.length;
        T temp = items[head];
        --size;
        if (size == items.length / 2 - 1 && items.length >= 32) {
            esize();
        }
        return temp;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(tail + index + 1) % items.length];
    }

    private void resize() {
        T[] temp_items = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, temp_items, 0, head);
        System.arraycopy(items, tail + 1, temp_items, items.length + tail + 1, items.length - tail - 1);
        tail += items.length;
        items = temp_items;
    }

    private void esize() {
        T[] temp_items = (T[]) new Object[items.length / 2];
        for (int i = tail + 1; i <= tail + size; ++i) {
            temp_items[i - tail - 1] = items[i % items.length];
        }
        items = temp_items;
        head = tail = items.length - 1;
    }
}
