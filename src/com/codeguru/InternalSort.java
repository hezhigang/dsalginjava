/**
 * 内排序上机实验
 */
package com.codeguru;

import java.util.Random;
import java.util.Stack;

import org.apache.log4j.Logger;

/**
 * @author Administrator
 * 
 */
public class InternalSort {
	private static Logger logger = Logger.getLogger(InternalSort.class);

	private final static int ARRAY_LEN = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testRandom();
		int[] ori = arrToSort();
		logger.info("待排序的数组：");
		printArray(ori);
		
		//巨大的bug，这种方式导致前面的排好了后面的错了都不发觉，比如原来的shell排序是错误的
		//还是需要Junit来测试
		int[] orderedArr = bubbleSort(ori);
		logger.info("冒泡排序结果->");
		printArray(orderedArr);
		
		int[] orderedArr5 = selectionSort(ori);
		logger.info("选择排序结果->");
		printArray(orderedArr5);		
		
		int[] orderedArr2 = insertionSort_1(ori);
		logger.info("直接插入排序结果->");
		printArray(orderedArr2);
		
		int[] orderedArr3 = insertionSort_2(ori);
		logger.info("稍微改进的插入排序结果->");
		printArray(orderedArr3);	
		
		int[] orderedArr4 = binaryInsertionSort(ori);
		logger.info("采用二分搜索的插入排序结果->");
		printArray(orderedArr4);	
		
		int[] orderedArr6 = quicksort(ori);
		logger.info("采用快速排序的结果->");
		printArray(orderedArr6);
		
		Random rand = new Random();
		int x = rand.nextInt(ARRAY_LEN);
		logger.info("二分检索"+x+"的结果：" + binSearch(orderedArr6,x));
		
		int[] orderedArr7 = shellsort(ori);
		logger.info("采用希尔排序的结果->");
		printArray(orderedArr7);
		
		int[] orderedArr8 = mergesort(ori);
		logger.info("采用归并排序的结果->");
		printArray(orderedArr8);	
		
