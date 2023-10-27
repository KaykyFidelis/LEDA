package adt.avltree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

public class AVLTreeVerifierImplTest {

    private AVLTreeVerifierImpl<Integer> verifier;
    private BSTVerifierImpl<Integer> verifierBST;

    private BSTImpl<Integer> bstOne;

    private AVLTreeImpl<Integer> avl1;
    private AVLTreeImpl<Integer> avl2;

    @Before
    public void beforeEach() {
        avl1 = new AVLTreeImpl<Integer>();
        avl2 = new AVLTreeImpl<Integer>();
        bstOne = new BSTImpl<Integer>();

    }

    private void fillTree() {
        Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        for (int i : array) {
            avl1.insert(i);
        }
    }

    @Test
    public void testIsAVLTree() {
        fillTree();
        verifier = new AVLTreeVerifierImpl<Integer>(avl1);
        assertTrue(verifier.isAVLTree());

        bstOne.insert(new Integer(50));
        bstOne.insert(new Integer(49));
        bstOne.insert(new Integer(48));
        bstOne.insert(new Integer(47));
        verifierBST = new BSTVerifierImpl<Integer>(bstOne);
        assertTrue(verifierBST.isBST());
        avl2.insert(new Integer(50));
        avl2.insert(new Integer(45));
        avl2.getRoot().getLeft().setData(new Integer(40));
        avl2.getRoot().getLeft().setLeft(new BSTNode<Integer>());
        avl2.getRoot().getLeft().setRight(new BSTNode<Integer>());

        avl2.getRoot().getLeft().getLeft().setData(new Integer(30));
        avl2.getRoot().getLeft().getLeft().setLeft(new BSTNode<Integer>());
        avl2.getRoot().getLeft().getLeft().setRight(new BSTNode<Integer>());

        verifier = new AVLTreeVerifierImpl<Integer>(avl2);
        assertFalse(verifier.isAVLTree());

    }
}