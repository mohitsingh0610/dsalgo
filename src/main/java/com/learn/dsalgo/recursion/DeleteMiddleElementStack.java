package com.learn.dsalgo.recursion;

import com.learn.dsalgo.stack.Stack;

public class DeleteMiddleElementStack {

    
    public static void main(String[] str){
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(7);
        st.push(4);
        st.push(8);
        st.push(2);
        st.push(1);
        deleteMiddle(st, st.size()  , 1);
        System.out.println(st.toString());
    }

    static void deleteMiddle(Stack<Integer> st, int n, int current){
            
       if(st.isEmpty() ||  n  == current){
        return;
       }

       int temp = st.pop();
        
       deleteMiddle(st, n, current+1);

       if(current != (n/2) +1 ){
             st.push(temp);
       }
    }
}
