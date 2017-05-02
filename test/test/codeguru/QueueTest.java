/**
 * Apr 26, 2007 9:48:30 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import com.codeguru.Queue;

/**
 * @author 和志刚
 *
 */
public class QueueTest extends TestCase {

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
	
	public void test() {
		Queue<String> queue = new Queue<String>();
		queue.enQueue("a");
		queue.enQueue("b");
		queue.enQueue("c");
		queue.enQueue("d");
		queue.enQueue("e");
		queue.deQueue();
		queue.deQueue();
	}

}
