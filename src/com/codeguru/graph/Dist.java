/**
 * Aug 30, 2007 2:36:30 PM
 和志刚
 */
package com.codeguru.graph;


/**
 * @author 和志刚
 *
 */
public class Dist implements Comparable<Dist> {
	public int index;
	public float length;
	public int pre;
	
	/**
	 * 
	 */
	public Dist() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param index
	 * @param length
	 * @param pre
	 */
	public Dist(int index, float length, int pre) {
		super();
		this.index = index;
		this.length = length;
		this.pre = pre;
	}

	public int compareTo(Dist d) {
		// TODO Auto-generated method stub
		Float a = new Float(this.length);
		Float b = new Float(d.length);
		return a.compareTo(b);
	}
}
