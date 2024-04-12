package April_11_Assignment;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Q2_PalindromLinkedlist {
    public int isPalindrome(ListNode head) {
        // Edge case: empty list or list with only one node is considered palindrome
        if (head == null || head.next == null) {
            return 1;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Break the original list into two parts

        // Step 3: Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return 0; // Not a palindrome
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Step 4: If all elements match, it's a palindrome
        return 1;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(2);

        Q2_PalindromLinkedlist solution = new  Q2_PalindromLinkedlist();
        System.out.println(solution.isPalindrome(head1)); // Output: 1
        System.out.println(solution.isPalindrome(head2)); // Output: 0
    }
}
