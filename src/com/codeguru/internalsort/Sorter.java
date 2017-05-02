/**
 * Oct 11, 2007 9:09:06 PM
 和志刚
 */
package com.codeguru.internalsort;

/**
 * @author 和志刚
 * 总的排序类
 */
public abstract class Sorter<R> {
	
	/**
	 * 交换
	 * @param array
	 * @param i
	 * @param j
	 */
	protected void swap(R[] array, int i, int j) {
		R temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}
	
	/**
	 * 打印数组
	 * @param array
	 * @param n
	 */
	public void printArray(R[] array, int n) {
		for(int i=0; i<n; i++)
			System.out.print(array[i] + " ");
		System.out.println("\n");		
	}
}
