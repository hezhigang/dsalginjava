/**
 * Sep 16, 2007 7:24:37 PM
 和志刚
 */
package com.codeguru.util;

/**
 * @author 和志刚
 * 父指针表示的结点类
 */
public class ParTreeNode<E> {
	private E value;
	private ParTreeNode<E> parent;
	private int nCount;
	
	/**
	 * 
	 */
	public ParTreeNode() {
		super();
		parent = null;
		nCount = 1;
	}	
	
	/**
	 * @return the nCount
	 */
	public int getNCount() {
		return nCount;
	}
	/**
	 * @param count the nCount to set
	 */
	public void setNCount(int count) {
		nCount = count;
	}
	/**
	 * @return the parent
	 */
	public ParTreeNode<E> getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(ParTreeNode<E> parent) {
		this.parent = parent;
	}
	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}
}
