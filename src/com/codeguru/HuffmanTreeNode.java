/**
 * Jun 15, 2007 7:58:21 PM
 和志刚
 */
package com.codeguru;

/**
 * @author 和志刚
 * 
 */
public class HuffmanTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E>
		implements Comparable<HuffmanTreeNode<E>> {
	private BinaryTreeNode<E> parent;

	/**
	 * @return the parent
	 */
	public BinaryTreeNode<E> getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(BinaryTreeNode<E> parent) {
		this.parent = parent;
	}

	public int compareTo(HuffmanTreeNode<E> o) {
		// TODO Auto-generated method stub
		return this.getElement().compareTo(o.getElement());
	}
}
