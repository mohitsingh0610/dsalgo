package com.learn.dsalgo;

import static org.junit.Assert.assertEquals;

import com.learn.dsalgo.stack.Stack;

import org.junit.Test;
public class StackTest {

    @Test
    public void shouldPush(){
       Stack<Integer> stack = new Stack<>();
      
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(null);
       stack.push(4);
       
       assertEquals(Integer.valueOf(4), stack.peek());
       assertEquals("[ 1, 2, 3, null, 4 ]", stack.toString());
    }

    @Test
    public void shouldPop(){
       Stack<Integer> stack = new Stack<>();
      
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(null);
       stack.push(4);
       
       assertEquals(Integer.valueOf(4), stack.peek());
       assertEquals("[ 1, 2, 3, null, 4 ]", stack.toString());

       stack.pop();
       stack.pop();
       assertEquals(Integer.valueOf(3), stack.peek());
       assertEquals("[ 1, 2, 3 ]", stack.toString());
    }


    @Test(expected = RuntimeException.class)
    public void shouldThrowStackIsEmpty(){
       Stack<Integer> stack = new Stack<>();
      
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(null);
       stack.push(4);
       
       assertEquals(Integer.valueOf(4), stack.peek());
       assertEquals("[ 1, 2, 3, null, 4 ]", stack.toString());

       stack.pop();
       stack.pop();
       stack.pop();
       stack.pop();
       stack.pop();
       stack.pop();
       stack.pop();
       stack.pop();
    }

}
