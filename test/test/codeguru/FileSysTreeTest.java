/**
 * Jun 24, 2007 3:52:11 PM
 和志刚
 */
package test.codeguru;

import java.io.File;

import junit.framework.TestCase;

import com.codeguru.FCBEntry;
import com.codeguru.FileSysTree;
import com.codeguru.TreeNode;

/**
 * @author 和志刚
 * 
 */
public class FileSysTreeTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.codeguru.FileSysTree#build(com.codeguru.TreeNode)}.
	 */
	public void testBuild() {
		File d = new File("E:/22. 相声/");
		FileSysTree<FCBEntry> tree = new FileSysTree<FCBEntry>();
		tree.createRoot(new FCBEntry(d.getName(), d.length()));
		TreeNode<FCBEntry> root = tree.getRoot();
		tree.build(root, d);
//		tree.levelTraversal3(root);
		tree.levelTraversal2(root);
//		 tree.preOrderTraversal(-2, root);
//		tree.postOrderTraversal(-2, root);
	}

	/**
	 * Test method for
	 * {@link com.codeguru.FileSysTree#visitAllDirsAndFiles(java.io.File)}.
	 */
	public void testVisitAllDirsAndFiles() {
		// File dir = new File("E:/22. 相声");
		// try {
		// if (dir.exists())
		// FileSysTree.visitAllDirsAndFiles(dir);
		// } finally {
		// if (dir != null)
		// dir = null;
		// }
	}

}
