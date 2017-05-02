/**
 * Jun 15, 2007 7:59:37 PM
 和志刚
 */
package com.codeguru;

import java.util.Stack;

/**
 * @author 和志刚
 * 哈夫曼树
 */
public class HuffmanTree<E extends Comparable<E>> {
	private HuffmanTreeNode<E> root;

	/**
	 * 构造方法
	 * @param weight
	 */
	public HuffmanTree(E[] weight) {
		super();
		int LEN = weight.length;
		HuffmanTreeNode<E> firstChild=null, secondChild=null, parent=null;
		MinHeap<E> heap = new MinHeap<E>(LEN);
		HuffmanTreeNode<E>[] arr = new HuffmanTreeNode[LEN];
		for(int i=0; i<LEN; i++) {
			arr[i] = new HuffmanTreeNode();
			arr[i].setElement(weight[i]);
			arr[i].setLeft(null);
			arr[i].setRight(null);
			arr[i].setParent(null);
			heap.insert((E) arr[i]);
		}
		
		for(int i=0; i<LEN-1; i++) {
			parent = new HuffmanTreeNode<E>();
			firstChild = (HuffmanTreeNode<E>) heap.removeMin();
			secondChild = (HuffmanTreeNode<E>) heap.removeMin();
			mergeTree(firstChild, secondChild, parent);
			heap.insert((E) parent);
			root = parent;
		}
	}
	
	/**
	 * 合并树
	 * @param ht1
	 * @param ht2
	 * @param parent
	 */
	public void mergeTree(HuffmanTreeNode<E> ht1, HuffmanTreeNode<E> ht2, HuffmanTreeNode<E> parent) {
		int w1 = ((Integer) ht1.getElement()).intValue();
		int w2 = ((Integer) ht2.getElement()).intValue();
		Integer w = new Integer(w1+w2);
		parent.setElement( (E)w );
		parent.setLeft(ht1);
		parent.setRight(ht2);
	}
	
	public void delTree(HuffmanTreeNode<E> rt) {
	}

	/**
	 * @return the root
	 */
	public HuffmanTreeNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(HuffmanTreeNode<E> root) {
		this.root = root;
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
	
	private void printNodeMsg(int level, BinaryTreeNode<E> node) {
		while(level>0)
		{
			System.out.print("·");
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
