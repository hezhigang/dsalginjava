/**
 * May 31, 2007 3:35:38 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.BinarySearchTree;
import com.codeguru.BinaryTreeNode;

/**
 * @author 和志刚
 *
 */
public class BinarySearchTreeTest extends TestCase {
	private static Logger logger = Logger.getLogger(BinarySearchTreeTest.class);
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.codeguru.BinarySearchTree#insert(com.codeguru.BinaryTreeNode, com.codeguru.BinaryTreeNode)}.
	 */
	public void testInsert() {
		BinarySearchTree bst = new BinarySearchTree();
		BinaryTreeNode node = null;
		int[] arr = {12,3,7,54,88,9,37,5,11,26,23,17};
		for (int i=0; i<arr.length; i++) {
			node = new BinaryTreeNode( arr[i] );
			bst.insert(bst.getRoot(), node);
		}
		bst.indent(bst.getRoot());
		logger.info("中序遍历(递归方式):");
		bst.inOrder(bst.getRoot());
		System.out.print("\n");
		logger.info("中序遍历(非递归方式):");
		bst.inOrderWithoutRecursion(bst.getRoot());
		System.out.print("\n");
	}
	
	public void testInsert2() {
		BinarySearchTree bst = new BinarySearchTree();
		BinaryTreeNode node = null;
		String[] arr = {"wxw", "wxz", "wzw", "wzy", "yyw", "yyx", 
				"zww", "zwx", "zwy", "zyw", "zyx", "zyy", "zyz"};
		logger.info("递归方式插入：");
		for (int i=0; i<arr.length; i++) {
			node = new BinaryTreeNode( arr[i] );
//			node.setLeft(null);
//			node.setRight(null);
//			bst.insert2(bst.getRoot(), node);
			bst.insertRecursion(bst.getRoot(), node);
		}
		
		logger.info("中序遍历(递归方式):");
		bst.inOrder(bst.getRoot());
		System.out.print("\n");
		logger.info("中序遍历(非递归方式):");
		bst.inOrderWithoutRecursion(bst.getRoot());
		System.out.print("\n");
	}
	
	public void testDelete2() {
		BinarySearchTree bst = new BinarySearchTree();
		BinaryTreeNode node = null;
		String[] arr = {"wxw", "wxz", "wzw", "wzy", "yyw", "yyx", 
				"zww", "zwx", "zwy", "zyw", "zyx", "zyy", "zyz"};
		for (int i=0; i<arr.length; i++) {
			node = new BinaryTreeNode( arr[i] );
			bst.insert2(bst.getRoot(), node);
		}
		
		logger.info("中序遍历(递归方式):");
		bst.inOrder(bst.getRoot());
		System.out.print("\n");
		
		BinaryTreeNode deNode = bst.find2("zyw", bst.getRoot());
		bst.delete2Ex(deNode);
		logger.info("中序遍历(删除后):");
		bst.inOrder(bst.getRoot());
		System.out.print("\n");		
		
	}

}
