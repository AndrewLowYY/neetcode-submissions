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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode start = null;

        if (list1.val < list2.val) {
            start = list1;
            list1 = list1.next;
        } else {
            start = list2;
            list2 = list2.next;
        }

        ListNode node = start;

        while (true) {
            if (list1 == null && list2 == null) {
                break;
            }
            if ((list1 == null) || (list2 != null && list2.val < list1.val)) {
                node.next = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        return start;
    }
}