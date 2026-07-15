/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        int remove = size - n;
        if (remove == 0) {
            return head.next;
        }
        
        ListNode curr = head;
        int counter = 0;
        while (curr != null) {
            if (curr.next != null && counter == remove - 1) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
            counter++;
        }
        return head;
    }
}
