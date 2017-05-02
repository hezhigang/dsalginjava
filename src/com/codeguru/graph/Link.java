/**
 * Jul 24, 2007 8:59:55 PM
 和志刚
 */
package com.codeguru.graph;

/**
 * @author 和志刚
 * 链表的元素
 */
public class Link<E> {
	private E element;
	private Link<E> next;
	
	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}
	/**
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}
	/**
	 * @return the next
	 */
	public Link<E> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Link<E> next) {
		this.next = next;
	}
	/**
	 * @param next
	 */
	public Link(Link<E> next) {
		super();
		this.next = next;
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
}
