package com.learn.dsalgo.ll;

import com.learn.dsalgo.ll.CustomLinkedList.Node;

public class RemoveDuplicatesFromLL {

    public static void main(String[] args) {
        CustomLinkedList<Integer> ll =  new CustomLinkedList<>();
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        removeDuplicate(ll.getHead());
        System.out.println(ll);

    }

    /**
     * The Skip-Ahead pattern on linked lists. The key subtlety: when you find a duplicate, you skip it but DON'T advance current.
     *  Why? Because the new next node might ALSO be a duplicate (like three 3's in a row). 
     * Only advance when the values are different. This same "stay and check again" pattern appears in many in-place modification problems.
     * @param head
     */
    private static void removeDuplicate(Node<Integer> head){
       
        Node<Integer> current = head;
        while (current != null && current.next != null) {
            if(current.data == current.next.data){
                current.next = current.next.next; 
            }else{
                current = current.next;
            }
        }
    }
    
}
