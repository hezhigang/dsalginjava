/**
 * Jun 10, 2007 4:13:31 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.MinHeap;

/**
 * @author 和志刚
 *
 */
public class MinHeapTest extends TestCase {
	private static Logger logger = Logger.getLogger(MinHeapTest.class);

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
	 * Test method for {@link com.codeguru.MinHeap#insert(java.lang.Comparable)}.
	 */
	public void testInsert() {
		MinHeap<Character> heap = new MinHeap<Character>(9);
		char[] keyArr = {'E','D','X','K','H','L','M','C','P'};
		for(int i=0; i<keyArr.length; i++)
			heap.insert( new Character(keyArr[i]) );
		logger.info("初始堆：");
		heap.printHeap();
		logger.info("删除堆顶元素：");
		heap.removeMin();
		heap.printHeap();
		logger.info("删除元素：");
		heap.remove(3);
		heap.printHeap();
	}

	/**
	 * Test method for {@link com.codeguru.MinHeap#removeMin()}.
	 */
	public void testRemoveMin() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codeguru.MinHeap#remove(int)}.
	 */
	public void testRemove() {
		fail("Not yet implemented");
	}

}
