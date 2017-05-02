/**
 * Oct 11, 2007 9:33:43 PM
 和志刚
 */
package com.codeguru.internalsort;

/**
 * @author 和志刚
 * 比较整数大小静态方法
 */
public class CompareI {
	public static boolean lt(int x, int y) {
		return x<y ? true : false;
	}
	
	public static boolean eq(int x, int y) {
		return x==y ? true : false;
	}
	
	public static boolean gt(int x, int y) {
		return x>y ? true : false;
	}
}
