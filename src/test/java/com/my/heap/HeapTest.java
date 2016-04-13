/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.heap;

import static com.my.heap.Main.init;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class HeapTest {
    
    public HeapTest() {
    }

    @Test
    public void testIncreaseSize() {
        System.out.println("increaseSize");
        Heap h = new Heap(16);
        init(h);
        h.increaseSize();
        assertEquals(32, h.getMaxSize());
    }
    
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Heap h = new Heap(16);
        h.insert(22);
        h.remove();
        assertEquals(true, h.isEmpty());
    }
    
    @Test
    public void testInsert() {
        System.out.println("insert");
        Heap h = new Heap(16);
        h.insert(1);
        h.insert(2);
        h.insert(5);
        String ex = "2 1";
        String is = h.remove().getKey() + " " + h.remove().getKey();
        assertEquals(ex, is);
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Heap h = new Heap(16);
        h.insert(2);
        h.insert(1);
        assertEquals(1, h.remove().getKey());
    }

    @Test
    public void testChange() {
        System.out.println("change");
        Heap h = new Heap(16);
        h.insert(3);
        h.insert(5);
        h.change(2, 4);
        assertEquals(4, h.remove().getKey());
    }
}
