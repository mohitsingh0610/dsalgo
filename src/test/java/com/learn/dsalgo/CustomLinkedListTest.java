package com.learn.dsalgo;

import static org.junit.Assert.assertEquals;

import com.learn.dsalgo.dll.DoublyLinkList;
import com.learn.dsalgo.ll.CustomLinkedList;

import org.junit.Test;

public class CustomLinkedListTest {
    
    @Test
    public void shouldAddLast(){
       CustomLinkedList<Integer> ll = new CustomLinkedList<>();
      
       ll.addLast(1);
       ll.addLast(2);
       ll.addLast(3);
       ll.addLast(null);
       ll.addLast(4);
       
       assertEquals(Integer.valueOf(1), ll.peekFirst());
       assertEquals(Integer.valueOf(4), ll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", ll.toString());
    }

    @Test
    public void shouldAddFirst(){
      CustomLinkedList<Integer> dll = new CustomLinkedList<>();
      
       dll.addFirst(1);
       dll.addFirst(2);
       dll.addFirst(3);
       dll.addFirst(null);
       dll.addFirst(4);
       
       assertEquals(Integer.valueOf(4), dll.peekFirst());
       assertEquals(Integer.valueOf(1), dll.peekLast());
       assertEquals("[ 4, null, 3, 2, 1 ]", dll.toString());
    }


    @Test
    public void shouldRemoveFirst(){
       CustomLinkedList<Integer> ll = new CustomLinkedList<>();

       ll.addLast(1);
       ll.addLast(2);
       ll.addLast(3);
       ll.addLast(null);
       ll.addLast(4);
           
       assertEquals(Integer.valueOf(1), ll.peekFirst());
       assertEquals(Integer.valueOf(4), ll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", ll.toString());
       ll.removeFirst();
       assertEquals("[ 2, 3, null, 4 ]", ll.toString());
    }


    @Test
    public void shouldReverse(){
       CustomLinkedList<Integer> ll = new CustomLinkedList<>();
      
       ll.addLast(1);
       ll.addLast(2);
       ll.addLast(3);
       ll.addLast(null);
       ll.addLast(4);
       ll.reverse();
       //System.out.println(ll.toString());
       assertEquals("[ 4, null, 3, 2, 1 ]", ll.toString());
    }
}
