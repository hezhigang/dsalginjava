/**
 * Sep 16, 2007 7:29:34 PM
 和志刚
 */
package com.codeguru.util;

/**
 * @author 和志刚
 * 父指针表示法的树
 */
public class ParTree<E> {
	private ParTreeNode<E> array[];
	private int size;
	
    /**
	 * @param size
	 */
	public ParTree(final int size) {
		super();
		this.size = size;
		//如果用 array = (ParTreeNode<E>[]) new Object[size] 报类型转换错误
		array =  new ParTreeNode[size];
		for(int i=0; i<size; i++)
			array[i] = new ParTreeNode<E>();
	}

	//查找根结点
	public ParTreeNode<E> find(ParTreeNode<E> node) {
		ParTreeNode<E> p = node;
		while(p.getParent()!=null)
			p = p.getParent();
		return p;
	}
	
	/**
	 * path compression方式
	 * 递归过程
	 * @param node
	 * @return
	 */
	public ParTreeNode<E> findPC(ParTreeNode<E> node) {
		if (node.getParent()==null) return node;
		node.setParent( findPC(node.getParent()) );
		return node.getParent();
	}
	
	//合并子树
	public void union(int i, int j) {
		ParTreeNode<E> pointeri = findPC(array[i]);
		ParTreeNode<E> pointerj = findPC(array[j]);
		if ( pointeri != pointerj ) {
			if (pointeri.getNCount()>pointerj.getNCount()) {
				pointerj.setParent(pointeri);
				pointeri.setNCount(pointeri.getNCount()+pointerj.getNCount());
			}
			else {
				pointeri.setParent(pointerj);
				pointerj.setNCount(pointeri.getNCount()+pointerj.getNCount());				
			}
		}
	}
	
	//比较子树是否同根
	public boolean different(int i, int j) {
		ParTreeNode<E> pointeri = findPC(array[i]);
		ParTreeNode<E> pointerj = findPC(array[j]);
		return (pointeri!=pointerj);
	}
	
	
	
}
