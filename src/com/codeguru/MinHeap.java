/**
 * Jun 8, 2007 10:29:37 AM
 和志刚
 */
package com.codeguru;


/**
 * 最小堆
 * @author 和志刚
 *
 * @param <E>
 */
public class MinHeap<E extends Comparable<E>> {
	private int maxSize = 0;
	private int currSize = 0;
	private E[] heapArray = null;
	
	/**
	 * 
	 * @param maxLen
	 */
	public MinHeap(final int maxLen) {
		super();
		if (maxLen<=0)
			return;
		currSize = 0;
		maxSize = maxLen;
		heapArray = (E[])new Comparable[maxSize];
		buildHeap();
	}

	/**
	 * 建堆
	 *
	 */
	private void buildHeap() {
		for(int i=currSize/2-1; i>=0; i--)
			siftDown(i);
	}
	
	public void swap(E[] arr, int i, int j) {
		E temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 是否叶结点
	 * @param pos
	 * @return
	 */
	public boolean isLeaf (int pos) {
		return ( pos>currSize/2 & pos<currSize );
	}
	
	/**
	 * 父结点
	 * @param pos
	 * @return
	 */
	public int parent(int pos) {
		return (pos-1)/2;
	}
	
	/**
	 * 左儿子
	 * @param pos
	 * @return
	 */
	public int leftChild(int pos) {
		return 2*pos+1;
	}
	
	/**
	 * 右儿子
	 * @param pos
	 * @return
	 */
	public int rightChild(int pos) {
		return 2*pos+2;
	}
	
	/**
	 * 向上筛
	 * @param position
	 */
	private void siftUp(final int position) {
		int tmpPos = position;
		E temp = heapArray[tmpPos];
		while( tmpPos>0 && heapArray[parent(tmpPos)].compareTo( temp )>0 ) {
			heapArray[tmpPos] = heapArray[parent(tmpPos)];
			tmpPos = parent(tmpPos);
		}
		heapArray[tmpPos] = temp;
	}
	
	/**
	 * 向下筛
	 * @param left
	 */
	private void siftDown(final int left) {
		int i = left; //父结点
		int j = leftChild(left); //较小的子女
		E temp = heapArray[i];
		while( j<currSize ) {
			if ( (j<currSize-1) && (heapArray[j].compareTo(heapArray[j+1])>0) )
				j++;
			if ( temp.compareTo(heapArray[j])>0 ) {
				heapArray[i] = heapArray[j];
				i = j;
				j = leftChild(j);
			}
			else
				break;
		}
		heapArray[i] = temp;
	}
	
	/**
	 * 插入新元素
	 * @param newNode
	 * @return
	 */
	public boolean insert(E newNode) {
		if (currSize==maxSize)
			return false;
		heapArray[currSize] = newNode;
		siftUp(currSize);
		currSize++;
		return true;
	}
	
	/**
	 * 删除堆顶元素
	 * @return
	 */
	public E removeMin() {
		if (currSize==0)
			return null;
		else
		{
			swap(heapArray,0, --currSize);
			if (currSize>1)
				siftDown(0);
			return heapArray[currSize];
		}
	}
	
	/**
	 * 删除指定位置元素
	 * @param pos
	 * @return
	 */
	public E remove(int pos) {
		if (pos<0 || pos>currSize)
			return null;
		E temp = heapArray[pos];
		heapArray[pos] = heapArray[--currSize];
		siftUp(pos);
		siftDown(pos);
		return temp;
		
	}
	
	public void printHeap() {
		if (currSize<=0)
			return;
		
		int x=1;
		while(x<currSize)
			x *= 2;
		x /= 4;
		
		StringBuffer sb = new StringBuffer();
		int token = 1;
		int j=0;
		for(int i=0; i<currSize; i++)
		{
			if (j==0)
			for(int k=x; k>0; k--)
				sb.append(" ");			
			j++;				
			sb.append( heapArray[i].toString() + " " );
			if (j == token)
			{			
				sb.append("\n");
				j=0;
				token *= 2;
				x--;
			}
		}
		sb.append("\n");
		System.out.print(sb.toString());
	}
	
	public boolean isEmpty() {
		return currSize<=0 ? true : false;
	}
}
