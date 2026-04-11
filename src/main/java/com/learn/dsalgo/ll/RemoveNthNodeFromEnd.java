package com.learn.dsalgo.ll;

import com.learn.dsalgo.ll.CustomLinkedList.Node;

public class RemoveNthNodeFromEnd {
    
    public static void main(String[] args) {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        removeNthNodeFromEnd(ll, 0);
        System.out.println(ll.toString());
    }

    /**
     * he Two Pointers with Gap technique. By maintaining a fixed gap between two pointers, you can find positions relative to the END of the list in a single pass. 
     * @param ll
     * @param position
     * @return
     */
    private static Integer removeNthNodeFromEnd(CustomLinkedList<Integer>  ll, int position){
        Node<Integer> front = ll.getHead();
        Node<Integer> back = ll.getHead();
        Node<Integer> prev = ll.getHead();
        int i = position;
        while(i > 0){
            front =  front.next;
            i--;
        }
        while(front.next != null){
            front = front.next;
            prev = back;
            back = back.next;
        }
        System.out.println("back.data - "+ back.data);
        if(position == ll.size() - 1){
            return ll.removeFirst();
        }else{
           prev.next = prev.next.next;
           back.next = null;
           return prev.data;
        }
    }
}
