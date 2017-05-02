/**
 * Jun 14, 2007 2:10:32 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.MaxHeap;

/**
 * @author 和志刚
 *
 */
public class MaxHeapTest extends TestCase {
	private static Logger logger = Logger.getLogger(MaxHeapTest.class);

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
	 * Test method for {@link com.codeguru.MaxHeap#insert(java.lang.Comparable)}.
	 */
	public void testInsert() {
		MaxHeap<Character> heap = new MaxHeap<Character>(9);
		char[] keyArr = {'E','D','X','K','H','L','M','C','P'};
		for(int i=0; i<keyArr.length; i++)
			heap.insert( new Character(keyArr[i]) );
		logger.info("初始堆：");
		heap.printHeap();
		logger.info("删除堆顶元素：");
		heap.removeMax();
		heap.printHeap();
		logger.info("删除元素：");
		heap.remove(3);
		heap.printHeap();
	}

	/**
	 * Test method for {@link com.codeguru.MaxHeap#removeMax()}.
	 */
	public void testRemoveMax() {
		fail("Not yet implemented");
	}

}
