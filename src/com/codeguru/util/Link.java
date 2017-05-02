/**
 * Sep 9, 2007 9:10:43 PM
 和志刚
 */
package com.codeguru.util;

/**
 * @author 和志刚
 * 链表结点
 */
public class Link<E> {
	public E element;
	public Link<E> next;
	/**
	 * 
	 */
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param element
	 */
	public Link(E element) {
		super();
		this.element = element;
	}

	/**
	 * @param element
	 * @param next
	 */
	public Link(E element, Link<E> next) {
		super();
		this.element = element;
		this.next = next;
	}
	
	public Link(Link<E> nextval) {
		super();
		this.next = nextval;
	}
}
