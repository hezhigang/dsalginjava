/**
 * 前缀、中缀、后缀表达式
 */
package com.codeguru;

import java.util.Stack;

import org.apache.log4j.Logger;


/**
 * @author 和志刚
 *
 */
public class FixConverter {
	private static Logger logger = Logger.getLogger(FixConverter.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String infixStr1 = "4*5*(2*4-3)+9";
		//logger.info("中缀计算器结果=" + infixCalculator(infixStr1));
		logger.info("中缀表达式1: " + infixStr1);
		String postfixStr1 = infix2postfix(infixStr1);
		logger.info("后缀表达式1: " + postfixStr1);
		logger.info("后缀计算器结果=" + postfixCalculator(postfixStr1));
		String prefixStr1 = infix2prefix(infixStr1);
		logger.info("前缀表达式1: " + prefixStr1);		
		logger.info("前缀计算器结果=" + prefixCalculator(prefixStr1));
		logger.info("\n");
		
		String infixStr2 = "4*x*(2*x+a)-c";
		logger.info("中缀表达式2: " + infixStr2);
		logger.info("后缀表达式2: " + infix2postfix(infixStr2));
		logger.info("正确表达式2: 4x*2x*a+*c-");
		String prefixStr2 = infix2prefix(infixStr2);
		logger.info("前缀表达式2: " + prefixStr2);		
		logger.info("\n");
		
		String infixStr3 = "4+5*(7-2*3)*2-7";
		//logger.info("中缀计算器结果=" + infixCalculator(infixStr3));
		logger.info("中缀表达式3: " + infixStr3);
		String postfixStr3 = infix2postfix(infixStr3);
		logger.info("后缀表达式3: " + postfixStr3);
		logger.info("后缀计算器结果=" + postfixCalculator(postfixStr3));
		String prefixStr3 = infix2prefix(infixStr3);
		logger.info("前缀表达式3: " + prefixStr3);
		logger.info("前缀计算器结果=" + prefixCalculator(prefixStr3));
		logger.info("\n");
		
		String infixStr4 = "a+b*c+(d*e+f)*g";
		logger.info("中缀表达式4: " + infixStr4);
		logger.info("正确表达式4: abc*+de*f+g*+");
		logger.info("后缀表达式4: " + infix2postfix(infixStr4));
		String prefixStr4 = infix2prefix(infixStr4);
		logger.info("前缀表达式4: " + prefixStr4);		
		logger.info("\n");
		
		String infixStr5 = "3-2*1+5*(3+2*7)*2-9";
		logger.info("中缀表达式5: " + infixStr5);
		String postfixStr5 = infix2postfix(infixStr5);
		logger.info("后缀表达式5: " + postfixStr5);
		logger.info("后缀计算器结果=" + postfixCalculator(postfixStr5));
		String prefixStr5 = infix2prefix(infixStr5);
		logger.info("前缀表达式5: " + prefixStr5);
		logger.info("前缀计算器结果=" + prefixCalculator(prefixStr5));
		logger.info("\n");
		
		String infixStr6 = "((100-4)/3+3*(36-7))*2";
		logger.info("中缀表达式6: " + infixStr6);
		String postfixStr6 = infix2postfix(infixStr6);
		logger.info("后缀表达式6: " + postfixStr6);
		logger.info("后缀计算器结果=" + postfixCalculator(postfixStr6));
		String prefixStr6 = infix2prefix(infixStr6);
		logger.info("前缀表达式6: " + prefixStr6);
		logger.info("前缀计算器结果=" + prefixCalculator(prefixStr6));
		logger.info("\n");
		
		String infixStr7 = "((7-4)/3+3*(9-7))*2";
		logger.info("中缀表达式7: " + infixStr7);
		String postfixStr7 = infix2postfix(infixStr7);
		logger.info("后缀表达式7: " + postfixStr7);
		logger.info("后缀计算器结果=" + postfixCalculator(postfixStr7));
		String prefixStr7 = infix2prefix(infixStr7);
		logger.info("前缀表达式7: " + prefixStr7);
		logger.info("前缀计算器结果=" + prefixCalculator(prefixStr7));
		logger.info("\n");

		String infixStr8 = "((a-b)/c+d*(e-f))*g";
		logger.info("中缀表达式8: " + infixStr8);
		String postfixStr8 = infix2postfix(infixStr8);
		logger.info("后缀表达式8: " + postfixStr8);
		String prefixStr8 = infix2prefix(infixStr8);
		logger.info("前缀表达式8: " + prefixStr8);		
		logger.info("\n");
		
		String infixStr9 = "A+B*(C-D/(E+F))";
		logger.info("中缀表达式9: " + infixStr9);
		String postfixStr9 = infix2postfix(infixStr9);
		logger.info("正确表达式9: ABCDEF+/-*+");
		logger.info("后缀表达式9: " + postfixStr9);
		String prefixStr9 = infix2prefix(infixStr9);
		logger.info("前缀表达式9: " + prefixStr9);
		logger.info("\n");
		
		String infixStr10 = "A*(B+C)-D/(E+F)";
		logger.info("中缀表达式10: " + infixStr10);
		String postfixStr10 = infix2postfix(infixStr10);
		logger.info("后缀表达式10: " + postfixStr10);
		String prefixStr10 = infix2prefix(infixStr10);
		logger.info("前缀表达式10: " + prefixStr10);
		logger.info("\n");

		String infixStr11 = "(x+y)*2+(x-4)/3";
		logger.info("中缀表达式11: " + infixStr11);
		String postfixStr11 = infix2postfix(infixStr11);
		logger.info("正确表达式11: xy+2*x4-3/+");
		logger.info("后缀表达式11: " + postfixStr11);
		String prefixStr11 = infix2prefix(infixStr11);
		logger.info("正确表达式11: +*+xy2/-x43");
		logger.info("前缀表达式11: " + prefixStr11);
		logger.info("\n");

		String infixStr12 = "a+b*c+(d*e+f)*g";
		logger.info("中缀表达式12: " + infixStr12);
		String postfixStr12 = infix2postfix(infixStr12);
		logger.info("正确表达式12: abc*+de*f+g*+");
		logger.info("后缀表达式12: " + postfixStr12);
		String prefixStr12 = infix2prefix(infixStr12);
		logger.info("正确表达式12: ++a*bc*+*defg");
		logger.info("前缀表达式12: " + prefixStr12);
		logger.info("\n");
	}

