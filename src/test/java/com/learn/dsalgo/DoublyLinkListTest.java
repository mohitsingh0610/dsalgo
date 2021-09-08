package com.learn.dsalgo;

import static org.junit.Assert.assertEquals;

import com.learn.dsalgo.dll.DoublyLinkList;

import org.junit.Test;

public class DoublyLinkListTest {
    
    @Test
    public void shouldAddLast(){
       DoublyLinkList<Integer> dll = new DoublyLinkList<>();
      
       dll.addLast(1);
       dll.addLast(2);
       dll.addLast(3);
       dll.addLast(null);
       dll.addLast(4);
       
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
    }

    @Test
    public void shouldAddFirst(){
       DoublyLinkList<Integer> dll = new DoublyLinkList<>();
      
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
    public void shouldAddAt(){
       DoublyLinkList<Integer> dll = initialize();
           
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
       dll.addAt(3, 5);
       assertEquals("[ 1, 2, 3, 5, null, 4 ]", dll.toString());
    }

    @Test
    public void shouldRemoveFirst(){
       DoublyLinkList<Integer> dll = initialize();
           
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
       dll.removeFirst();
       assertEquals("[ 2, 3, null, 4 ]", dll.toString());
    }

    @Test
    public void shouldRemoveLast(){
       DoublyLinkList<Integer> dll = initialize();
           
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
       dll.removeLast();
       assertEquals("[ 1, 2, 3, null ]", dll.toString());
    }

    @Test
    public void shouldRemoveAt(){
       DoublyLinkList<Integer> dll = initialize();
           
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
       dll.removeAt(2);
       assertEquals("[ 1, 2, null, 4 ]", dll.toString());
    }

    @Test
    public void shouldRemove(){
       DoublyLinkList<Integer> dll = initialize();
           
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
       dll.remove(2);
       assertEquals("[ 1, 3, null, 4 ]", dll.toString());
    }

    @Test
    public void shouldGetIndexOf(){
       DoublyLinkList<Integer> dll = initialize();
           
       assertEquals(Integer.valueOf(1), dll.peekFirst());
       assertEquals(Integer.valueOf(4), dll.peekLast());
       assertEquals("[ 1, 2, 3, null, 4 ]", dll.toString());
       
       assertEquals(3, dll.indexOf(null));
    }

    private DoublyLinkList<Integer> initialize() {
        DoublyLinkList<Integer> dll = new DoublyLinkList<>();
          
           dll.addAt(0, 1);
           dll.addAt(1, 2);
           dll.addAt(2, 3);
           dll.addAt(3, null);
           dll.addAt(4, 4);
        return dll;
    }

}
