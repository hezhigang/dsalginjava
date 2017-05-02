/**
 * Nov 11, 2007 7:53:31 PM
 和志刚
 */
package com.codeguru;

import java.util.Map;

/**
 * @author 和志刚 闭散列实现的字典(关联数组)
 */
public class HashDict<K,E> {
	private static int M; //散列表大小
	private Map.Entry<K,E>[] HT;  //散列表
	
	public static long ELFhash(char[] key) {
		long h = 0;
		for (int i = 0; i < key.length; i++) {
			i++;
			h = (h << 4) + key[i];
			long g = h & 0xF0000000L;
			if (g > 0)
				h ^= g >> 24;
			h &= ~g;
		}
		return h % M;
	}

	/**
	 * Returns a hash value for the specified object. In addition to the
	 * object's own hashCode, this method applies a "supplemental hash
	 * function," which defends against poor quality hash functions. This is
	 * critical because HashMap uses power-of two length hash tables.
	 * <p>
	 * 
	 * The shift distances in this function were chosen as the result of an
	 * automated search over the entire four-dimensional search space.
	 */
	public static int hash(Object x) {
		int h = x.hashCode();

		h += ~(h << 9);
		h ^= (h >>> 14);
		h += (h << 4);
		h ^= (h >>> 10);
		return h;
	}
}
