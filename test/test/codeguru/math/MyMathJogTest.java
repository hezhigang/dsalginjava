/**
 * Jun 16, 2007 10:05:54 PM
 和志刚
 */
package test.codeguru.math;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.math.MyMathJog;

/**
 * @author 和志刚
 *
 */
public class MyMathJogTest extends TestCase {
	private static Logger logger = Logger.getLogger(MyMathJogTest.class);
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.codeguru.math.MyMathJog#matrixmul(int[][], int[][], int, int, int)}.
	 */
	public void testMatrixmul() {
		int[][] A = {
				{1,2,1,0},
				{0,1,0,1},
				{0,0,2,1},
				{0,0,0,3}				
				};
		int[][] B = {
				{1,0,3,1},
				{0,1,2,-1},
				{0,0,-2,3},
				{0,0,0,-3}
				};
		int[][] C = MyMathJog.matrixmul(A,B,4,4,4);
//		int[][] A = {
//				{1,0,3,-1},
//				{2,1,0,2}
//				};
//		int[][] B = {
//				{4,1,0},
//				{-1,1,3},
//				{2,0,1},
//				{1,3,4}
//				};
//		int[][] C = MyMathJog.matrixmul(A,B,2,4,3);		
		MyMathJog.printMatrix(A);
		MyMathJog.printMatrix(B);
		MyMathJog.printMatrix(C);
	}
	
	public void testQuotientSetNum() {
		int num=0;
		for(int i=10; i>2; i--)
		{
			num = MyMathJog.quotientSetNum(i);
			logger.info(i + "元集上的不同的等价关系个数有: " + num);
		}
	}
}
