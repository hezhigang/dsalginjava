/**
 * Sep 12, 2007 9:51:44 PM
 和志刚
 */
package com.codeguru.util;

/**
 * @author 和志刚
 * 双向链表的结点类
 */
public class DualChainNode<E extends Comparable<E>> {
	private E element;
	private DualChainNode<E> prev=null; //前驱
	private DualChainNode<E> next=null; //后继
	
	/**
	 * @param element
	 */
	public DualChainNode(E element) {
		super();
		this.element = element;
	}

	/**
	 * 
	 */
	public DualChainNode() {
		super();
	}

	/**
	 * 
	 * @param element
	 * @param prev
	 * @param next
	 */
	public DualChainNode(E element, DualChainNode<E> prev, DualChainNode<E> next) {
		super();
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
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
	public DualChainNode<E> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(DualChainNode<E> next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public DualChainNode<E> getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(DualChainNode<E> prev) {
		this.prev = prev;
	}
}
