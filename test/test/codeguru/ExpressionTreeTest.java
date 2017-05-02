package test.codeguru;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.BinaryTree;
import com.codeguru.ExpressionTree;

public class ExpressionTreeTest extends TestCase {
	private static Logger logger = Logger.getLogger(ExpressionTreeTest.class);
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExpressionTree() {
		ExpressionTree exprTree = new ExpressionTree(null);
//		BinaryTree tree = exprTree.buildExpressionTree(null, "((a*b-c)/d-e+f*g)*h+i-j/k");
//		BinaryTree tree = exprTree.buildExpressionTree(null, "a*b*(c+d)-e");
		BinaryTree tree = exprTree.buildExpressionTree(null, "a+b*c+(d*e+f)*g");
//		BinaryTree tree = exprTree.buildExpressionTree(null, "(a+b)*(c*(d+e))");
		exprTree.setRoot(tree.getRoot());
		exprTree.indent( exprTree.getRoot() );
		logger.info("先序遍历: ++a*bc*+*defg");
		logger.info("先序遍历(递归方式):");
		exprTree.preOrder(tree.getRoot());
		System.out.print("\n");
		logger.info("先序遍历(非递归方式):");
		exprTree.preOrderWithoutRecursion(tree.getRoot());
		System.out.print("\n");
		logger.info("先序遍历(通用非递归方式):");
		exprTree.preOrderWithoutRecursionByGeneral(tree.getRoot());
		System.out.print("\n");		
		logger.info("中序遍历: a+b*c+(d*e+f)*g");
		logger.info("中序遍历(递归方式):");
		exprTree.inOrder(tree.getRoot());
		System.out.print("\n");
//		logger.info("中序遍历(非递归方式):");
//		exprTree.inOrderWithoutRecursion(tree.getRoot());
//		System.out.print("\n");
		
		exprTree.inOrderWithoutRecursion(exprTree.getRoot());
		exprTree.inOrderforBracket(exprTree.getRoot());
		logger.info("中序遍历(加括号):" + exprTree.bf.toString());
		
		logger.info("中序遍历(通用非递归方式):");
		exprTree.inOrderWithoutRecursionByGeneral(tree.getRoot());
		System.out.print("\n");		
		logger.info("后序遍历: abc*+de*f+g*+");
		logger.info("后序遍历(递归方式):");
		exprTree.postOrder(tree.getRoot());
		System.out.print("\n");
		logger.info("后序遍历(非递归方式):");
		exprTree.postOrderWithoutRecursion(tree.getRoot());
		
		System.out.print("\n");
		logger.info("广度优先周游:");
		exprTree.levelTraversal(tree.getRoot());
	}

}