		int[] orderedArr9 = heapsort(ori);
		logger.info("采用堆排序的结果->");
		printArray(orderedArr9);
	}

	/**
	 * 冒泡排序
	 * 
	 * @param randomArr
	 * @return
	 */
	public static int[] bubbleSort(int[] randomArr) {
		boolean noswap = true;  //避免对已经排好序的结果进行无用的比较
//		long d1 = System.currentTimeMillis();
		for (int i = 1; i < randomArr.length; i++) {
			noswap = true;
			for (int j = randomArr.length - 1; j >= i; j--) {
				if (randomArr[j] < randomArr[j - 1])
				{
					swap(randomArr, j, j-1);
					noswap = false;
				}
//				{
//					int temp = randomArr[j];
//					randomArr[j] = randomArr[j-1];
//					randomArr[j-1] = temp;
//				}
			}
			if (noswap) break;
		}
//		long d2 = System.currentTimeMillis();
//		long spendTime = d2-d1;
//		logger.info("冒泡排序用时：" + Long.toString(spendTime) + "毫秒");
		return randomArr;
	}
	
	/**
	 * 选择排序
	 * @param randomArr
	 * @return
	 */
	public static int[] selectionSort(int[] randomArr) {
		int smallest;
		for (int i = 0; i < randomArr.length; i++) {
			smallest = i;
			for (int j = randomArr.length - 1; j > i; j--) {
				if (randomArr[j] < randomArr[smallest])
					smallest = j;
			}
			swap(randomArr, i, smallest);
		}
		return randomArr;
	}	
	
	/**
	 * 直接插入排序
	 * @param inArr
	 * @return
	 */
	public static int[] insertionSort_1(int[] inArr) {
		for (int i = 1; i < inArr.length; i++) {
			for (int j = i; j>0; j--) {
				if (inArr[j] < inArr[j - 1])
				{
					swap(inArr, j, j-1);
				}
			}
		}
		return inArr;
	}
	
	/**
	 * 简单改进的插入排序
	 * @param inArr
	 * @return
	 */
	public static int[] insertionSort_2(int[] inArr) {
		int i,j;
		for (i = 1; i < inArr.length; i++) {
			int temp = inArr[i];
			for (j = i; j>0 && inArr[j]>temp; j--) {
					swap(inArr, j-1, j);
			}
			inArr[j] = temp;
		}
		return inArr;
	}	
	
	/**
	 * 采用二分搜索方式的插入排序
	 * @param inArr
	 * @return
	 */
	public static int[] binaryInsertionSort(int[] inArr) {
		int i;
		for (i = 1; i < inArr.length; i++) {
			int left=0,right=i-1;
			while(left<=right) {
				int middle = (left+right)/2;
				if (inArr[middle] > inArr[i])
					right = middle-1;
				else
					left = middle+1;
			}
			swap(inArr, left, i);
		}
		return inArr;
	}	
	
	/**
	 * 未优化的快速排序
	 * from Programming Pearls(John Bentley)
	 * @param l 数组活动部分的下界
	 * @param u 数组活动部分的上界
	 * @param inArr
	 */
	public static void qsort(int l, int u, int[] inArr) {
		if (l>=u) return; //数组的元素小于2时，终止递归
		int m=l; //m: 中间值的下标
		for(int i=l+1;i<=u; i++)
			//不变式: x[l+1..m] < x[l] && x[m+1..i-1]>=x[l]
			if (inArr[i]<inArr[l])
				swap(inArr, ++m, i);
		swap(inArr, l, m);
		qsort(l,m-1,inArr);
		qsort(m+1,u,inArr);
	}
	
	/**
	 * 消除递归的快速排序
	 * @param l
	 * @param u
	 * @param inArr
	 */
	public static void qsort_noRecursion(int l, int u, int[] inArr) {
		if (l>=u) return; //数组的元素小于2时，终止递归
		int pivot = l;
		Stack stk = new Stack();
		while(!stk.isEmpty()) {
			if (pivot<u) {
				stk.push(pivot);
				if (l>=u) return; //数组的元素小于2时，终止递归
				int m=l; //m: 中间值的下标
				for(int i=l+1;i<u; i++)
					//不变式: x[l+1..m] < x[l] && x[m+1..i-1]>=x[l]
					if (inArr[i]<inArr[l])
						swap(inArr, ++m, i);			
			}
			else {
				pivot = (Integer)stk.peek();
				stk.pop();
				if (l>=u) return; //数组的元素小于2时，终止递归
				int m=l; //m: 中间值的下标
				for(int i=l+1;i<u; i++)
					//不变式: x[l+1..m] < x[l] && x[m+1..i-1]>=x[l]
					if (inArr[i]<inArr[l])
						swap(inArr, ++m, i);				
			}
		}		
	}
	
	/**
	 * 快速排序
	 * @param inArr
	 * @return
	 */
	public static int[] quicksort(int[] inArr) {
		qsort(0,inArr.length-1, inArr);
		return inArr;
	}
	
	/**
	 * 希尔排序
	 * 原来的两重循环的方式是错误的 21:59 2007-11-26
	 * shell排序为什么需要调用插入排序
	 * @param inArr
	 * @return
	 */
	public static int[] shellsort(int[] inArr) {
		int increment,N;
		N = inArr.length;
		for (increment=N/2; increment >= 1; increment = increment / 2)
			for(int i=increment; i<N; i++)
			for (int j = i; j >= increment; j-=increment)
				if (inArr[j] < inArr[j-increment]) {
					swap(inArr, j, j-increment);
				}
		return inArr;
	}
	
	/**
	 * 希尔排序
	 * 采用{2^k-1,...,7,3,1}增量序列
	 * @param inArr
	 * @return
	 */
	public static int[] shellsortpro(int[] inArr) {
		int increment,N;
		N = inArr.length;
		int I=2;
		for(;I<N;I*=2);
		I/=2;
		//for (increment=I-1; increment >= 1; increment = (increment-1) / 2)
		for (increment=I-1; increment >= 1; increment = increment/2)
		{
//			logger.info(increment);
			for (int i = increment; i < N; i++)
				for (int j = i; j >= increment; j-=increment)
				if (inArr[j] < inArr[j-increment]) {
					swap(inArr, j, j-increment);
				}
		}
		return inArr;
	}
	
	/**
	 * 归并排序-供调用
	 * @param inArr
	 * @return
	 */
	public static int[] mergesort(int[] inArr) {
		int N = inArr.length;
		int[] tempArr = new int[N];
		return msort(inArr, tempArr, 0, N-1);
	}
	
	/**
	 * 归并排序
	 * @param inArr
	 * @return
	 */
	public static int[] msort(int[] arr, int[] tempArr, int left, int right) {
		int middle;
		if (left<right) {
			middle = (left+right)/2;
			msort(arr, tempArr, left, middle);
			msort(arr, tempArr, middle+1, right);
			merge(arr, tempArr, left, middle+1, right);
		}
		return arr;
	}
	
	/**
	 * 归并排序-合并过程
	 * @param arr
	 * @param tempArr
	 * @param posLeft
	 * @param posRight
	 * @param rightEnd
	 */
	public static void merge(int[] arr, int[] tempArr, int posLeft, int posRight, int rightEnd) {
		int i, leftEnd, numElements, tempPos;
		leftEnd = posRight-1;
		numElements = rightEnd-posLeft+1;
		tempPos = posLeft;
		while ( posLeft<=leftEnd && posRight<=rightEnd ) {
			if ( arr[posLeft] < arr[posRight] )
				tempArr[tempPos++] = arr[posLeft++];
			else
				tempArr[tempPos++] = arr[posRight++];
		}
		while (posLeft<=leftEnd) {
			tempArr[tempPos++] = arr[posLeft++];
		}
		while (posRight<=rightEnd) {
			tempArr[tempPos++] = arr[posRight++];
		}	
		
		for (i=0; i<numElements; i++)
			arr[i] = tempArr[i];		
		
		//没有下面的过程排序结果不正确
		for (i=0; i<numElements; i++, rightEnd--)
			arr[rightEnd] = tempArr[rightEnd];
	}
	
	/**
	 * 堆排序
	 * @param inArr
	 * @return
	 */
	public static int[] heapsort(int[] inArr) {
		int size = inArr.length;
		Integer[] intobjArr = new Integer[size];
		for(int i=0; i<size; i++)
			intobjArr[i] = new Integer(inArr[i]);
		MaxHeap<Integer> heap = new MaxHeap<Integer>(intobjArr);
		for(int i=0; i<size; i++)
			heap.removeMax();
		intobjArr = (Integer[]) heap.getHeapArray();
		for(int i=0; i<size; i++)
			inArr[i] = intobjArr[i].intValue();
		return inArr;
	}
	
	/**
	 * 二分搜索
	 * @param seq 待检索数组
	 * @param iToFind 待检索数
	 * @return
	 */
	public static int binSearch(int[] seq, int iToFind) {
		int idx = -1, N, middle, left, right;
		N = seq.length;
		left = 0;
		right = N-1;
		while ( left<=right ) {
			middle = (left+right)/2;
			if (iToFind == seq[middle]) {
				return middle;
//				idx = middle;
//				break;
			}
			if ( iToFind < seq[middle] )
				right = middle-1;			
			if ( iToFind > seq[middle] )
				left = middle+1;
		}
		return idx;
	}
	
	/**
	 * 分配排序_桶式排序
	 * @param inArr 待排序数组
	 * @param n 数组长度
	 * @param min 下限
	 * @param max 上限
	 * @return
	 */
	public static int[] bucketSort(int[] inArr, final int n, final int min, final int max) {
		int bucketNum = max-min;
		int[] count = new int[bucketNum];
		for(int i=0; i<bucketNum; i++)
			count[i] = 0;
		for(int i=0; i<n; i++)
			count[inArr[i]-min]++;
		
		int x=0;
		for(int i=0; i<bucketNum; i++)
			for(int j=0; j<count[i]; j++)
			  inArr[x++] = i+min;
		return inArr;
	}

	public static int[] arrToSort() {
		Random rand = new Random();
		int[] arr = new int[ARRAY_LEN];
		for (int i = 0; i < ARRAY_LEN; i++) {
			arr[i] = rand.nextInt(ARRAY_LEN);
		}
		return arr;
	}

	public static void testRandom() {
		Random rand = new Random();
		// rand.setSeed(1L);
		// Random integers that range from from 0 to n
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < ARRAY_LEN; j++) {
			int i = rand.nextInt(ARRAY_LEN);
			sb.append(" " + i);
			if (j % 5 == 0)
				sb.append("\n");
		}
		logger.info(sb.toString());
	}

	public static void printArray(int[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(" " + blankPadString(Integer.toString(arr[i]),2));
			if ( (i+1) % 20 == 0)
				sb.append("\n");
		}
		logger.info("\n" + sb.toString());
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	  private static final char[] blankArray = "                ".toCharArray();

	  /**
	   * Pads the supplied String with 0's to the specified length and returns
	   * the result as a new String. For example, if the initial String is
	   * "9999" and the desired length is 8, the result would be "00009999".
	   * This type of padding is useful for creating numerical values that need
	   * to be stored and sorted as character data. Note: the current
	   * implementation of this method allows for a maximum <tt>length</tt> of
	   * 16.
	   *
	   * @param string the original String to pad.
	   * @param length the desired length of the new padded String.
	   * @return a new String padded with the required number of 0's.
	   */
	  public static final String blankPadString(String string, int length) {
	    if (string == null || string.length() > length) {
	      return string;
	    }
	    StringBuffer buf = new StringBuffer(length);
	    buf.append(blankArray, 0, length - string.length()).append(string);
	    return buf.toString();
	  }	

}
