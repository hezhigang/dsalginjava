/**
 * Jul 24, 2007 8:29:34 PM
 和志刚
 */
package com.codeguru.graph;

/**
 * @author 和志刚
 * 图的边 : edge of graph
 */
public class Edge implements Comparable<Edge> {
	private int from;
	private int to;
	private int weight;
	/**
	 * @return the from
	 */
	public int getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(int from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public int getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(int to) {
		this.to = to;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int compareTo(Edge edge) {
		Integer I = new Integer(this.weight);
		Integer J = new Integer(edge.weight);
		return I.compareTo(J);
	}
}
