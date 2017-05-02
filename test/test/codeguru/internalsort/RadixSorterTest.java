/**
 * Oct 14, 2007 7:53:23 PM
 和志刚
 */
package test.codeguru.internalsort;

import java.util.Random;

import junit.framework.TestCase;

import com.codeguru.internalsort.Node;
import com.codeguru.internalsort.RadixSorter;

/**
 * @author 和志刚
 *
 */
public class RadixSorterTest extends TestCase {

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
	 * Test method for {@link com.codeguru.internalsort.RadixSorter#sort(com.codeguru.internalsort.Node[], int, int, int)}.
	 */
	public void testSort() {
		int min = 100;
		int max = 1000;
		int n = 10;
		Random rand = new Random();
		Node[] arr = new Node[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = new Node();
			arr[i].key = rand.nextInt(max - min) + min;
		}
		RadixSorter sorter = new RadixSorter();
		sorter.sort(arr, n, 3, 10);
	}

}
