/**
 * Jul 3, 2007 9:59:13 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import com.codeguru.ConcreteTree;
import com.codeguru.DualTagTreeNode;
import com.codeguru.TreeNode;

/**
 * @author 和志刚
 *
 */
public class ConcreteTreeTest extends TestCase {

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
	 * Test method for {@link com.codeguru.Tree#Tree()}.
	 */
	public void testTree() {
		DualTagTreeNode[] nodeArray = {
				new DualTagTreeNode<String>("A",0,0),
				new DualTagTreeNode<String>("B",1,0),
				new DualTagTreeNode<String>("C",0,1),
				new DualTagTreeNode<String>("K",1,1),
				new DualTagTreeNode<String>("D",0,1),
				new DualTagTreeNode<String>("E",0,0),
				new DualTagTreeNode<String>("H",1,1),
				new DualTagTreeNode<String>("F",0,0),
				new DualTagTreeNode<String>("J",1,1),
				new DualTagTreeNode<String>("G",1,1)
		};
		ConcreteTree<String> t = new ConcreteTree<String>(nodeArray, nodeArray.length);
		TreeNode root = t.getRoot();
//		t.levelTraversal2(root);
//		t.preOrderTraversal(-1, root);
//		t.levelTraversal(root);  //方法实现对森林似乎有问题
	}
	
	public void testTree2() {
		DualTagTreeNode[] nodeArray = {
				new DualTagTreeNode<String>("A",0,0),
				new DualTagTreeNode<String>("D",0,1),
				new DualTagTreeNode<String>("B",1,0),
				new DualTagTreeNode<String>("C",0,1),
				new DualTagTreeNode<String>("E",0,0),
				new DualTagTreeNode<String>("F",0,0),
				new DualTagTreeNode<String>("G",1,1),
				new DualTagTreeNode<String>("K",1,1),
				new DualTagTreeNode<String>("H",1,1),
				new DualTagTreeNode<String>("J",1,1)
		};
		ConcreteTree<String> t = new ConcreteTree<String>(nodeArray, nodeArray.length, 0);
		TreeNode root = t.getRoot();
		t.levelTraversal(root);
//		t.levelTraversal2(root);
//		t.preOrderTraversal(-1, root);
	}	

}
