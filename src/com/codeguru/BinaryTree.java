/**
 * May 8, 2007 4:09:11 PM
 和志刚
 */
package com.codeguru;

import java.util.Stack;

/**
 * @author 和志刚 二叉树
 */
public class BinaryTree<E> {
//	private static Logger logger = Logger.getLogger(BinaryTree.class);

	private BinaryTreeNode<E> root = null;

	/**
	 * 
	 */
	public BinaryTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param root
	 */
	public BinaryTree(BinaryTreeNode<E> root) {
		super();
		this.root = root;
	}

	public BinaryTree(E elem, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		super();
		createTree(elem, leftTree, rightTree);
	}

	 private BinaryTreeNode<E> getParent(BinaryTreeNode<E> rt, BinaryTreeNode<E> current) {
		BinaryTreeNode<E> temp;
		if (rt == null) return null;
		if (rt.getLeft() == current || rt.getRight() == current) return rt;
		if ( (temp=getParent(rt.getLeft(),current))!=null )
			return temp;
		else
			return getParent(rt.getRight(), current);
	}
	 
	 /**
	  * 返回父结点
	  * @param current
	  * @return
	  */
	 public BinaryTreeNode<E> parent(BinaryTreeNode<E> current) {
		 if ( (current==null) || (current==root) )
			 return null;
		 return getParent(root, current);
	 }

	public boolean isEmpty() {
		return root == null ? true : false;
	}

	public BinaryTreeNode<E> getRoot() {
		return root;
	}
	
	/**
	 * 返回左兄弟
	 * @param current
	 * @return
	 */
	public BinaryTreeNode<E> leftSibling(BinaryTreeNode<E> current) {
		if (current!=null) {
			BinaryTreeNode<E> temp = parent(current);
			if ( (temp==null) || (current==temp.getLeft()) )
				return null;
			else
				return temp.getLeft();
		}
		return null;
	}
	
	/**
	 * 返回右兄弟
	 * @param current
	 * @return
	 */
	public BinaryTreeNode<E> rightSibling(BinaryTreeNode<E> current) {
		if (current!=null) {
			BinaryTreeNode<E> temp = parent(current);
			if ( (temp==null) || (current==temp.getRight()) )
				return null;
			else
				return temp.getRight();
		}		
		return null;
	}

	public void createTree(E elem, BinaryTree<E> leftTree,
			BinaryTree<E> rightTree) {
		root = new BinaryTreeNode<E>(elem, leftTree.root, rightTree.root);
		leftTree.root = rightTree.root = null;
	}

	private void visit(BinaryTreeNode<E> node) {
		System.out.print(node.getElement() + " ");
//		logger.info(node.getElement());
	}

	/**
	 * 前序周游(递归方式)
	 * 
	 * @param rt
	 */
	public void preOrder(BinaryTreeNode<E> rt) {
		if (rt != null) {
			visit(rt);
			preOrder(rt.getLeft());
			preOrder(rt.getRight());
		}
	}

	/**
	 * 中序周游(递归方式)
	 * 
	 * @param rt
	 */
	public void inOrder(BinaryTreeNode<E> rt) {
		if (rt != null) {
			inOrder(rt.getLeft());
			visit(rt);
			inOrder(rt.getRight());
		}
	}

	/**
	 * 后序周游(递归方式)
	 * 
	 * @param rt
	 */
	public void postOrder(BinaryTreeNode<E> rt) {
		if (rt != null) {
			postOrder(rt.getLeft());
			postOrder(rt.getRight());
			visit(rt);
		}
	}
	
	/**
	 * 先序周游(非递归)
	 * @param rt
	 */
	public void preOrderWithoutRecursion(BinaryTreeNode<E> rt) {
		if (rt==null) return;
		BinaryTreeNode<E> ptr = rt;
		Stack stk = new Stack();
		while(!stk.isEmpty() || ptr != null) {
			if (ptr!=null) {
				visit(ptr);
				stk.push(ptr);
				ptr = ptr.getLeft();
			}
			else {
				ptr = (BinaryTreeNode<E>) stk.peek();
				ptr = ptr.getRight();
				stk.pop();
			}
			
		}
	}
	
	/**
	 * 先序周游(非递归)-通用方式
	 * @param rt
	 */
	public void preOrderWithoutRecursionByGeneral(BinaryTreeNode<E> rt) {
		if (rt==null) return;
		StackElement element = null;
		BinaryTreeNode<E> ptr = rt;
		Stack stk = new Stack();
		while(true) {
			while(ptr!=null) {
				visit(ptr);
				element = new StackElement();
				element.setTreenode(ptr);
				element.setTag("Left");
				stk.push(element);
				ptr = ptr.getLeft();
			}
			element = (StackElement) stk.peek();
			stk.pop();
			ptr = element.getTreenode();
			while( element.getTag().equalsIgnoreCase("Right") ) {
				if (stk.isEmpty())
					return;
				else {
					element = (StackElement) stk.peek();
					stk.pop();
					ptr = element.getTreenode();
				}
			}
			element.setTag("Right");
			stk.push(element);
			ptr = ptr.getRight();
		}
	}	
	
