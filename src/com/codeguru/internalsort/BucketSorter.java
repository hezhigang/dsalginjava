/**
 * Oct 14, 2007 8:36:37 PM
 和志刚
 */
package com.codeguru.internalsort;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 * 桶式排序
 */
public class BucketSorter extends Sorter {
	private static Logger logger = Logger.getLogger(BucketSorter.class);
	
	/**
	 * 
	 * @param array
	 * @param n
	 * @param max
	 */
	public static void sort(Record[] array, int n, int max) {
		Record[] tmpArr = new Record[n];
		int[] count = new int[max];
		
		int i;
		
		for(i=0; i<max; i++)
			tmpArr[i] = array[i];
		
		for(i=0; i<max; i++)
			count[i] = 0;
		
		for(i=0; i<n; i++)
			count[array[i].key]++;
		
		for(i=1; i<max; i++)
			count[i] = count[i]+count[i-1];
		
		for(i=n-1; i>=0; i--)
			array[--count[tmpArr[i].key]] = tmpArr[i];  //?????
	}
	
	/**
	 * 打印数组
	 * @param array
	 * @param n
	 */
	public void printArray(Record[] array, int n) {
		for(int i=0; i<n; i++)
			logger.info(array[i].key + " " + array[i].surname + " " + array[i].iq);
	}	
}
