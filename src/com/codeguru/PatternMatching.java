/**
 * Apr 22, 2007 3:34:59 PM
 和志刚
 */
package com.codeguru;

import org.apache.log4j.Logger;

/**
 * @author 和志刚
 * 
 */
public class PatternMatching {
	private static Logger logger = Logger.getLogger(PatternMatching.class);

	/**
	 * 快速无回溯的字符串模式匹配
	 * 
	 * @param S
	 * @param P
	 * @param N
	 * @param startIndex
	 * @return
	 */
	public static int findPat_KMP(String S, String P, int[] N, int startIndex) {
		int lastIndex = S.length() - P.length();
		if (lastIndex < startIndex)
			return -1;
		int i = startIndex, j = 0;
		for (; i < S.length(); i++) {
			while (P.charAt(j) != S.charAt(i) && j > 0)
				j = N[j - 1];
			if (S.charAt(i) == P.charAt(j))
				j++;
			if (j == P.length())
				return i - j + 1;
		}
		return -1;
	}

	/**
	 * 模板串的特征向量
	 * 
	 * @param P
	 * @return
	 */
	public static int[] nextVector(String P) {
		int[] arr = new int[P.length()];
		arr[0] = 0;
		int k = 0;
		for (int i = 1; i < P.length(); i++) {
			k = arr[i - 1];

			while (k > 0 && P.charAt(i) != P.charAt(k)) {
				k = arr[k - 1];
			}

			if (P.charAt(i) == P.charAt(k))
				arr[i] = k + 1;
			else
				arr[i] = 0;
		}
		return arr;
	}

	/**
	 * 原始模式匹配1
	 * 
	 * @param S
	 * @param P
	 * @param startIndex
	 * @return
	 */
	public static int naive_1(String S, String P, int startIndex) {
		int lastIndex = S.length() - P.length();
		if (lastIndex < startIndex)
			return -1;
		for (int i = startIndex; i < lastIndex; i++) {
			if (P.equals(S.substring(i, i + P.length()))) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 原始模式匹配2
	 * 
	 * @param S
	 * @param P
	 * @param startIndex
	 * @return
	 */
	public static int naive_2(String S, String P, int startIndex) {
		int lastIndex = S.length() - P.length();
		if (lastIndex < startIndex)
			return -1;
		int i = startIndex, j = 0;
		for (; i < S.length() && j < P.length();) {
			if (S.charAt(i) == P.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}

		if (i > P.length())
			return i - j;
		else
			return -1;
	}

	public static String printNextVector(int[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "aaaavdsfsdfsdfsdafdfdfe";
		String P = "dfsda";
		logger.info("find " + P + " in " + S + " at " + naive_2(S, P, 0));
		int[] arr = nextVector(P);
		logger.info("the next of " + P + " is " + printNextVector(arr));
		logger.info("find " + P + " in " + S + " at "
				+ findPat_KMP(S, P, arr, 0) + " by KMP");
		String P2 = "BABBABAB";
		logger.info("the nextarray of " + P2 + " is " + printNextVector(nextVector(P2)));
	}

}
