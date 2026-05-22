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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer>ls=new ArrayList<>();
        while(head!=null)
        {
            ls.add(head.val);
            head=head.next;
        }
        int []ans=new int[ls.size()];
        Stack<Integer>st=new Stack<>();
           int n = ls.size();
        for (int i = n - 1; i >= 0; i--) {

            int curr = ls.get(i);

       
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            
            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek();
            }

          
            st.push(curr);
        }

        return ans;
    }
}