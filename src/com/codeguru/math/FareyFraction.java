/**
 * Oct 1, 2007 9:43:20 PM
 和志刚
 */
package com.codeguru.math;

/**
 * @author 和志刚
 * 法里级数的项_有理真分数
 */
public class FareyFraction implements Comparable<FareyFraction> {
	private int numerator;  //分子
	private int denominator; //分母
	
	/**
	 * @return the denominator
	 */
	public int getDenominator() {
		return denominator;
	}
	/**
	 * @param denominator the denominator to set
	 */
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	/**
	 * @return the numerator
	 */
	public int getNumerator() {
		return numerator;
	}
	/**
	 * @param numerator the numerator to set
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	/**
	 * 如果参数较大返回1
	 */
	public int compareTo(FareyFraction x) {
		int d = MyMathJog.lcm(denominator, x.getDenominator());
		int myNum = d / denominator * numerator;
		int hisNum = d / x.getDenominator() * x.getNumerator();
		int ret = 0;
		if ( hisNum>myNum )
			ret = 1;
		else if (myNum == hisNum)
			ret = 0;
		else
			ret = -1;
		return ret;
	}
	/**
	 * @param numerator
	 * @param denominator
	 */
	public FareyFraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}
}
