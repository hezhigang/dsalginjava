/**
 * Apr 24, 2007 5:24:58 PM
 和志刚
 */
package com.codeguru.math;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 * 
 */
public class MyMathJog {
	private static Logger logger = Logger.getLogger(MyMathJog.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int a, b;
		a = rand.nextInt(1000);
		b = 12;
		logger.info("gcd(" + a + "," + b + ")=" + gcd(a, b));
		long n = 7L;
		logger.info(n + "!=" + factorial(n));
		logger.info(n + "!=" + factorial_byCycle(n));
		
		StringBuffer sb = new StringBuffer();
		for (int i=1; i<10; i++) 
			sb.append(" " + fibonacci(i));
		logger.info("fibonacci series: " + sb.toString());		
		
		StringBuffer sb2 = new StringBuffer();
		for (int i=1; i<10; i++) 
			sb2.append(" " + fibonacci_dynaprog(i));
		logger.info("fibonacci series: " + sb2.toString());
	}

	/**
	 * 求最大公约数 Euclidean algorithm: Euclid的辗转相除法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b) {
		int r, x, y;
		x = Math.max(a, b);
		y = Math.min(a, b);
		do {
			r = x % y;
			x = y;
			y = r;
		} while (r != 0);
		return x;
	}
	
	/**
	 * 最小公倍数 least common multiplication 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int lcm(int a, int b) {
		return (a*b)/gcd(a,b);
	}

	/**
	 * 阶乘
	 * 
	 * @param n
	 * @return
	 */
	public static long factorial(long n) {
		if (n <= 0)
			return 1;
		else
			return n * factorial(n - 1);
		// if (n > 1)
		// return n * factorial(n - 1);
		// else
		// return 1;
	}

	/**
	 * 阶乘-用迭代实现
	 * 
	 * @param n
	 * @return
	 */
	public static long factorial_byCycle(long n) {
		long m = 1;
		for (; n > 0; n--) {
			m = m * n;
		}
		return m;
	}

	/**
	 * 兔子序列
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {
		int r=0;
		if (n == 0)
			r = 0;
		if (n == 1)
			r = 1;
		if (n > 1)
			r = fibonacci(n - 1) + fibonacci(n - 2);
		return r;
	}
	
	/**
	 * 兔子序列-动态规划-消除递归
	 * @param n
	 * @return
	 */
	public static int fibonacci_dynaprog(int n) {
		int r=0, recip1st=0, recip2nd=1;
		if (n == 0)
			r = 0;
		if (n == 1)
			r = 1;		
		for(int i=1; i<n ; i++) {
			r = recip1st + recip2nd;
			recip1st = recip2nd;
			recip2nd = r;
		}
		return r;
	}	
	
	/**
	 * the sieve of Erotosthenes
	 * @return
	 */
	public static int[] generatePrime() {
		return null;
	}
	
	/**
	 * 朴素的矩阵乘法-O(n*n*n)
	 * @param A 左矩阵 m*p
	 * @param B 右矩阵 p*n
	 * @param m
	 * @param p
	 * @param n
	 * @return
	 */
	public static int[][] matrixmul(int[][] A, int[][] B, int m, int p, int n) {
		int[][] C = new int[m][n];
		int a = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				a = 0;
				for (int k = 0; k < p; k++) {
					a += A[i][k] * B[k][j];
				}
				C[i][j] = a;
			}
		return C;
	}
	
	public static void printMatrix(int[][] arr) {
		if (arr==null || arr.length==0)
			return;
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		int X = arr.length;
		int Y = arr[0].length;
		for(int i=0; i<X; i++)
		{
			for(int j=0; j<Y; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		logger.info(sb.toString());
	}
	
	/**
	 * the second kind Stirling numbers
	 * James Stirling (1692-1770)
	 * the number of ways to partition a set of n things into k nonempty subsets.
	 * @param n
	 * @param k
	 * @return
	 */
	public static int stirling2ndkind(int n, int k) {
		if (k == 0 || n < k) return 0;
		else if (k == 1 || n == k) return 1;
		else return stirling2ndkind(n - 1, k - 1) + k*stirling2ndkind(n - 1, k);
	}
	
	/**
	 * Bell数: n元有限集合上的不同的等价关系个数
	 * @param n cardinality
	 * @return
	 */
	public static int quotientSetNum(final int n) {
		int ret=0;
		for(int i=1; i<=n; i++)
			ret += stirling2ndkind(n, i);
		return ret;
	}
	/**
	 * 线性同余法求伪随机数
	 * y=ax+b(mod m),a，b，m都是常数,x被称为Seed
	 * Srand ( )和Rand( )函数
	 */
	public static int lcg(int seed) {
		return (int)(seed * 1103515245 + 12345) % 32768; 
	}
}
