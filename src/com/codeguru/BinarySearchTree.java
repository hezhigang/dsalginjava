/**
 * May 29, 2007 10:42:54 PM
 和志刚
 */
package com.codeguru;


/**
 * @author 和志刚 二叉搜索树
 */
public class BinarySearchTree<E> extends BinaryTree {

//	private static Logger logger = Logger.getLogger(BinarySearchTree.class);

	/**
	 * 
	 */
	public BinarySearchTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 插入-整数
	 * @param root
	 * @param node
	 */
	public void insert(BinaryTreeNode<E> root, BinaryTreeNode<E> node) {
		BinaryTreeNode<E> pointer = null;
		if (root == null)
		{
			root = node;
			this.setRoot(root);
			return;
		}
		else
			pointer = root;
		while (true) {
			Integer iNode = (Integer) node.getElement();
			Integer iRoot = (Integer) pointer.getElement();
			if (iRoot == iNode)
				return;
			else if (iNode < iRoot) {
				if (pointer.getLeft() == null) {
					pointer.setLeft(node);
					return;
				} else
					pointer = pointer.getLeft();
			} else if (iNode > iRoot) {
				if (pointer.getRight() == null) {
					pointer.setRight(node);
					return;
				} else
					pointer = pointer.getRight();
			}
		}
	}
	
	
	
	/**
	 * 插入-针对字符串类型
	 * @param root
	 * @param node
	 */
	public void insert2(BinaryTreeNode<E> root, BinaryTreeNode<E> node) {
		BinaryTreeNode<E> pointer = null;
		if (root == null)
		{
			root = node;
			this.setRoot(root);
			return;
		}
		else
			pointer = root;
		while (true) {
			String sNode = (String) node.getElement();
			String key = (String) pointer.getElement();
			if ( key.equalsIgnoreCase(sNode) ) return;
			else if ( key.compareToIgnoreCase(sNode) > 0) {
				if (pointer.getLeft() == null) {
					pointer.setLeft(node);
					return;
				} else
					pointer = pointer.getLeft();
			} else if ( key.compareToIgnoreCase(sNode) < 0 ) {
				if (pointer.getRight() == null) {
					pointer.setRight(node);
					return;
				} else
					pointer = pointer.getRight();
			}
		}
	}
	
	/**
	 * 插入-递归方式-针对字符串类型
	 * @param root
	 * @param node
	 */
	public BinaryTreeNode<E> insertRecursion(BinaryTreeNode<E> root, BinaryTreeNode<E> node) {
		if (root == null) {
			root = node;
			this.setRoot(root);
		} 
		else {
			String sNode = (String) node.getElement();
			String key = (String) root.getElement();
			int flag = key.compareToIgnoreCase(sNode);
			if ( flag < 0 ) {
				if (root.getLeft() != null)
					root.setLeft(insertRecursion(root.getLeft(), node));
				else
					root.setLeft(node);
			}
			else if ( flag > 0 ) {
				if (root.getRight() != null)
					root.setRight(insertRecursion(root.getRight(), node));
				else
					root.setRight(node);
			}
		}
		return root;
	}	
	
	/**
	 * 查找-整数
	 * 
	 * @param key
	 * @param T
	 * @return
	 */
	public BinaryTreeNode<E> find(E key, BinaryTreeNode<E> T) {
		if (T == null)
			return null;
		Integer iKey = (Integer) key;
		Integer iRoot = (Integer) T.getElement();
		if (iKey.intValue() < iRoot.intValue())
			return find(key, T.getLeft());
		else if (iKey.intValue() < iRoot.intValue())
			return find(key, T.getRight());
		else
			return T;
	}
	
	/**
	 * 查找-字符串
	 * @param key
	 * @param T
	 * @return
	 */
	public BinaryTreeNode<E> find2(E key, BinaryTreeNode<E> T) {
		if (T == null)
			return null;
		String sKey = (String) key;
		String sRoot = (String) T.getElement();
		int flag = sKey.compareToIgnoreCase(sRoot);
		if (flag < 0)
			return find2(key, T.getLeft());
		else if (flag > 0)
			return find2(key, T.getRight());
		else
			return T;
	}
	
	/**
	 * 删除-字符串
	 * @param node
	 */
	public void delete2(BinaryTreeNode<E> node) {
		BinaryTreeNode<E> tmpptr=null, child=null;
		BinaryTreeNode<E> parent = this.parent(node);
		if (node.getLeft()==null)
			child = node.getRight();
		else {
			tmpptr = node.getLeft();
			while(tmpptr.getRight()!=null)
				tmpptr = tmpptr.getRight();
			child = tmpptr;
			child.setRight( node.getRight() );
		}
		if (null==parent)
			this.setRoot(child);
		else if (parent.getLeft()==node)
			parent.setLeft(child);
		else
			parent.setRight(child);
	}
	
	/**
	 * 删除-改进，不增加树的高度
	 * @param node
	 */
	public void delete2Ex(BinaryTreeNode<E> node) {
		BinaryTreeNode<E> tmpptr=null, child=null, tempParent=null;
		BinaryTreeNode<E> parent = this.parent(node);
		if (node.getLeft()==null)
			child = node.getRight();
		else {
			tmpptr = node.getLeft();
			while(tmpptr.getRight()!=null) {
				tempParent = tmpptr;
				tmpptr = tmpptr.getRight();
			}
			
			//删除替换节点
			if (null==tempParent)
				node.setLeft( tmpptr.getLeft() );
			else
				node.setRight( tmpptr.getLeft() );
			tmpptr.setLeft( node.getLeft() );
			tmpptr.setRight( node.getRight() );
			child = tmpptr;
		}
		//替换掉待删除节点
		if (null==parent)
			this.setRoot(child);
		else if (parent.getLeft()==node)
			parent.setLeft(child);
		else
			parent.setRight(child);
	}
	
}
