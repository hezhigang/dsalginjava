/**
 * Jun 24, 2007 2:30:46 PM
 和志刚
 */
package com.codeguru;

/**
 * @author 和志刚
 * 树结点
 */
public class TreeNode<E> {
	private E element;

	private TreeNode<E> firstChild;  //第一个子女

	private TreeNode<E> nextSibling; //右兄弟

	/**
	 * 
	 */
	public TreeNode() {
		super();
	}

	public boolean isLeaf() {
		return null==firstChild?true:false;
	}
	
	/**
	 * @param element
	 * @param firstChild
	 * @param nextSibling
	 */
	public TreeNode(E element, TreeNode<E> firstChild, TreeNode<E> nextSibling) {
		super();
		this.element = element;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}

	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the firstChild
	 */
	public TreeNode<E> getFirstChild() {
		return firstChild;
	}

	/**
	 * @param firstChild
	 *            the firstChild to set
	 */
	public void setFirstChild(TreeNode<E> firstChild) {
		this.firstChild = firstChild;
	}

	/**
	 * @return the nextSibling
	 */
	public TreeNode<E> getNextSibling() {
		return nextSibling;
	}

	/**
	 * @param nextSibling
	 *            the nextSibling to set
	 */
	public void setNextSibling(TreeNode<E> nextSibling) {
		this.nextSibling = nextSibling;
	}

	/**
	 * @param element
	 */
	public TreeNode(E element) {
		super();
		this.element = element;
	}
}
