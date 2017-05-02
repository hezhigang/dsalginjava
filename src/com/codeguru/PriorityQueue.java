/**
 * Jun 14, 2007 2:34:57 PM
 和志刚
 */
package com.codeguru;

/**
 * @author 和志刚
 * 优先队列
 */
public class PriorityQueue<E extends Comparable<E>> {
	private int maxLen = 0;
	private int currSize = 0;
	private MaxHeap<E> heap = null;
	
	public PriorityQueue(int maxSize) {
		super();
		maxLen = maxSize;
		heap = new MaxHeap<E>(maxSize);
	}
	
	public void insert(E e) {
		if (currSize == maxLen)
			return;
		heap.insert(e);
		currSize++;
	}
	
	public E extractMax() {
		if (currSize == 0)
			return null;
		currSize--;
		return heap.removeMax();
	}
	
}
