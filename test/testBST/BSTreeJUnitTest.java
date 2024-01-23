package testBST;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;

import testClass.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import treeImplementation.BSTree;
import treeImplementation.BSTreeNode;
import utilities.Iterator;

public class BSTreeJUnitTest {

    private BSTree<Shape> shapeTree;
    

    /**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	
	@Before
    public void setUp() throws Exception {
        shapeTree = new BSTree<>();
        
        // PLEASE NOTE: THE COMPARABLE LOGIC FOR THESE SHAPES ARE HEIGHT.
        
        // IN THE BELOW EXAMPLE CONE > CYCLINDER > OCTAGONAL PRISM > PENTAGONAL PRISM > PYRAMID ..... (ON THE BASIS OF THEIR HEIGHT)
        shapeTree.add(new OctagonalPrism(3,2));
        shapeTree.add(new PentagonalPrism(4,2));
        shapeTree.add(new Cone(1,2));
        shapeTree.add(new SquarePrism(6,2));
        shapeTree.add(new Cylinder(2,2));
        shapeTree.add(new Pyramid(5,2));
        shapeTree.add(new TriangularPrism(7,2));
        
        
    }

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		shapeTree = null;
	}
    

    @Test
    public void test_Collection_Comparables_Shapes_Add() {
    	boolean expected = true;
    	boolean actual = shapeTree.contains(new Cone(1,2));
    	
    	assertEquals("The method doesn't add Comparables properly", expected, actual);
       
    }

    @Test
    public void test_Collection_Comparables_Shapes_InorderTraverse() {
    	
       Iterator<Shape> it1 = shapeTree.inorderIterator();
       Iterator<Shape> it2 = shapeTree.inorderIterator();
       it2.next();
       int i =0;
       while(it2.hasNext()){
    	   if (it1.next().compareTo(it2.next()) > 0) {
    		   fail("Wrong Inorder Traversal generated");
    		   return;
    	   }
    	   assertTrue(true);
       }
    }
    
    @Test
    public void test_Collection_Comparables_Shapes_PreorderTraverse() {
        Iterator<Shape> it = shapeTree.preorderIterator();
        List<Shape> expectedPreorder = Arrays.asList(
        	new OctagonalPrism(3, 2),
        	new Cone(1, 2),           
            new Cylinder(2, 2),       
            new PentagonalPrism(4, 2), 
            new SquarePrism(6, 2),    
            new Pyramid(5, 2),        
            new TriangularPrism(7, 2) 
        );

        for (Shape expectedShape : expectedPreorder) {
            assertTrue("Shape should be in Preorder", it.hasNext());
            assertEquals("Shape in Preorder traversal does not match expected", expectedShape, it.next());
        }

        assertFalse("Iterator should have no more elements", it.hasNext());
    }


    @Test
    public void test_Collection_Comparables_Shapes_PostorderTraverse() {
        Iterator<Shape> it = shapeTree.postorderIterator();
        List<Shape> expectedPostorder = Arrays.asList(
        	new Cylinder(2, 2),  
        	new Cone(1, 2),
        	new Pyramid(5, 2),  
        	new TriangularPrism(7, 2), 
        	new SquarePrism(6, 2),
            new PentagonalPrism(4, 2), 
            new OctagonalPrism(3, 2)
        );

        for (Shape expectedShape : expectedPostorder) {
            assertTrue("Shape should be in Postorder", it.hasNext());
            assertEquals("Shape in Postorder traversal does not match expected", expectedShape, it.next());
        }

        assertFalse("Iterator should have no more elements", it.hasNext());
    }

    @Test
    public void test_Collection_Comparables_Shapes_Search() {
        BSTreeNode<Shape> actual = shapeTree.search(new Cone(1,2));
        if (actual.getElement().equals(new Cone(1,2))) {
        	assertTrue(true);
        }
        else {
        	fail("Failed to Search");
        }
    }
    @Test
    public void test_Collection_Comparables_Shapes_Contains() {
    	shapeTree.add(new Cone(30, 10));
    	boolean expected = true;
    	boolean actual = shapeTree.contains(new Cone(30,10));
    	
    	assertEquals("The method doesn't work properly", expected, actual);
    }
    @Test
    public void test_Collection_Comparables_Shapes_RemoveMin() {
       shapeTree.removeMin(); // It should remove Cone(1,2) object from the Binary shapeTree.
       boolean expected = false;
       boolean actual = shapeTree.contains(new Cone(1,2));
       assertEquals("The RemoveMin method doesnt't function properly", expected, actual);
    }
    @Test
    public void test_Collection_Comparables_Shapes_RemoveMax() {
       shapeTree.removeMax();
       boolean expected = false;
       boolean actual = shapeTree.contains(new TriangularPrism(7, 2));
       assertEquals("The RemoveMax method doesnt't function properly", expected, actual);
    }
    @Test
    public void test_Collection_Comparables_Shapes_GetHeight() {
       int expected = 3;
       int actual = shapeTree.getHeight();
       assertEquals("The height is wrong", expected ,actual);
    }

    @Test
    public void test_Collection_Comparables_Shapes_Size() {
       int expected = 7;
       int actual = shapeTree.size();
       assertEquals("The size is wrong", expected ,actual);
    }


}
