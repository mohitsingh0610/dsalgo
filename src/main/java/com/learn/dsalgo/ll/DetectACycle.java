package com.learn.dsalgo.ll;

import com.learn.dsalgo.ll.CustomLinkedList.Node;

/**
 * Floyd's Cycle Detection:
 * PROBLEM: 
   Given the head of a linked list, determine if the list
   has a CYCLE (i.e., some node's next pointer points back
   to a previous node, creating a loop).

   Input (has cycle):
   [1]→[2]→[3]→[4]→[5]
              ↑         │
              └─────────┘
   Output: true

   Input (no cycle):
   [1]→[2]→[3]→NULL
   Output: false
 */
public class DetectACycle {
    
    public static void main(String[] args){
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        //creating a cycle
        ll.getNodeAt(4).next = ll.getNodeAt(2);
        System.out.println(hasCycle(ll.getHead()));
        System.out.print(getCycleStartPoint(ll.getHead()));
    }


    /*
    THE BRILLIANT IDEA:
   Think of two runners on a circular track. The fast runner
   (2 steps) will eventually lap the slow runner (1 step).
   If the track has no loop (just a straight line), the fast
   runner hits the end.

   Cycle exists    → fast and slow WILL meet
   No cycle exists → fast reaches NULL


   VISUAL WALKTHROUGH (has cycle):

   [1]→[2]→[3]→[4]→[5]─┐
              ↑          │
              └──────────┘

   Start: slow=[1], fast=[1]

   Step 1: slow→[2], fast→[3]
   Step 2: slow→[3], fast→[5]
   Step 3: slow→[4], fast→[4]
                ↑          ↑
            slow == fast → CYCLE DETECTED ✅

   (fast went [5]→[3]→[4], slow went [3]→[4])


   VISUAL WALKTHROUGH (no cycle):

   [1]→[2]→[3]→NULL

   Start: slow=[1], fast=[1]

   Step 1: slow→[2], fast→[3]
   Step 2: fast.next == NULL → STOP
   
   fast reached the end → NO CYCLE ✅
    */
    static boolean hasCycle(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        boolean cycleDetected = Boolean.FALSE;
        
        while(fast.next != null){
               slow = slow.next;
               fast = fast.next.next;
               if(fast == slow){
                 cycleDetected = Boolean.TRUE;
                 break;
               }
        }
         
       return cycleDetected;

    }

    static Node<Integer> getCycleStartPoint(Node<Integer> head){

        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Node<Integer> cycleStartingPoint = head;
        boolean cycleDetected = Boolean.FALSE;
        
        while(fast.next != null){
               slow = slow.next;
               fast = fast.next.next;
               if(fast == slow){
                 cycleDetected = Boolean.TRUE;
                 break;
               }
        }
        if(cycleDetected == Boolean.TRUE){
           while(cycleStartingPoint != slow){
              cycleStartingPoint = cycleStartingPoint.next;
              slow = slow.next;
           }
           return cycleStartingPoint;
        }
        return null;
    }
}
