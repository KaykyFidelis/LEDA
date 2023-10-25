package adt.heap.extended;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import adt.heap.ComparatorMaxHeap;

public class HeapMergeImplTest {
    HeapMergeImpl chamadorKKKKK;

    @Before
    public void antesDeComecar() {
        ComparatorMaxHeap<Integer> comparador = new ComparatorMaxHeap<Integer>();
        chamadorKKKKK = new HeapMergeImpl(comparador);
    }

    @Test
    public void testMergeArraysAndOrder() {
        ArrayList<Integer[]> meusArrays = new ArrayList<>();
        meusArrays.add(new Integer[] { 1, 2, 3, 4, 5 });
        meusArrays.add(new Integer[] { 1, 2, 3, 4, 5 });
        Integer[] saida = chamadorKKKKK.mergeArraysAndOrder(meusArrays);
        for (Integer x : saida) {
            System.out.println(x);
        }
    }

    @Test
    public void testSumRange() {

    }
}