	/**
	 * 把中缀表达式转换为后缀表达式
	 * 
	 * @param infixExpr
	 * @return
	 */
	@Criticize (
			rank="four stars",
			feel="well"
	)
	public static String infix2postfix(String infixExpr) {
		StringBuffer postfixExpr = new StringBuffer();
		Stack stk = new Stack();
		char[] arr = infixExpr.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			switch (c) {
			case '*':
			case '/':
				while (!stk.isEmpty() && 
						(((Character) stk.peek()).charValue() == '*' || 
								((Character) stk.peek()).charValue() == '/')) {
					postfixExpr.append(((Character) stk.pop()).charValue());
				}
				stk.push(new Character(c));
				break;
			case '+':
			case '-':
				while (!stk.isEmpty()
						&& ((Character) stk.peek()).charValue() != '(') {
					postfixExpr.append(((Character) stk.pop()).charValue());
				}
				;
				stk.push(new Character(c));
				break;
			case '(':
				stk.push(new Character(c));
				break;
			case ')':
				while (!stk.isEmpty()
						&& ((Character) stk.peek()).charValue() != '(') {
					postfixExpr.append(((Character) stk.pop()).charValue());
				}
				;
				if (((Character) stk.peek()).charValue() == '(')
					stk.pop();
				break;
			default:
				postfixExpr.append(c);
			}
		}

		while (stk != null && !stk.isEmpty()) {
			postfixExpr.append(((Character) stk.pop()).charValue());
		}

