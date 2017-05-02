/**
 * Sep 13, 2007 9:23:55 PM
 和志刚
 */
package com.codeguru.graph;

import org.apache.log4j.Logger;

import com.codeguru.MinHeap;
import com.codeguru.util.ParTree;

/**
 * @author 和志刚
 * MST - 最小生成树
 */
public class MST {
	private static Logger logger = Logger.getLogger(MST.class);
	
	private static void addEdgeToMST(Edge e, Edge[] MST, int tag) {
		MST[tag] = e;
	}
	
	/**
	 * 避圈法-Kruskal算法
	 * @param g
	 */
	public static void kruskal(Graph g) {
		ParTree A = new ParTree(g.getNumVertex());
		MinHeap<Edge> H = new MinHeap<Edge>(g.getNumEdge());
		Edge[] mst = new Edge[g.getNumVertex()-1];  //MST的边数组，数组的length为顶点数-1，非边数-1，注意
		int MSTTag=0;
		for(int i=0; i<g.getNumVertex()-1; i++)
			for(Edge e = g.firstEdge(i); g.isEdge(e); e = g.nextEdge(e))
				if (g.fromVertex(e) < g.toVertex(e))  //无向图，防止重复插入
					H.insert(e);
		
		int equNum = g.getNumVertex();
		while(equNum>1) {
			Edge e = H.removeMin();
			if (e.getWeight()==Float.POSITIVE_INFINITY) {
				logger.info("不存在最小生成树");
				return;
			}
			int from = g.fromVertex(e);
			int to = g.toVertex(e);
			if (A.different(from, to))
			{
				A.union(from, to);
				addEdgeToMST(e, mst, MSTTag++);
//				mst[MSTTag++] = e;
				equNum--;
			}
		}	
		
		for(int i=0; i<g.getNumVertex()-1; i++)
		  logger.info("边-" + i + " from: " + mst[i].getFrom() + " to: " + mst[i].getTo() + " weight: " + mst[i].getWeight());
	}
	
	/**
	 * 断集法 - Prim算法
	 * @param g
	 * @param s 开始顶点
	 */
	public static void prim(Graph g, final int s) {
		int MSTtag = 0;
		Edge[] mst = new Edge[g.getNumVertex()-1];
		MinHeap<Edge> H = new MinHeap<Edge>(g.getNumEdge());
		for (int i=0; i<g.getNumVertex(); i++)
			g.getMark()[i] = false;	
		int v = s;
		g.getMark()[v] = true;
		do {
			Edge e = null;
			
			for(e = g.firstEdge(v); g.isEdge(e); e = g.nextEdge(e))
				if (g.getMark()[g.toVertex(e)]==false)
					H.insert(e);
			
			boolean found = false;
			while ( !H.isEmpty() ) {
				e = H.removeMin();
				if (g.getMark()[g.toVertex(e)] == false) {
					found = true;
					break;
				}
			}
			
			if (!found) {
				logger.info("不存在最小生成树");
				return;				
			}
			
			v = g.toVertex(e);
			g.getMark()[v] = true;
			addEdgeToMST(e, mst, MSTtag++);
		} while ( MSTtag < (g.getNumVertex()-1) );
		
		for(int i=0; i<g.getNumVertex()-1; i++)
		  logger.info("边-" + i + " from: " + mst[i].getFrom() + " to: " + mst[i].getTo() + " weight: " + mst[i].getWeight());		
	}
}
