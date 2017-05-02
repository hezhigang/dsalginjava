/**
 * Jun 24, 2007 2:34:16 PM
 和志刚
 */
package com.codeguru;

import java.util.Stack;

/**
 * @author 和志刚
 * 树
 */
abstract class Tree<E> {
	private TreeNode<E> root = null;
	
	/**
	 * 创建根结点
	 * @param rootValue
	 */
	public void createRoot(E rootValue) {
		if (root == null)
			root = new TreeNode<E>(rootValue);
	}
	
	/**
	 * 返回前一个邻居结点
	 * @param current
	 * @return
	 */
	TreeNode<E> prevSibling(final TreeNode<E> current) {
		Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>();
		TreeNode<E> pointer = root;
		TreeNode<E> prev = null;
		if ( (current==null) || (pointer==null) || (current==pointer) )
			return null;
		queue.enQueue(pointer);
		while(!queue.isEmpty()) {
			prev = null;
			pointer = queue.deQueue();
			while(pointer!=null) {
				if (pointer==current)
					return prev;
				queue.enQueue(pointer);
				prev = pointer;
				pointer = pointer.getNextSibling();
			}
			pointer = pointer.getFirstChild();
		}
		return null;
	}
	
	/**
	 * 定位父结点的私有方法
	 * @param root
	 * @param current
	 * @return
	 */
	private TreeNode<E> getParent(final TreeNode<E> root, final TreeNode<E> current) {
		TreeNode<E> tmpNode = null;
		if (root==null || current==null || current==root)
			return null;
		if (root.getFirstChild()==current)
			return root;
		if ( (tmpNode=getParent(root.getFirstChild(),current)) != null )
			return tmpNode;
		else
			return getParent(root.getNextSibling(),current);
	}
	
	/**
	 * 指定结点的父结点
	 * @param current
	 * @return
	 */
	public TreeNode<E> parent(final TreeNode<E> current) {
		if (root == null || current == null || current == root)
			return null;
		TreeNode<E> leftMostSibling = current;
		while (leftMostSibling != null)
			leftMostSibling = prevSibling(leftMostSibling);
		if (leftMostSibling == root)
			return null;
		else
			return getParent(root, leftMostSibling);
	}
	
	abstract void visit(int level, TreeNode<E> node);
	abstract void visit(TreeNode<E> node);
	
	/**
	 * 先序周游
	 * @param root
	 */
	public void preOrderTraversal(int level, TreeNode<E> root) {
		level++;
		while (null != root) {
			visit(level, root);
			preOrderTraversal(level, root.getFirstChild());
			root = root.getNextSibling();
		}
	}

	/**
	 * 后序周游
	 * @param root
	 */
	public void postOrderTraversal(int level, TreeNode<E> root) {
		level++;
		while (null != root) {
			postOrderTraversal(level, root.getFirstChild());
			visit(level, root);
			root = root.getNextSibling();
		}
	}
	
	/**
	 * 层次周游: 广度优先周游1-有bug
	 * @param root
	 */
	public void levelTraversal(TreeNode<E> root) {
		if (root == null)
			return;
		Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>(512);
		TreeNode<E> ptr = root;
		queue.enQueue(ptr);
		while (!queue.isEmpty()) {
			ptr = queue.deQueue();
			visit(ptr);	
			if (ptr.getFirstChild() != null) {
				ptr = ptr.getFirstChild();
				queue.enQueue(ptr);
				while ((ptr = ptr.getNextSibling()) != null)
					queue.enQueue(ptr);
			}
		}
	}
	
	/**
	 * 广度优先周游2, 北大教材上的实现
	 * @param root
	 */
	public void levelTraversal2(TreeNode<E> root) {
		if (root == null)
			return;
		Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>();
		TreeNode<E> ptr = root;
		queue.enQueue(ptr);
		while (!queue.isEmpty()) {
			ptr = queue.getFirst();
			visit(ptr);
			while (ptr.getNextSibling()!=null) {
				if (ptr.getFirstChild()!=null)
					queue.enQueue(ptr.getFirstChild());
				ptr = ptr.getNextSibling();
				visit(ptr);
			}
			if (ptr.getFirstChild()!=null)
				queue.enQueue(ptr.getFirstChild());
			queue.deQueue();
		}
	}
	
	/**
	 * 广度优先周游3, 北大教学视频中推荐
	 * @param root
	 */
	public void levelTraversal3(TreeNode<E> root) {
		Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>(512);
		TreeNode<E> ptr = root;
		while (ptr!=null) {
			queue.enQueue(ptr);
			ptr = ptr.getNextSibling();
		}
		
		while(!queue.isEmpty()) {
			ptr = queue.deQueue();
			visit(ptr);
			
//			if (ptr.getFirstChild()!=null)  //不注释则死循环
				ptr = ptr.getFirstChild();
			while (ptr!=null) {
				queue.enQueue(ptr);
				ptr = ptr.getNextSibling();
			}
		}
	}	
	
	/**
	 * 带双标记的先根次序-构造函数
	 * @param nodeArray
	 * @param count
	 */
	public Tree(DualTagTreeNode<E> nodeArray[], final int count) {
		Stack<TreeNode<E>> stk = new Stack<TreeNode<E>>();
		TreeNode<E> pointer = new TreeNode<E>();
		root = pointer;
		for(int i=0; i<count-1; i++) {
			pointer.setElement(nodeArray[i].info);
			if (nodeArray[i].rtag==0)
				stk.push(pointer);
			else
				pointer.setNextSibling(null);
			TreeNode<E> tmpNode = new TreeNode<E>();
			if (nodeArray[i].ltag==0)
				pointer.setFirstChild(tmpNode);
			else {
				pointer.setFirstChild(null); //为什么要出现在下句之前？
				pointer = stk.pop();
				pointer.setNextSibling(tmpNode);
			}
			pointer = tmpNode;
		}
		pointer.setElement(nodeArray[count-1].info);
		pointer.setFirstChild(null);
		pointer.setNextSibling(null);
	}
	
	/**
	 * 带双标记的层次次序-构造函数
	 * @param nodeArray
	 * @param count
	 * @param nothing
	 */
	public Tree(DualTagTreeNode<E> nodeArray[], final int count, final int nothing) {
		Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>();
		TreeNode<E> pointer = new TreeNode<E>();
		root = pointer;
		int currentIndex = -1;
		while (pointer!=null || !queue.isEmpty()) {
			if (pointer!=null) {
				currentIndex++;
				pointer.setElement(nodeArray[currentIndex].info);
				if (nodeArray[currentIndex].ltag==0) {
					TreeNode<E> leftpointer = new TreeNode<E>();
					pointer.setFirstChild(leftpointer);
					queue.enQueue(leftpointer);
				}
				else
					pointer.setFirstChild(null);
				
				if (nodeArray[currentIndex].rtag==0) {
					TreeNode<E> rightpointer = new TreeNode<E>();
					pointer.setNextSibling(rightpointer);
				}
				else
					pointer.setNextSibling(null);
				
				pointer = pointer.getNextSibling();
			}
			else
				pointer = queue.deQueue();
		}
	}	

	/**
	 * @return the root
	 */
	public TreeNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}

	/**
	 * 
	 */
	public Tree() {
		super();
	}
}
