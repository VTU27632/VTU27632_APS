class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode prev = null;
        ListNode current = slow;

        while (current != null) {
            ListNode nextnode = current.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }

        // Compare first half and reversed second half
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }
}