		return postfixExpr.toString();
	}

	/**
	 * 把中缀表达式转换为前缀表达式
	 * 2007-4-19
	 * @param infixExpr
	 * @return
	 */
	public static String infix2prefix(String infixExpr) {
		StringBuffer prefixExpr = new StringBuffer();
		Stack stk = new Stack(); // 操作符栈
		Stack operandStk = new Stack(); // 操作数栈
		char[] arr = infixExpr.toCharArray();
		String s = "", s1 = "", s2 = "";
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			switch (c) {
			case '*':
			case '/':
				while (!stk.isEmpty() && 
						(((Character) stk.peek()).charValue() == '*' || 
								((Character) stk.peek()).charValue() == '/')) {
					s1 = (String) operandStk.pop();
					s2 = (String) operandStk.pop();
					s = ((Character) stk.pop()).toString() + s2 + s1;
					operandStk.push(s);
				}
				stk.push(new Character(c));
				break;
			case '+':
			case '-':
				while (!stk.isEmpty()
						&& ((Character) stk.peek()).charValue() != '(') {
					s1 = (String) operandStk.pop();
					s2 = (String) operandStk.pop();
					s = ((Character) stk.pop()).toString() + s2 + s1;
					operandStk.push(s);
				};
				stk.push(new Character(c));
				break;
			case '(':
				stk.push(new Character(c));
				break;
			case ')':
				while (!stk.isEmpty() && ((Character) stk.peek()).charValue() != '(') {
					s1 = (String) operandStk.pop();
					s2 = (String) operandStk.pop();
					s = ((Character) stk.pop()).toString() + s2 + s1;
					operandStk.push(s);
				};
				if (((Character) stk.peek()).charValue() == '(')
					stk.pop();
				break;
			default:
				operandStk.push(Character.toString(c));
			}
		}
		
		while (stk != null && !stk.isEmpty()) {
			s1 = (String) operandStk.pop();
			s2 = (String) operandStk.pop();
			s = ((Character) stk.pop()).toString() + s2 + s1;
			operandStk.push(s);
		}

		while (operandStk != null && !operandStk.isEmpty()) {
			prefixExpr.append((String) operandStk.pop());
		}

		return prefixExpr.toString();
	}

	/**
	 * 后缀表达式计算器
	 * 
	 * @param postfixExpr
	 * @return
	 */
	public static int postfixCalculator(String postfixExpr) {
		Stack stk = new Stack();
		char[] arr = postfixExpr.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			int a, b, x;
			switch (c) {
			case '*':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a * b;
					stk.push(new Integer(x));
				}
				break;
			case '+':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a + b;
					stk.push(new Integer(x));
				}
				break;
			case '-':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = b - a;
					stk.push(new Integer(x));
				}
				break;
			case '/':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = b / a;
					stk.push(new Integer(x));
				}
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				stk.push(new Integer(Character.digit(c, 10)));
				break;
			}
		}
		int ret = 0;
		if (!stk.isEmpty())
			ret = ((Integer) stk.pop()).intValue();
		return ret;
	}
		
	/**
	 * 前缀表达式计算器
	 * 从2007.11.27晚上开始鼓捣，思路不对头，想从中缀转前缀入手，结果不行，
	 * 直到20:31 2007-11-28才忽然通过逆着观察前缀表达式
	 * 忽然想到在后缀计算器的基础上逆着读表达式串注意除/减的除数与被除数的关系就可以了
	 * 逆向思维，说来容易，一碰到具体问题不见到那么容易想到可以这么想
	 * @param prefixExpr
	 * @return
	 */
	@Criticize (
			rank="three stars",
			feel="fine"
	)	
	public static int prefixCalculator(String prefixExpr) {
		Stack stk = new Stack();
		char[] arr = prefixExpr.toCharArray();
		for (int i = arr.length-1; i >=0 ; i--) {
			char c = arr[i];
			int a, b, x;
			switch (c) {
			case '*':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a * b;
					stk.push(new Integer(x));
				}
				break;
			case '+':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a + b;
					stk.push(new Integer(x));
				}
				break;
			case '-':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a - b;
					stk.push(new Integer(x));
				}
				break;
			case '/':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a / b;
					stk.push(new Integer(x));
				}
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				stk.push(new Integer(Character.digit(c, 10)));
				break;
			}
		}
		int ret = 0;
		if (!stk.isEmpty())
			ret = ((Integer) stk.pop()).intValue();
		return ret;
	}

	/**
	 * 中缀表达式计算器
	 * @param infixExpr
	 * @return
	 */
	public static int infixCalculator(String infixExpr) {
		return 0;
	}	
}
