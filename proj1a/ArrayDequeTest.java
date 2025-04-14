public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> things = new ArrayDeque<>();
        things.addFirst(2);
        things.addLast(3);
        things.addFirst(4);
        things.addLast(3);
        for(int i = 0; i < 16; ++i) {
            things.addLast(i);
        }
        for(int i = 0; i < 16; ++i) {
            int temp;
            temp = things.removeFirst();
        }
        System.out.println(things.get(2));
        things.printDeque();
    }
}
