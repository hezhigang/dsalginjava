/**
 * May 31, 2007 3:51:14 PM
 和志刚
 */
package com.codeguru;

/**
 * @author 和志刚
 * 二叉树结点类
 */
public class BinaryTreeNode<E> {

	private E element;

	private BinaryTreeNode<E> left;

	private BinaryTreeNode<E> right;

	public BinaryTreeNode() {
	}

	/**
	 * @param element
	 */
	public BinaryTreeNode(E element) {
		super();
		this.element = element;
	}

	public BinaryTreeNode(E element, BinaryTreeNode<E> l, BinaryTreeNode<E> r) {
		this.element = element;
		this.left = l;
		this.right = r;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public boolean isLeaf() {
		return left==null && right==null ? true : false;
	}

	public BinaryTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNode<E> right) {
		this.right = right;
	}

	public BinaryTreeNode<E> getRight() {
		return right;
	}

}
