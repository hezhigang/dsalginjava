/**
 * Apr 26, 2007 8:48:29 PM
 和志刚
 */
package com.codeguru;


/**
 * @author 和志刚
 * 
 */
public class Queue<E> {
	private int MAXSIZE = 50;  //折磨人的Bug
	
	private int front=0, rear=0, size=0;
	
	private E[] arr;

	/**
	 * @param maxsize
	 * @param size
	 */
	public Queue(int maxsize) {
		super();
		MAXSIZE = maxsize;
		this.arr = (E[]) new Object[MAXSIZE];
	}

	/**
	 */
	public Queue() {
		super();
		this.arr = (E[]) new Object[MAXSIZE];
	}

	public void enQueue(E e) {
		if (!this.isFull()) {
			size++;
			arr[rear] = e;
			rear = (rear+1)%MAXSIZE;
		}
		else
			System.out.println("队列已满，queue overflow");
	}
	
	public E deQueue() {
		E temp=null;
		if (!this.isEmpty()) {
			size--;
			temp = arr[front];
			front = (front+1)%MAXSIZE;
		}
		return temp;
	}
	
	public void makeEmpty() {
		front=0;
		rear=0;
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0 ? true : false;
	}
	
	public boolean isFull() {
		return size==MAXSIZE ? true : false;
	}
	
	public E getFirst() {
		return arr[front];
	}
}
