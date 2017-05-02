/**
 * Jul 31, 2007 9:36:10 PM
 和志刚
 */
package com.codeguru.graph;

/**
 * @author 和志刚
 * 顶点
 */
public class Vertex {
	public int index;  //存储数组序号
	public String label; //标号
	/**
	 * @param index
	 * @param label
	 */
	public Vertex(int index, String label) {
		super();
		this.index = index;
		this.label = label;
	}
}
