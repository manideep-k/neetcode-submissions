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
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        
        int size = 0;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
            size++;
        }
        
        int remove = size - n;
        if (remove == 0) {
            return head.next;
        }
        list.get(remove - 1).next =  list.get(remove).next;
        return head;
    }
}
