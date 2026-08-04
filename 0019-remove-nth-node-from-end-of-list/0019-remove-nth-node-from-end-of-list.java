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
       int len =length(head);
       // specefic case
       if(len==n){
        return head.next;
       }
       int steps=len-n;
       ListNode prev=head;
       for(int i=1;i<steps;i++){
        prev=prev.next;
       }
       prev.next=prev.next.next;
       return head;
       
    }
     //Helper function to calculate length
        public int length(ListNode head){
            int len=0;
            ListNode temp=head;
            while(temp!=null){
                len++;
                temp=temp.next;
            }
            return len;
        }

}