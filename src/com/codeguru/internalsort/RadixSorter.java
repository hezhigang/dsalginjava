/**
 * Oct 12, 2007 8:11:29 PM
 和志刚
 */
package com.codeguru.internalsort;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 * 基数排序的静态链表实现
 */
public class RadixSorter {
	private static Logger logger = Logger.getLogger(RadixSorter.class);
	
	/**
	 * 分配
	 * @param array
	 * @param first 静态链表中第1个记录
	 * @param i 当前处理的子码位置
	 * @param r 基数
	 * @param queue
	 */		
	private void distribute(Node[] array, Refint first, int i, int r, StaticQueue[] queue) {
		for(int j=0; j<r; j++)
			queue[j].head = -1;
		while(first.i != -1) {
			int k = array[first.i].key;
			
			for(int j=0; j<i; j++) {
				k = k/r;
			}
			k = k % r;
			
			if (queue[k].head == -1)
				queue[k].head = first.i;
			else
				array[queue[k].tail].next = first.i;
			queue[k].tail = first.i;
			
			first.i = array[first.i].next;
		}
		
	}
	
	/**
	 * 收集
	 * @param array
	 * @param first 静态链表中第1个记录
	 * @param i 当前处理的子码位置，未用到，为统一而保留
	 * @param r 基数
	 * @param queue
	 */
	private void collect(Node[] array, Refint first, int i, int r, StaticQueue[] queue) {
		int j=0, last;
		while(queue[j].head==-1) j++;
		first.i = queue[j].head;
		last = queue[j].tail;
		while(j<r-1) {
			j++;  //注释会死循环，为什么?
			while(j<r-1 && queue[j].head==-1) j++;
			if (queue[j].head!=-1) {
				array[last].next = queue[j].head;
				last = queue[j].tail;
			}
		}
		array[last].next = -1;
	}
	
	/**
	 * 
	 * @param array
	 * @param first 静态链array中第一个记录的下标
	 */
	private void printArray(Node[] array, int first) {
		StringBuffer sb = new StringBuffer();
		int tmp;
		tmp = first;
		while(tmp != -1) {
			sb.append(array[tmp].key + " ");
			tmp = array[tmp].next;
		}
		sb.append("\n");
		logger.info(sb.toString());
	}
	
	/**
	 * 排序
	 * @param array
	 * @param n
	 * @param d 排序码个数
	 * @param r 基数
	 */
	public void sort(Node[] array, int n, int d, int r) {
		Refint first = new Refint();
		first.i = 0;
		StaticQueue[] queue = new StaticQueue[r];
		for(int i=0; i<r; i++)
			queue[i] = new StaticQueue();
		for(int i=0; i<n; i++)
			array[i].next = i+1;
		array[n-1].next = -1;
		logger.info("排序前：");
		printArray(array, 0);
		for(int i=0; i<d; i++) {
			distribute(array, first, i, r, queue);
			collect(array, first, i, r, queue);
		}
		logger.info("排序后：");
		printArray(array, first.i);
	}
	
	/**
	 * 为了给整数参数不传值而传引用而设
	 * (不知道Java有没有更适当的方法),在C++中可以用int&
	 * @author 和志刚
	 *
	 */
	class Refint {
		/**
		 * 
		 */
		public Refint() {
			super();
			// TODO Auto-generated constructor stub
		}

		int i;
	}
}
