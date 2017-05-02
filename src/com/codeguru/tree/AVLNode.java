/**
 * 2007-12-21 下午08:21:37
 * 和志刚
 */
package com.codeguru.tree;

import org.apache.log4j.Logger;

public class AVLNode<E extends Comparable<E>> {
	private static final Logger logger = Logger.getLogger(AVLNode.class);

	private int bf; // balance factor
	private E element;
	private AVLNode<E> left;
	private AVLNode<E> right;

	/**
	 * LL型单旋转
	 * 
	 * @param T
	 * @param p
	 * @return
	 */
	private AVLNode<E> LL_singleRotation(final AVLTree<E> T, final AVLNode<E> p) {
		logger.info("LL型单旋转>>>p.element="+p.element+";this.element="+this.element);
		boolean rootChanged = false;
		AVLNode<E> b;
		b = p.left;
		if (p == T.root) rootChanged = true;
		p.setLeft(b.right);
		p.bf = 0;
		b.setRight(p);
		// 删除导致的旋转
		if (b.bf == 0)
			b.bf = 1;
		else
			b.bf = 0;
		logger.info("LL型单旋转:::" + b.element + " 根为:::" + T.root.element);
		if (rootChanged)
			T.root = b;
		return b;
	}

	/**
	 * LR型双旋转
	 * 
	 * @return
	 */
	private AVLNode<E> LR_doubleRotation(final AVLTree<E> T, final AVLNode<E> p) {
		logger.info("LR型双旋转>>>p.element="+p.element+";this.element="+this.element);
		boolean rootChanged = false;
		AVLNode<E> b, c;
		b = p.left;
		c = b.right;
		if (p == T.root)
			rootChanged = true;
		// 第1次旋转
		b.setRight(c.left);
		c.setLeft(b);
		p.bf = b.bf = 0;
		// 根据原来c的左子树的高度来判断当前b的平衡情况
		if (c.bf == -1)
			p.bf = 1;
		if (c.bf == 1)
			b.bf = -1;
		// 第2次旋转
		p.setLeft(c.right);
		c.setRight(p);
		c.bf = 0;
		logger.info("LR型双旋转:::" + c.element + " 根为:::" + T.root.element);
		if (rootChanged)
			T.root = c;
		return c;
	}

	/**
	 * RR型单旋转
	 * 
	 * @return
	 */
	private AVLNode<E> RR_singleRotation(final AVLTree<E> T, final AVLNode<E> p) {
		logger.info("RR型单旋转>>>p.element="+p.element+";this.element="+this.element);
		boolean rootChanged = false;
		AVLNode<E> b;
		b = p.right;
		if (p == T.root)
			rootChanged = true;
		p.setRight(b.left);
		p.bf = 0;
		b.setLeft(p);
		// 如果是删除导致的旋转，则需要调整bf
		if (b.bf == 0)
			b.bf = -1;
		else
			b.bf = 0;
		logger.info("RR型单旋转:::" + b.element + " 根为:::" + T.root.element);
		if (rootChanged)
			T.root = b;
		return b;
	}

	/**
	 * RL型双旋转
	 * 
	 * @return
	 */
	private AVLNode<E> RL_doubleRotation(final AVLTree<E> T, final AVLNode<E> p) {
		logger.info("RL型双旋转>>>p.element="+p.element+";this.element="+this.element);
		boolean rootChanged = false;
		AVLNode<E> b, c;
		b = p.right;
		c = b.left;
		if (p == T.root)
			rootChanged = true;

		b.left = c.right;
		c.right = b;
		switch (c.bf) {
		case -1:
			p.bf = 0;
			b.bf = 1; // insert to c's left
			break;
		case 1:
			p.bf = -1;
			b.bf = 0; // insert to c's right
			break;
		case 0:
			p.bf = b.bf = 0;
			break;
		}
		p.right = c.left;
		c.left = p;
		c.bf = 0;
		logger.info("RL型双旋转:::" + c.element + " 根为:::" + T.root.element);
		if (rootChanged)
			T.root = c;
		return c;
	}

	/**
	 * 插入
	 * 
	 * @param T
	 * @param rp
	 * @param val
	 * @return 表明以当前结点为根的树是否在插入之后增高,0: 没有增高；1: 增高
	 */
	public int add(AVLTree<E> T, AVLNode<E> rp, E val) {
		if (val.compareTo(rp.element) < 0) {
			if (rp.left == null)
				rp.setLeft(new AVLNode<E>(val));
			else if (rp.left.add(T, rp.left, val) == 0)
				return 0;
			if (rp.bf == -1) {
				if (rp.left.bf < 0)
					rp = LL_singleRotation(T, T.parent(rp));
				else
					rp = LR_doubleRotation(T, T.parent(rp));
				logger.info(rp.element);
				return 0;
			}
			logger.info(rp.element);
			return --rp.bf;
		} else {
			if (rp.right == null)
				rp.setRight(new AVLNode<E>(val));
			else if (rp.right.add(T, rp.right, val) == 0)
				return 0;
			if (rp.bf == 1) {
				logger.info("before:::" + rp.element);
				if (rp.right.bf > 0)
					rp = RR_singleRotation(T, T.parent(rp));
				else
					rp = RL_doubleRotation(T, T.parent(rp));
				logger.info(rp.element);
				return 0;
			}
			logger.info(rp.element);
			return ++rp.bf;
		}
	}

	public E getElement() {
		return element;
	}

	public AVLNode(int bf, E element, AVLNode<E> left, AVLNode<E> right) {
		super();
		this.bf = bf;
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public AVLNode(E element) {
		super();
		this.element = element;
		this.left = null;
		this.right = null;
		this.bf = 0;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public AVLNode<E> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<E> left) {
		this.left = left;
	}

	public AVLNode<E> getRight() {
		return right;
	}

	public void setRight(AVLNode<E> right) {
		this.right = right;
	}
}
