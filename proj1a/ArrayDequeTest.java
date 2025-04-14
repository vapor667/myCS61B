public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.removeLast();
        ArrayDeque.addLast(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(6);
        ArrayDeque.get(0);
        ArrayDeque.addFirst(8);
        ArrayDeque.addLast(9);
        ArrayDeque.get(4);
        ArrayDeque.get(2);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(13);
        ArrayDeque.removeLast();
        ArrayDeque.get(0);
        ArrayDeque.addFirst(16);
        ArrayDeque.addFirst(17);
        ArrayDeque.addFirst(18);
        ArrayDeque.get(4);
        ArrayDeque.addLast(20);
        ArrayDeque.addLast(21);
        System.out.println(ArrayDeque.removeFirst());
    }
}
