package com.learn.dsalgo.recursion;

import com.learn.dsalgo.stack.Stack;

public class SortAStack {
    

    public static void main(String[] str){
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(7);
        st.push(4);
        st.push(2);
        st.push(1);
        sortStack(st);
        System.out.println(st.toString());
    }

    static void sortStack(Stack<Integer> st){

        if(st.isEmpty()){
            return;
        }
        int x =  st.pop();
        // Sort remaining stack
        sortStack(st);
        // Push the top item back in sorted stack
        insertInASortedStack(st, x);
    }

    static void insertInASortedStack(Stack<Integer> st, int x){
         
        // Base case: Either stack is empty or newly
        // inserted item is greater than top (more than all
        // existing)
        if(st.isEmpty() || st.peek() < x){
            st.push(x);
            return;
        }
         // If top is greater, remove the top item and recur
        int temp = st.pop();
        insertInASortedStack(st, x);
        // Put back the top item removed earlier
        st.push(temp);
    }

}
