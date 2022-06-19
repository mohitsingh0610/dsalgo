package com.learn.dsalgo.recursion;

import com.learn.dsalgo.stack.Stack;

/**
 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. 
 * When the stack becomes empty, insert all held items one by one at the bottom of the stack.
 */
public class ReverseAStack {
    
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(7);
        st.push(4);
        st.push(2);
        st.push(1);
        reverse(st);
        System.out.println(st.toString());
    }


    static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int temp = st.pop();
        reverse(st);
        insertAtBottom(st, temp);
    }

    static void insertAtBottom(Stack<Integer> st, int temp){
        if(st.isEmpty()){
            st.push(temp);
            return;
        }
        int x = st.pop();
        insertAtBottom(st, temp);
        st.push(x);
    }
}
