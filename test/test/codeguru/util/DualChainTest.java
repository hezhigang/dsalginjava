/**
 * Oct 10, 2007 8:58:57 PM
 和志刚
 */
package test.codeguru.util;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.util.DualChain;
import com.codeguru.util.DualChainNode;

/**
 * @author 和志刚
 *
 */
public class DualChainTest extends TestCase {
	private static Logger logger = Logger.getLogger(DualChainTest.class);

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
	 * Test method for {@link com.codeguru.util.DualChain#insert(java.lang.Comparable, com.codeguru.util.DualChainNode)}.
	 */
	public void testInsertEDualChainNodeOfE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codeguru.util.DualChain#insert(com.codeguru.util.DualChainNode, java.lang.Comparable)}.
	 */
	public void testInsertDualChainNodeOfEE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codeguru.util.DualChain#append(java.lang.Comparable)}.
	 */
	public void testAppend() {
		DualChain list = new DualChain();
		for(int i=0; i<20; i++) {
//			DualChainNode<Integer> node = new DualChainNode<Integer>(  );
			list.append(new Integer(i));
		}
		DualChainNode<Integer> node = list.search( new Integer(12) );
		list.insert(node, new Integer(59));
		list.print();
	}

	/**
	 * Test method for {@link com.codeguru.util.DualChain#delete(java.lang.Comparable)}.
	 */
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codeguru.util.DualChain#search(java.lang.Comparable)}.
	 */
	public void testSearch() {
		fail("Not yet implemented");
	}

}
