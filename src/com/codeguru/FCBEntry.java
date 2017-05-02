/**
 * Jun 24, 2007 5:12:35 PM
 和志刚
 */
package com.codeguru;

/**
 * @author 和志刚
 * 文件目录树的文件信息VO
 */
public class FCBEntry {
	private String name;
	private long size;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}
	/**
	 * @param name
	 * @param size
	 */
	public FCBEntry(String name, long size) {
		super();
		this.name = name;
		this.size = size;
	}
}
