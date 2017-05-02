/**
 * 2007-12-21 下午08:24:30
 * 和志刚
 */
package com.codeguru.tree;

import java.util.Stack;

import org.apache.log4j.Logger;

import com.codeguru.Queue;

public class AVLTree<E extends Comparable<E>> {
	private static Logger logger = Logger.getLogger(AVLTree.class);

	public AVLNode<E> root;

	public AVLTree() {
		super();
	}

	public void add(E value) {
		if (root == null)
			root = new AVLNode<E>(value);
		else
			root.add(this, root, value);
		// logger.info(root.getElement());
	}

	public void preOrder(AVLNode<E> rt) {
		if (rt != null) {
			logger.info(rt.getElement());
			preOrder(rt.getLeft());
			preOrder(rt.getRight());
		}
	}

	/**
	 * 广度优先周游
	 * 
	 * @param rt
	 */
	public void levelTraversal(AVLNode<E> rt) {
		if (rt == null)
			return;
		AVLNode<E> ptr = null;
		Queue<AVLNode> queue = new Queue<AVLNode>();
		queue.enQueue(rt);
		while (!queue.isEmpty()) {
			ptr = queue.getFirst();
			queue.deQueue();
			System.out.print(ptr.getElement() + " ");
			if (ptr.getLeft() != null)
				queue.enQueue(ptr.getLeft());
			if (ptr.getRight() != null)
				queue.enQueue(ptr.getRight());
		}
		System.out.println();
	}

	private void printNodeMsg(int level, AVLNode<E> node) {
		while (level > 0) {
			System.out.print(".");
			level--;
		}
		System.out.print(node.getElement());
		System.out.print("\n");
	}

	private AVLNode<E> getParent(AVLNode<E> rt, AVLNode<E> current) {
		AVLNode<E> temp;
		if (rt == null)
			return null;
		if (rt.getLeft() == current || rt.getRight() == current)
			return rt;
		if ((temp = getParent(rt.getLeft(), current)) != null)
			return temp;
		else
			return getParent(rt.getRight(), current);
	}

	/**
	 * 返回父结点
	 * 
	 * @param current
	 * @return
	 */
	public AVLNode<E> parent(AVLNode<E> current) {
		if ((current == null) || (current == root))
			return null;
		return getParent(root, current);
	}

	/**
	 * 缩进字符图示
	 * 
	 * @param rt
	 */
	public void indent(AVLNode<E> rt) {
		if (rt == null)
			return;
		AVLNode<E> ptr = rt;
		AVLNode<E> tmpNode = null;
		int level = 0;
		Stack stk = new Stack();
		while (!stk.isEmpty() || ptr != null) {
			if (ptr != null) {
				tmpNode = ptr;
				level = 0;
				while (tmpNode != null) {
					tmpNode = this.parent(tmpNode);
					level++;
				}

				printNodeMsg(--level, ptr);
				stk.push(ptr);
				ptr = ptr.getLeft();
			} else {
				ptr = (AVLNode<E>) stk.peek();
				ptr = ptr.getRight();
				stk.pop();
			}

		}
	}

	public AVLNode<E> getRoot() {
		return root;
	}

	public void setRoot(AVLNode<E> root) {
		this.root = root;
	}
}
