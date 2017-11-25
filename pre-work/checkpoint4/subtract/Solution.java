/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode subtract(ListNode a) {
        final ListNode head = a;
        
        // If list is empty or unitary there's nothing to do
        if (head == null || head.next == null) return head;

        //Split the list in two
        Result result = split(head);
        final ListNode middle = result.middle;
        final boolean isEvenList = result.isEven;

        //Invert first half
        final ListNode invertedHead = invert(head);

        //Substract
        ListNode curNodeFirstHalf = invertedHead;
        ListNode curNodeSecondHalf = isEvenList ? middle : middle.next;
        while (curNodeSecondHalf != null) {
            curNodeFirstHalf.val = curNodeSecondHalf.val - curNodeFirstHalf.val;
            curNodeFirstHalf = curNodeFirstHalf.next;
            curNodeSecondHalf = curNodeSecondHalf.next;
        }

        //De-invert first half
        invert(invertedHead);
        //Relink
        invertedHead.next = middle;

        return head;
	}

    static class Result {
        ListNode middle;
        boolean isEven;

        Result(ListNode middle, boolean isEven) {
            this.middle = middle;
            this.isEven = isEven;
        }
    }
    
    private ListNode invert(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode next = head.next;
        curr.next = null;

        while (next != null) {
            ListNode nextNext = next.next;
            next.next = curr;
            curr = next;
            next = nextNext;
        }
        return curr;
    }
    
    private Result split(ListNode head) {
        //Don't attempt to split empty or unitary list
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode prevSlow = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = null;

        return new Result(slow, fast == null);
    }


//Recursive solution causes SO	
// 	private static class Result {
// 	    ListNode node;
// 	    boolean isPastMiddle;
	    
// 	    Result(ListNode node, boolean isPastMiddle) {
// 	        this.node = node;
// 	        this.isPastMiddle = isPastMiddle;
// 	    }
// 	}
	
// 	private Result subtract(ListNode curr, ListNode head) {
// 	    if (curr == null) {
// 	        return new Result(head, false);
// 	    } else {
// 	        Result opposite = subtract(curr.next, head);
// 	        opposite.isPastMiddle = opposite.isPastMiddle 
// 	                                    || curr == opposite.node 
// 	                                    || curr.next == opposite.node;
	        
// 	        if (!opposite.isPastMiddle) {
// 	            opposite.node.val = curr.val - opposite.node.val;
// 	        }
// 	        opposite.node = opposite.node.next;
// 	        return opposite;
// 	    }
	    
// 	}
}
