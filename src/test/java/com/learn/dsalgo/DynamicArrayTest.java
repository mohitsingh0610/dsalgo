package com.learn.dsalgo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.learn.dsalgo.arrays.DynamicArray;

import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void shouldCreateArrayOfDefaultSize()
    {
      
        DynamicArray<Integer> da = new DynamicArray<>(); 
        assertEquals(16, da.size());
    }

    @Test
    public void shouldCreateArrayOf30Size()
    {
      
        DynamicArray<Integer> da = new DynamicArray<>(30); 
        assertEquals(30, da.size());
    }
    
    @Test
    public void shouldAddElement()
    {
        DynamicArray<Integer> da = new DynamicArray<>(5); 
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        assertEquals(10, da.size());
        assertEquals("[1, 2, 3, 4, 5]", da.toString());
    }

    @Test
    public void shouldRemoveElementAtIndex()
    {
        DynamicArray<Integer> da = new DynamicArray<>(5); 
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        assertEquals(10 ,da.size());
        da.removeAt(2);
        assertEquals(4, da.size());
        assertEquals("[1, 2, 4, 5]", da.toString());
        da.add(6);
        da.add(7);
        assertEquals(8, da.size());
        assertEquals("[1, 2, 4, 5, 6, 7]", da.toString());
    }

    @Test
    public void shouldRemoveElement()
    {
        DynamicArray<Integer> da = new DynamicArray<>(5); 
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        assertEquals(10 ,da.size());
        da.remove(2);
        assertEquals(4, da.size());
        assertEquals("[1, 3, 4, 5]", da.toString());
        da.add(6);
        da.add(7);
        assertEquals(8, da.size());
        assertEquals("[1, 3, 4, 5, 6, 7]", da.toString());
    }

    
    @Test
    public void shouldGetIndexOf()
    {
        DynamicArray<Integer> da = new DynamicArray<>(5); 
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        assertEquals(1 ,da.indexOf(2));
    }

    @Test
    public void shouldContains(){
        DynamicArray<Integer> da = new DynamicArray<>(5); 
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        assertTrue(da.contains(2));
        assertFalse(da.contains(7));
    }

    @Test
    public void shouldSet(){
        DynamicArray<Integer> da = new DynamicArray<>(5); 
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        da.set(7, 4);
        assertTrue(da.contains(7));
        assertFalse(da.contains(5));
    }
}
