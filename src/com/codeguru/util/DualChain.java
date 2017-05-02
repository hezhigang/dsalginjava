/**
 * Sep 12, 2007 9:55:06 PM
 和志刚
 */
package com.codeguru.util;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 * 双向链表类
 */
public class DualChain<E extends Comparable<E>> {
	private static Logger logger = Logger.getLogger(DualChain.class);
	
	private DualChainNode<E> head=null;  //标识链表头
	private DualChainNode<E> tail=null;  //标识链表尾
	
	/**
	 * 
	 */
	public DualChain() {
		super();
		head = null;
		tail = null;		
	}
	
	public boolean isEmpty() {
		return head==null ? true : false;
	}
	
	/**
	 * 插入参数node指定的结点前
	 * @param x
	 * @param node
	 */
	public void insert(E x, DualChainNode<E> node) {
		DualChainNode<E> newNode = new DualChainNode<E>(x);
		if (node==null) {
			head = newNode;
			tail = newNode;
		} 
		else if (node.getPrev()==null)
		{
			newNode.setNext(node);
			//newNode.setPrev(null);
			head = newNode;
			node.setPrev(newNode);
		}
		else {
			newNode.setPrev(node.getPrev());
			node.getPrev().setNext(newNode);
			newNode.setNext(node);
			node.setPrev(newNode);
		}		
	}
	
	/**
	 * 插入参数node指定的结点后
	 * @param node
	 * @param x
	 */
	public void insert(DualChainNode<E> node, E x) {
		DualChainNode<E> newNode = new DualChainNode<E>(x);
		if (node==null) {
			head = newNode;
			tail = newNode;
		} 
		else if (node.getNext()==null)
		{
			newNode.setPrev(node);
			tail = newNode;
			node.setNext(newNode);
			//newNode.setNext(null);
		}
		else {
			newNode.setNext(node.getNext());
			node.getNext().setPrev(newNode);
			newNode.setPrev(node);
			node.setNext(newNode);
		}
	}
	
	/**
	 * 在链表末尾插入
	 * @param x
	 */
	public void append(E x) {
		insert(tail, x);
	}
	
	/**
	 * 在链表头部插入
	 * @param x
	 */
	public void insertAtTop(E x) {
		insert(x, head);
	}
	
	/**
	 * 删除指定值的结点
	 * @param x
	 */
	public void delete(E x) {
		DualChainNode<E> tempNode = search(x);
		if (tempNode==null) return;
		if (tempNode==tail)
		{
			if (tempNode.getPrev()!=null) {
				tempNode.getPrev().setNext(null);
				tail = tempNode.getPrev();
			}
			else
			{
				head = null;
				tail = null;
			}
		}
		else
		{
			if (tempNode.getPrev()!=null) {
				tempNode.getNext().setPrev(tempNode.getPrev());
				tempNode.getPrev().setNext(tempNode.getNext());				
			}
			else {
				tempNode.getNext().setPrev(null);
				head = tempNode.getNext();
			}
		}

	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public DualChainNode<E> search(E key) {
		DualChainNode<E> x = head;
		while(x!=null && x.getElement().compareTo(key)!=0)
			x = x.getNext();
		return x;
	}
	
	public void print() {
		if (!isEmpty()) {
			DualChainNode<E> ptr = head;
			while(ptr!=null) {
				logger.info(ptr.getElement());
				ptr = ptr.getNext();
			}
		}
		else 
			logger.info("linklist is empty");
	}

	/**
	 * @return the head
	 */
	public DualChainNode<E> getHead() {
		return head;
	}

	/**
	 * @return the tail
	 */
	public DualChainNode<E> getTail() {
		return tail;
	}	
}
