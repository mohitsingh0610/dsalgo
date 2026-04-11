package com.learn.dsalgo.ll;

import com.learn.dsalgo.ll.CustomLinkedList.Node;

public class MergedSortedList {

    public static void main(String[] args) {
        CustomLinkedList<Integer> ll1 = new CustomLinkedList<>();
        ll1.addLast(1);
        ll1.addLast(3);
        ll1.addLast(5);

        CustomLinkedList<Integer> ll2 = new CustomLinkedList<>();
        ll2.addLast(2);
        ll2.addLast(4);
        ll2.addLast(6);


        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<Integer> trav = mergeLL(ll1, ll2);
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }
    

    /**
     * The Merge Technique on Linked Lists + the Dummy Node pattern. Notice how the dummy node eliminates the need to handle "which list's first node should be the head?" — the answer is always dummy.next. 
     * This exact merge logic is used inside Merge Sort for linked lists. Also note the Space difference: merging arrays needed O(n+m) space for a new array, but merging linked lists is O(1) because you're just rewiring pointer
     * COMPLEXITY:
     Time:  O(n + m) where n, m are the lengths of the lists
     Space: O(1) — we're reusing existing nodes, not creating new ones ✅
     * @param ll1
     * @param ll2
     * @return
     */
    private static Node<Integer> mergeLL(CustomLinkedList<Integer> ll1, CustomLinkedList<Integer> ll2){
        Node<Integer> dummy = new Node<Integer>(0, null);
        Node<Integer> p1 =  ll1.getHead();
        Node<Integer> p2 =  ll2.getHead();
        Node<Integer> current = dummy;
        while(p1 != null && p2 != null){
              if( p1.data <= p2.data ){
                current.next = p1;
                p1 = p1.next;
              }else{
                current.next = p2;
                p2 = p2.next;
              }
            current = current.next;  
        }

        if(p1 != null){
           current.next = p1;
        }
        if(p2 != null){
           current.next = p2;
        }

        //This will point to head.
        return dummy.next;
    }
}
