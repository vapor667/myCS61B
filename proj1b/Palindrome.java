public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deq = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); ++i) {
            deq.addLast(word.charAt(i));
        }
        return deq;
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    private boolean isPalindrome(Deque<Character> deq) {
        if (deq.size() <= 1) {
            return true;
        }
        if (deq.removeFirst() != deq.removeLast()) {
            return false;
        }
        return isPalindrome(deq);
    }


}
