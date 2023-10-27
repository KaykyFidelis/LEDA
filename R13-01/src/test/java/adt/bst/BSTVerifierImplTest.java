package adt.bst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BSTVerifierImplTest {

    private BSTVerifierImpl<Integer> bstVerifier;
    private BSTImpl<Integer> bstOne;
    private BSTImpl<Integer> bstTwo;
    private BSTImpl<Integer> bstThree;

    @Before
    public void beforeEach() {
        bstOne = new BSTImpl<Integer>();
        bstTwo = new BSTImpl<Integer>();
        bstThree = new BSTImpl<Integer>();
    }

    private void fillTree() {
        Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        for (int i : array) {
            bstOne.insert(i);
        }
    }

    @Test
    public void testIsBST() {
        fillTree();
        bstVerifier = new BSTVerifierImpl<Integer>(bstOne);
        assertTrue(bstVerifier.isBST());

        bstTwo.insert(new Integer(50));
        bstTwo.getRoot().getLeft().setData(new Integer(100));
        bstTwo.getRoot().getRight().setData(new Integer(45));
        bstVerifier = new BSTVerifierImpl<Integer>(bstTwo);
        assertFalse(bstVerifier.isBST());

        bstThree.insert(new Integer(50));
        bstThree.insert(new Integer(40));
        bstThree.getRoot().getLeft().getRight().setData(200);
        assertFalse(bstVerifier.isBST());

    }
}