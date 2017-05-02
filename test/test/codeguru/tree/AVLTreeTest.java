/**
 * 2007-12-21 下午09:29:48
 * 和志刚
 */
package test.codeguru.tree;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.tree.AVLTree;

public class AVLTreeTest extends TestCase {
	private static Logger logger = Logger.getLogger(AVLTreeTest.class);

	/**
	 * Test method for
	 * {@link com.codeguru.tree.AVLTree#add(java.lang.Comparable)}.
	 */
	public void testAdd() {
		AVLTree<String> avltree = new AVLTree<String>();
		avltree.add("cup");
		avltree.add("cop");
		avltree.add("copy");
		avltree.add("hit");
		avltree.add("hi");
		avltree.add("his");
		avltree.add("hia");
		/*
		 * AVLTree<Integer> avltree = new AVLTree<Integer>(); avltree.add(new
		 * Integer(3)); avltree.add(new Integer(2)); avltree.add(new
		 * Integer(1)); avltree.add(new Integer(4)); avltree.add(new
		 * Integer(5)); avltree.add(new Integer(6)); avltree.add(new
		 * Integer(7)); avltree.add(new Integer(10)); avltree.add(new
		 * Integer(16)); avltree.add(new Integer(8)); avltree.add(new
		 * Integer(9)); avltree.add(new Integer(15)); avltree.add(new
		 * Integer(14)); avltree.add(new Integer(13)); avltree.add(new
		 * Integer(12)); avltree.add(new Integer(11)); avltree.add(new
		 * Integer(9));
		 */

		avltree.preOrder(avltree.root);
		logger.info("广度优先周游结果:::");
		avltree.levelTraversal(avltree.root);
		// avltree.indent(avltree.root);
	}
/*
	public void testBuilderAVLTree() {
		AVLTree<String> avltree = new AVLTree<String>();
		avltree.add("head");
		avltree.add("he");
		avltree.add("tea");
		avltree.add("teach");
		avltree.add("twin");
		avltree.add("hot");
		avltree.add("toss");
		avltree.preOrder(avltree.root);
		logger.info("广度优先周游结果:::");
		avltree.levelTraversal(avltree.root);
	}
	*/
}
