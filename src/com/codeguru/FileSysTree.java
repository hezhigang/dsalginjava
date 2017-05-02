/**
 * Jun 24, 2007 3:37:59 PM
 和志刚
 */
package com.codeguru;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 * 树形文件目录
 */
public class FileSysTree<E> extends Tree<E> {
	private static Logger logger = Logger.getLogger(FileSysTree.class);

	/**
	 * 用目录信息构建树
	 * @param pNode
	 * @param dir
	 */
	public void build(TreeNode<E> pNode, File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            TreeNode<E> preNode = null;
            File subdir = null;
            FCBEntry entry =null;
            TreeNode<E> treeNode = null;
            for (int i=0; i<children.length; i++) {
        		subdir = new File(dir, children[i]);
        		entry = new FCBEntry(subdir.getName(), subdir.length());
        		treeNode = new TreeNode(entry);
        		if (i==0)
        			pNode.setFirstChild(treeNode);
        		if (i>0)
        			preNode.setNextSibling(treeNode);
        		build(treeNode, subdir);
        		preNode = treeNode;
            }
        }		
	}
	
	/**
	 * 计算目录大小
	 * @param root
	 */
	public long sizeDirectory(TreeNode<E> node) {
		long totalSize = 0L;
		if (node != null) {
			FCBEntry e = (FCBEntry) node.getElement();
			totalSize = e.getSize();
			if (!node.isLeaf()) {
				TreeNode<E> tmpNode = node.getFirstChild();
				while (null != tmpNode) {
					totalSize += sizeDirectory(tmpNode);
					tmpNode = tmpNode.getNextSibling();
				}
			}
		}
		return totalSize;
	}	
	
    // Process all files and directories under dir
    public static void visitAllDirsAndFiles(File dir) {
        logger.info(dir.getName());
    
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                visitAllDirsAndFiles(new File(dir, children[i]));
            }
        }
    }
	
	/**
	 * 
	 */
	public FileSysTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	void visit(int level, TreeNode<E> node) {
		// TODO Auto-generated method stub
		while(level>0)
		{
			System.out.print('\t');
			level--;
		}		
		FCBEntry e = (FCBEntry) node.getElement();
		logger.info(e.getName() + " " + sizeDirectory(node));
	}

	@Override
	void visit(TreeNode<E> node) {
		// TODO Auto-generated method stub
		FCBEntry e = (FCBEntry) node.getElement();
		logger.info(e.getName());		
	}
}
