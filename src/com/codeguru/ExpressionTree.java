/**
 * May 8, 2007 5:00:26 PM
 和志刚
 */
package com.codeguru;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

/**
 * @author 和志刚 表达式树
 */
public class ExpressionTree<E> extends BinaryTree {
	private static Logger logger = Logger.getLogger(ExpressionTree.class);
	public static StringBuffer bf = new StringBuffer();

	/**
	 * @param root
	 */
	public ExpressionTree(BinaryTreeNode<E> root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 从后缀表达式构造表达式树
	 * 
	 * @param root
	 * @param infix
	 * @return
	 */
	public BinaryTree<E> buildExpressionTree(BinaryTreeNode root, String infix) {
		String postfix = FixConverter.infix2postfix(infix);
		logger.info("postifx: " + postfix);
		Stack stk = new Stack();
		char[] arr = postfix.toCharArray();
		BinaryTreeNode<E> rt = null;
		BinaryTree<E> left = null, right = null;
		BinaryTree<E> tree = null;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			switch (c) {
			case '+':
			case '-':
			case '*':
			case '/': {
				right = (BinaryTree<E>) stk.pop();
				left = (BinaryTree<E>) stk.pop();
				tree = new BinaryTree(c, left, right);
				stk.push(tree);
			}
				break;
			default:
				rt = new BinaryTreeNode(c);
				tree = new BinaryTree(rt);
				stk.push(tree);
			}
		}
		return ((BinaryTree<E>) stk.pop());
	}

	/**
	 * 运算符优先级比较
	 * @param operator1
	 * @param operator2
	 * @return
	 */
	private int comparePriority(E operator1, E operator2) {
		int ret = 0;
		Set lows = new HashSet();
		lows.add('+');
		//lows.add("-");  //低级错误：导致找不到'-'
		lows.add('-');
		Set highs = new HashSet();
		highs.add('*');
		highs.add('/');
		if ((lows.contains(operator1) && lows.contains(operator2))
				|| (highs.contains(operator1) && highs.contains(operator2)))
			ret = 0;
		if ( lows.contains(operator1) && highs.contains(operator2) )
			ret = -1;
		if ( lows.contains(operator2) && highs.contains(operator1) )
			ret = 1;
		return ret;
	}
	
	/**
	 * infix加括号的处理方法
	 * @param node
	 */
	private void visitForBracket(BinaryTreeNode<E> node) {
		Set operators = new HashSet();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
		
		BinaryTreeNode<E> tmpNode = null;
		BinaryTreeNode<E> pNode = this.parent(node);
		if (pNode!=null && operators.contains(node.getElement())
				&& operators.contains(pNode.getElement())
				&& comparePriority(node.getElement(), pNode.getElement()) == -1) {
			tmpNode = node;
			while (tmpNode.getLeft()!=null)
				tmpNode = tmpNode.getLeft();
			Character c = (Character) tmpNode.getElement();
			int idx = bf.indexOf(c.toString());
			bf.insert(idx, '(');
			
			tmpNode = node;
			while (tmpNode.getRight()!=null)
				tmpNode = tmpNode.getRight();
			c = (Character) tmpNode.getElement();
			idx = bf.indexOf(c.toString());
			bf.insert(++idx, ')');			
		}
	}
	
	/**
	 * infix加括号的中序周游
	 * @param rt
	 */
	public void inOrderforBracket(BinaryTreeNode rt) {
		if (rt==null) return;
		BinaryTreeNode ptr = rt;
		Stack stk = new Stack();
		while(!stk.isEmpty() || ptr != null) {
			if (ptr!=null) {
				stk.push(ptr);
				ptr = ptr.getLeft();
			}
			else {
				ptr = (BinaryTreeNode) stk.peek();
				visitForBracket(ptr);
				ptr = ptr.getRight();
				stk.pop();
			}
		}		
	}

	private void visit(BinaryTreeNode<E> node) {
		bf.append(node.getElement());
	}	
	
	/* (non-Javadoc)
	 * @see com.codeguru.BinaryTree#inOrderWithoutRecursion(com.codeguru.BinaryTreeNode)
	 */
	@Override
	public void inOrderWithoutRecursion(BinaryTreeNode rt) {
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

}
