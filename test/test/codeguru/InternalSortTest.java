/**
 * Sep 20, 2007 9:06:34 PM
 和志刚
 */
package test.codeguru;

import java.util.Random;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.InternalSort;

/**
 * @author 和志刚
 * 
 */
public class InternalSortTest extends TestCase {
	private static Logger logger = Logger.getLogger(InternalSortTest.class);

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
	 * {@link com.codeguru.InternalSort#bucketSort(int[], int, int, int)}.
	 */
	public void testBucketSort() {
		int min = 1;
		int max = 10;
		int len = 10;
		Random rand = new Random();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++)
			arr[i] = rand.nextInt(max - min) + min;
		logger.info("before bucket sorting: ");
		InternalSort.printArray(arr);
		arr = InternalSort.bucketSort(arr, len, min, max);
		logger.info("after bucket sorting: ");
		InternalSort.printArray(arr);
	}
	
	public void testQsort() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr6 = InternalSort.quicksort(ori);
		logger.info("采用快速排序的结果->");
		InternalSort.printArray(orderedArr6);		
	}
	
	/**
	 * 堆排序的测试案例
	 *
	 */
	public void testHeapsort() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr = InternalSort.heapsort(ori);
		logger.info("采用堆排序的结果->");
		InternalSort.printArray(orderedArr);		
	}
	
	/**
	 * 归并排序的TestCase
	 *
	 */
	public void testMergesort() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr = InternalSort.mergesort(ori);
		logger.info("采用两路归并排序的结果->");
		InternalSort.printArray(orderedArr);		
	}	

	/**
	 * Shell排序的TestCase
	 *
	 */
	public void testShellsortpro() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr = InternalSort.shellsortpro(ori);
		logger.info("采用非常规增量序列希尔排序的结果->");
		InternalSort.printArray(orderedArr);		
	}	
	
	/**
	 * 冒泡排序的TestCase
	 *
	 */
	public void testBubbleSort() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr = InternalSort.bubbleSort(ori);
		logger.info("冒泡排序结果->");
		InternalSort.printArray(orderedArr);		
	}
	
	/**
	 * 选择排序的TestCase
	 *
	 */
	public void testSelectionSort() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr = InternalSort.selectionSort(ori);
		logger.info("选择排序结果->");
		InternalSort.printArray(orderedArr);		
	}	
	
	/**
	 * 直接插入排序的TestCase
	 *
	 */
	public void testinsertionSort1() {
		int[] ori = InternalSort.arrToSort();
		logger.info("待排序的数组：");
		InternalSort.printArray(ori);
		int[] orderedArr = InternalSort.insertionSort_1(ori);
		logger.info("直接插入排序结果->");
		InternalSort.printArray(orderedArr);		
	}	
}