	/**
	 * 中序周游(非递归)
	 * @param rt
	 */
	public void inOrderWithoutRecursion(BinaryTreeNode<E> rt) {
		if (rt==null) return;
		BinaryTreeNode<E> ptr = rt;
		Stack stk = new Stack();
		while(!stk.isEmpty() || ptr != null) {
			if (ptr!=null) {
				stk.push(ptr);
				ptr = ptr.getLeft();
			}
			else {
				ptr = (BinaryTreeNode<E>) stk.peek();
				visit(ptr);
				ptr = ptr.getRight();
				stk.pop();
			}
		}
	}
	
	/**
	 * 中序周游(非递归)-通用方式
	 * @param rt
	 */
	public void inOrderWithoutRecursionByGeneral(BinaryTreeNode<E> rt) {
		if (rt==null) return;
		StackElement element = null;
		BinaryTreeNode<E> ptr = rt;
		Stack stk = new Stack();
		while(true) {
			while(ptr!=null) {
				element = new StackElement();
				element.setTreenode(ptr);
				element.setTag("Left");
				stk.push(element);
				ptr = ptr.getLeft();
			}
			element = (StackElement) stk.peek();
			stk.pop();
			ptr = element.getTreenode();
			while( element.getTag().equalsIgnoreCase("Right") ) {
				if (stk.isEmpty())
					return;
				else {
					element = (StackElement) stk.peek();
					stk.pop();
					ptr = element.getTreenode();
				}
			}
			visit(ptr);
			element.setTag("Right");
			stk.push(element);
			ptr = ptr.getRight();
		}
	}	
	
	/**
	 * 后序周游(非递归)
	 * @param rt
	 */
	public void postOrderWithoutRecursion(BinaryTreeNode<E> rt) {
		if (rt==null) return;
		StackElement element = null;
		BinaryTreeNode<E> ptr = rt;
		Stack stk = new Stack();
		while(true) {
			while(ptr!=null) {
				element = new StackElement();
				element.setTreenode(ptr);
				element.setTag("Left");
				stk.push(element);
				ptr = ptr.getLeft();
			}
			element = (StackElement) stk.peek();
			stk.pop();
			ptr = element.getTreenode();
			while( element.getTag().equalsIgnoreCase("Right") ) {
				visit(ptr);				
				if (stk.isEmpty())
					return;
				else {
					element = (StackElement) stk.peek();
					stk.pop();
					ptr = element.getTreenode();
				}
			}
			element.setTag("Right");
			stk.push(element);
			ptr = ptr.getRight();
		}
	}	
	
	/**
	 * 广度优先周游
	 * @param rt
	 */
	public void levelTraversal(BinaryTreeNode<E> rt) {
		if (rt == null) return;
		BinaryTreeNode<E> ptr = null;
		Queue<BinaryTreeNode> queue = new Queue<BinaryTreeNode>();
		queue.enQueue(rt);
		while (!queue.isEmpty()) {
			ptr = queue.getFirst();
			queue.deQueue();
			visit(ptr);
			if (ptr.getLeft() != null)
				queue.enQueue(ptr.getLeft());
			if (ptr.getRight() != null)
				queue.enQueue(ptr.getRight());
		}
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BinaryTreeNode<E> root) {
		this.root = root;
	}
	
	private void printNodeMsg(int level, BinaryTreeNode<E> node) {
		while(level>0)
		{
			System.out.print(".");
			level--;
		}
		System.out.print(node.getElement());
		System.out.print("\n");
	}
	
	/**
	 * 缩进字符图示
	 * @param rt
	 */
	public void indent(BinaryTreeNode<E> rt) {
		if (rt==null) return;
		BinaryTreeNode<E> ptr = rt;
		BinaryTreeNode<E> tmpNode = null;
		int level = 0;
		Stack stk = new Stack();
		while(!stk.isEmpty() || ptr != null) {
			if (ptr!=null) {
				tmpNode = ptr;
				level = 0;
				while(tmpNode!=null)
				{
					tmpNode = this.parent(tmpNode);
					level++;
				}
					
				printNodeMsg(--level, ptr);
				stk.push(ptr);
				ptr = ptr.getLeft();
			}
			else {
				ptr = (BinaryTreeNode<E>) stk.peek();
				ptr = ptr.getRight();
				stk.pop();
			}
			
		}
	}
	
}

/**
 * 用于非递归后序遍历二叉树
 * @author 和志刚
 *
 */
final class StackElement {
	private BinaryTreeNode treenode = null;
	private String tag;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public BinaryTreeNode getTreenode() {
		return treenode;
	}
	public void setTreenode(BinaryTreeNode treenode) {
		this.treenode = treenode;
	}
	/**
	 * 
	 */
	public StackElement() {
		super();
	}
	
}
