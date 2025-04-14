public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(2);
        ArrayDeque.addLast(3);
        ArrayDeque.removeFirst();
        ArrayDeque.removeLast();
        ArrayDeque.addLast(6);
        ArrayDeque.addLast(7);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(9);
        ArrayDeque.addFirst(10);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(12);
        ArrayDeque.get(0);
        ArrayDeque.addFirst(14);
        ArrayDeque.addFirst(15);
        ArrayDeque.get(0);
        ArrayDeque.addFirst(17);
        ArrayDeque.addFirst(18);
        ArrayDeque.get(6);
        ArrayDeque.addFirst(20);
        ArrayDeque.removeFirst();
    }
}
