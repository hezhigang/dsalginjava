/**
 * Oct 14, 2007 9:05:54 PM
 和志刚
 */
package test.codeguru.internalsort;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.internalsort.BucketSorter;
import com.codeguru.internalsort.Record;

/**
 * @author 和志刚
 *
 */
public class BucketSorterTest extends TestCase {
	private static Logger logger = Logger.getLogger(BucketSorterTest.class);

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
	 * Test method for {@link com.codeguru.internalsort.BucketSorter#sort(com.codeguru.internalsort.Record[], int, int)}.
	 */
	public void testSort() {
		Record arr[] = new Record[10];
		arr[0] = new Record(1, "John", 100);
		arr[1] = new Record(2, "Mike", 120);
		arr[2] = new Record(3, "John", 110);
		arr[3] = new Record(4, "Tom", 101);
		arr[4] = new Record(5, "Peter", 100);
		arr[5] = new Record(6, "Joke", 100);
		arr[6] = new Record(7, "Abel", 120);
		arr[7] = new Record(8, "Newton", 110);
		arr[8] = new Record(9, "Bill", 110);
		arr[9] = new Record(1, "Mary", 114);
		
		BucketSorter sorter = new BucketSorter();
		
		logger.info("排序前：");
		sorter.printArray(arr, 10);
		BucketSorter.sort(arr, 10, 10);
		
		logger.info("排序后：");
		sorter.printArray(arr, 10);
	}

}
