/**
 * Sep 9, 2007 9:09:31 PM
 和志刚
 */
package com.codeguru.util;

/**
 * @author 和志刚
 * 链表
 */
public class LList<E> {
	private Link<E> head;
	private Link<E> tail;
	
	/**
	 * 
	 */
	public LList() {
		super();
		head = new Link<E>();
		tail = head;
	}
	
	/**
	 * 查找第i个结点
	 * @param i
	 * @return
	 */
	public Link<E> findIndex(final int i) {
		if (i==-1) return head;
		Link<E> p = head.next;
		int j = 0;
		while(p!=null && j<i)
		{
			p = p.next;
			j++;
		}
		return p;
	}
	
	/**
	 * 插入为第i个结点
	 * @param value
	 * @param i
	 * @return
	 */
	public Link<E> insert(E value, int i) {
		Link<E> p,q;
		q = new Link<E>(value);
		p = findIndex(i-1);
		if (p==null) return null;
		q.next = p.next;
		p.next = q;
		if (q.next==null) tail = q;
		return q;
	}
	
	/**
	 * 删除link指定的结点
	 * @param link
	 */
	public void removeAfter(Link<E> link) {
		Link<E> temp = link.next;
		if (temp != null)
			link.next = temp.next;
	}
	
	/**
	 * 求长度
	 * @return
	 */
	public int length() {
		Link<E> p = head.next;
		int count = 0;
		while(p!=null) {
			p = p.next;
			count++;
		}
		return count;
	}

	public boolean isEmpty() {
		return head==null;
	}
	
	public void insertFirst(E data) {
		Link<E> node = new Link<E>(data);
		node.next = head;
		head = node;
	}
	
	public Link<E> deleteFirst() {
		Link<E> temp = head;
		head = head.next;
		return temp;
	}
}
