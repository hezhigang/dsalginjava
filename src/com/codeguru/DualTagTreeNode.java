/**
 * Jul 3, 2007 9:40:23 PM
 和志刚
 */
package com.codeguru;

/**
 * @author 和志刚
 *
 */
public class DualTagTreeNode<E> {
	public E info;
	public int ltag;
	public int rtag;
	/**
	 * @param ltag
	 * @param rtag
	 */
	public DualTagTreeNode() {
		super();
		this.ltag = 1;
		this.rtag = 1;
	}
	/**
	 * @param info
	 * @param ltag
	 * @param rtag
	 */
	public DualTagTreeNode(E info, int ltag, int rtag) {
		super();
		this.info = info;
		this.ltag = ltag;
		this.rtag = rtag;
	}
}
