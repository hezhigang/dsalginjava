/**
 * Jul 24, 2007 9:05:02 PM
 和志刚
 */
package com.codeguru.graph;

/**
 * @author 和志刚
 * 边表的链表
 */
public class LList<E> {
	private Link<E> head;  //头指针

	/**
	 * 
	 */
	public LList() {
		super();
		head = new Link<E>(null);
	}

	/**
	 * @return the head
	 */
	public Link<E> getHead() {
		return head;
	}
}
