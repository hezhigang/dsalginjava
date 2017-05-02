/**
 * Apr 29, 2007 9:43:36 PM
 和志刚
 */
package com.codeguru;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 *
 */
public class Hanoitower {
	private static Logger logger = Logger.getLogger(Hanoitower.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3, 'A', 'B', 'C');
	}
	
	public static void move(char X, char Y) {
		logger.info("move " + X + " to " + Y);
	}

	public static void hanoi(int n,char X,char Y,char Z) {
		if (n==1) 
			move(X,Z);
		else {
			hanoi(n-1,X,Z,Y);
			move(X,Z);
			hanoi(n-1,Y,X,Z);
		}
	}
}
