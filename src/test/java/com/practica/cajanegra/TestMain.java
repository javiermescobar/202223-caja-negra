package com.practica.cajanegra;

import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestMain {

    //Funcionalidad correcta
    @Test
    public void testDepthNoParam() {
        BinaryTree noDepthTestTree = new BinaryTree("11");
        BinaryTree depthTestTree = new BinaryTree("11");
        depthTestTree.insert("11", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> new BinaryTree("a").depth());
        assertEquals(0, noDepthTestTree.depth());
        assertEquals(1, depthTestTree.depth());
    }

    //Falla
    @Test
    public void testDepthParam() {
        BinaryTree noDepthTestTree = new BinaryTree("11");
        BinaryTree depthTestTree = new BinaryTree("11");
        depthTestTree.insert("11", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> new BinaryTree("a").depth(noDepthTestTree.getRoot()));
        assertThrows(Exception.class, () -> noDepthTestTree.depth(null));
        assertEquals(0, noDepthTestTree.depth(noDepthTestTree.getRoot()));
        assertEquals(1, depthTestTree.depth(depthTestTree.getRoot())); //falla el test
    }

    //Funciona
    @Test
    public void testEquals() {
        BinaryTree noDepthTree = new BinaryTree("12");
        BinaryTree depthTestTree = new BinaryTree("11");
        depthTestTree.insert("12", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> noDepthTree.equals(null));
        assertEquals(true, noDepthTree.equals(noDepthTree));
        assertEquals(false, noDepthTree.equals(depthTestTree));
        assertEquals(true, depthTestTree.equals(noDepthTree));
        assertEquals(true, depthTestTree.equals(depthTestTree));
    }

    //Funciona correctamente
    @Test
    public void testGetRoot() {
        BinaryTree testTree = new BinaryTree("11");

        assertThrows(Exception.class, () -> new BinaryTree("aa").getRoot());
        assertEquals("11", testTree.getRoot().getContent());
    }

    //Falla
    @Test
    public void testGetSubTree() {
        BinaryTree noDepthTestTree = new BinaryTree("11");
        BinaryTree depthTestTree = new BinaryTree("12");
        depthTestTree.insert("11", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> noDepthTestTree.getSubTree(new Node("aa")));
        assertThrows(Exception.class, () -> noDepthTestTree.getSubTree(new Node("12")));
        assertEquals("11", noDepthTestTree.getSubTree(new Node("11")).getRoot().getContent());
        assertEquals(1, depthTestTree.getSubTree(new Node("12")).depth()); //falla el test
        assertEquals("11", depthTestTree.getSubTree(new Node("11")).getRoot().getContent());
    }

    //Funciona correctamente
    @Test
    public void testInsert(){
        BinaryTree insertTestTree = new BinaryTree("12");
        insertTestTree.insert("11", insertTestTree.getRoot(), true);
        insertTestTree.insert("11", insertTestTree.getRoot(), false);

        assertThrows(Exception.class, () -> insertTestTree.insert("aa", insertTestTree.getRoot(), true));
        assertThrows(Exception.class, () -> insertTestTree.insert("12", new Node("13"), true));
        assertNotNull(insertTestTree.getRoot().getLeftChild());
        assertNotNull(insertTestTree.getRoot().getRightChild());
    }

    //Funciona correctamente
    @Test
    public void testIterator() {
        BinaryTree noDepthTestTree = new BinaryTree("11");
        BinaryTree depthTestTree = new BinaryTree("12");
        depthTestTree.insert("11", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> new BinaryTree("aa").iterator());
        assertEquals("11", noDepthTestTree.iterator().next());
        assertEquals("12", depthTestTree.iterator().next());
    }

    //Falla
    @Test
    public void testRemove() {
        BinaryTree noDepthTestTree = new BinaryTree("11");
        BinaryTree depthTestTree = new BinaryTree("12");
        depthTestTree.insert("11", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> new BinaryTree("aa").remove(null));
        assertThrows(Exception.class, () -> noDepthTestTree.remove(null));
        assertThrows(Exception.class, () -> noDepthTestTree.remove(new Node("13")));
        noDepthTestTree.remove(new Node("11"));
        assertNull(noDepthTestTree.getRoot()); //falla
    }

    @Test
    public void testToString() {
        BinaryTree noDepthTestTree = new BinaryTree("11");
        BinaryTree depthTestTree = new BinaryTree("12");
        depthTestTree.insert("11", depthTestTree.getRoot(), true);

        assertThrows(Exception.class, () -> new BinaryTree("aa").toString());
        assertEquals("11", noDepthTestTree.toString());
        assertEquals("12, 11", depthTestTree.toString());
    }
}
