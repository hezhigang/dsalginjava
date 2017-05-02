/**
 * Jun 15, 2007 9:11:58 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.HuffmanTree;

/**
 * @author 和志刚
 *
 */
public class HuffmanTreeTest extends TestCase {
	private static Logger logger = Logger.getLogger(HuffmanTreeTest.class);

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
	 * Test method for {@link com.codeguru.HuffmanTree#HuffmanTree(E[])}.
	 */
	public void testHuffmanTree() {
		int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41};
		int Len = arr.length;
		Integer[] w = new Integer[Len];
		for(int i=0; i<Len; i++)
			w[i] = new Integer(arr[i]);
		HuffmanTree<Integer> hfTree = new HuffmanTree(w);
		hfTree.indent(hfTree.getRoot());
	}

}
