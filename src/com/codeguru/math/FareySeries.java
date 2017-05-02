/**
 * Sep 9, 2007 8:43:42 PM
 和志刚
 */
package com.codeguru.math;

import org.apache.log4j.Logger;

import com.codeguru.util.DualChain;
import com.codeguru.util.DualChainNode;

/**
 * @author 和志刚
 * 法里级数 John Farey
 */
public class FareySeries {
	private static Logger logger = Logger.getLogger(FareySeries.class);
	
	/**
	 * 打印法里级数序列
	 * @param n 法里级数阶数
	 */
	public static void buildSeries(final int n) {
		DualChain<FareyFraction> llist = new DualChain<FareyFraction>();
		for (int i = 2; i <= n; i++)
			for (int j = 1; j < i; j++) {
				if (MyMathJog.gcd(i, j) == 1) {
					FareyFraction f = new FareyFraction(j, i);
					DualChainNode<FareyFraction> tmpNode = llist.getHead();
					if (tmpNode != null) {
						while (tmpNode != null && f.compareTo(tmpNode.getElement()) == -1)
							tmpNode = tmpNode.getNext();
					}
					if (tmpNode == null)
						llist.append(f);
					else
						llist.insert(f, tmpNode);
				}
			}
		llist.insertAtTop( new FareyFraction(0, 0) );
		llist.append( new FareyFraction(1, 1) );
		
		
		StringBuffer sb = new StringBuffer();
		if (!llist.isEmpty()) {
			DualChainNode<FareyFraction> ptr = llist.getHead();
			while (ptr != null) {
				FareyFraction a = ptr.getElement();				
				sb.append(a.getNumerator() + "/" + a.getDenominator() + " " );
				ptr = ptr.getNext();
			}
			logger.info( n + "阶法里级数:" + sb.toString() );
		} else
			logger.info("linklist is empty");
	}
}
