/**
 * Oct 14, 2007 8:41:42 PM
 和志刚
 */
package com.codeguru.internalsort;

/**
 * @author 和志刚
 * 待排序记录的类型
 */
public class Record {
	public int key;
	public String surname;
	public int iq;
	
	/**
	 * @param key
	 * @param surname
	 * @param iq
	 */
	public Record(int key, String surname, int iq) {
		super();
		this.key = key;
		this.surname = surname;
		this.iq = iq;
	}
}
