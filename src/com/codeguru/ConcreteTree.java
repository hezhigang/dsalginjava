/**
 * Jul 3, 2007 9:54:51 PM
 和志刚
 */
package com.codeguru;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 *
 */
public class ConcreteTree<E> extends Tree<E> {
	/**
	 * @param nodeArray
	 * @param count
	 * @param nothing
	 */
	public ConcreteTree(DualTagTreeNode<E>[] nodeArray, int count, int nothing) {
		super(nodeArray, count, nothing);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nodeArray
	 * @param count
	 */
	public ConcreteTree(DualTagTreeNode<E>[] nodeArray, int count) {
		super(nodeArray, count);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public ConcreteTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static Logger logger = Logger.getLogger(ConcreteTree.class);
	
	/* (non-Javadoc)
	 * @see com.codeguru.Tree#visit(int, com.codeguru.TreeNode)
	 */
	@Override
	void visit(int level, TreeNode node) {
		// TODO Auto-generated method stub
		while(level>0)
		{
			System.out.print('\t');
			level--;
		}		
		logger.info(node.getElement());
	}

	/* (non-Javadoc)
	 * @see com.codeguru.Tree#visit(com.codeguru.TreeNode)
	 */
	@Override
	void visit(TreeNode node) {
		// TODO Auto-generated method stub
		logger.info(node.getElement());
	}

}
