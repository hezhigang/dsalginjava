/**
 * Jul 24, 2007 8:28:50 PM
 和志刚
 */
package com.codeguru.graph;

import java.util.Map;

import org.apache.log4j.Logger;

import com.codeguru.Queue;

/**
 * @author 和志刚
 * 图的基类
 */
public abstract class Graph {
	private static Logger logger = Logger.getLogger(Graph.class);
	private final static boolean UNVISITED = false;
	private final static boolean VISITED = true;
//	private final static String VERTEXINDEX = "vertexindex"; //顶点序号的Hash key
//	private final static String VERTEXLABEL = "vertexlabel"; //顶点标号的Hash key
	private final static float INFINITY = Float.POSITIVE_INFINITY;
	private int numVertex; // 顶点个数
	private int numEdge;   //边数
	private boolean[] mark;
	private int[] indegree;
	//反映 顶点序号-标号 对应关系的散列表
	private Map vertices;
	
	/**
	 * @param numVertex
	 */
	public Graph(int numVertex) {
		super();
		this.numVertex = numVertex;
		this.numEdge = 0;
		mark = new boolean[numVertex];
		indegree = new int[numVertex];
		for(int i=0; i<numVertex; i++) {
			mark[i] = UNVISITED;
			indegree[i] = 0;
		}
	}
	
	/**
	 * 图的周游
	 * @param G
	 */
	public void graph_traversal(Graph G) {
		boolean[] arr = G.getMark();
		for (int i=0; i<G.numVertex; i++)
			arr[i] = UNVISITED;
		G.setMark(arr);
		for(int i=0; i<G.numVertex; i++)
			if (G.getMark()[i]==UNVISITED)
//				this.BFS(G, i);
				this.DFS(G, i);
	}
	
	/**
	 * 拓扑排序, 使用队列方式
	 * @param G
	 */
	public void topsortByQueue(Graph G) {
		boolean[] arr = G.getMark();
		for (int i=0; i<G.numVertex; i++)
			arr[i] = UNVISITED;
//		G.setMark(arr);
		
		Queue<Integer> Q = new Queue<Integer>();
		
		for(int i=0; i<G.numVertex; i++)
			if (G.getIndegree()[i]==0)
				Q.enQueue(i);
		
		while(!Q.isEmpty()) {
			int V = Q.deQueue();
			G.mark[V] = VISITED;
			visit(G,V);
			for( Edge e=G.firstEdge(V); G.isEdge(e); e=G.nextEdge(e) ) {
				int j = e.getTo();
				int[] a = this.getIndegree();
				int d = a[j];
				a[j] = --d;
				this.setIndegree(a);
				if (this.getIndegree()[j]==0)
					Q.enQueue(j);
			}
		}
		
		for (int i=0; i<G.numVertex; i++) {
			if (G.getMark()[i] == UNVISITED) {
				logger.info("Graph has circuit, only DAG can topological sort");
				break;
			}
		}
	}
	
	/**
	 * 为了DFS拓扑排序中实现给整数参数不传值而传引用而设
	 * (不知道Java有没有更适当的方法),在C++中可以用int&
	 * @author 和志刚
	 *
	 */
	class Counter {
		public int idx;

		/**
		 * @param idx
		 */
		public Counter(int idx) {
			super();
			this.idx = idx;
		}
	}	
	
	/**
	 * 拓扑排序, 使用深度优先搜索
	 * @param G
	 */
	public void topsortByDFS(Graph G) {
		boolean[] arr = G.getMark();
		for (int i=0; i<G.numVertex; i++)
			arr[i] = UNVISITED;
		
		int[] result = new int[G.numVertex];
		Counter tag = new Counter(0);
		
		for (int i = 0; i < G.numVertex; i++)
			if (G.mark[i] == UNVISITED)
				do_topsort(G, i, result, tag);
		
		for(int i=G.numVertex-1; i>=0; i--)
			visit(G, result[i]);
	}
	
	/**
	 * DFS实现拓扑排序的递归例程
	 * @param G
	 * @param V
	 * @param result
	 * @param tag
	 */
	private void do_topsort(Graph G, int V, int[] result, Counter tag) {
		G.mark[V] = VISITED;
		for (Edge e = G.firstEdge(V); G.isEdge(e); e = G.nextEdge(e)) {
			if (G.mark[e.getTo()] == UNVISITED)
				do_topsort(G, G.toVertex(e), result, tag);
		}
		result[(tag.idx)++] = V;
	}
	
	/**
	 * 
	 * @param G
	 * @param V
	 */
	private void visit(Graph G, int V) {
		if (vertices.containsKey(V)) {
			logger.info( "顶点序号：" + V + " " + "顶点标号：" + (String) (vertices.get(V)) );
		}
	}
	
	/**
	 * 深度优先搜索
	 * @param G
	 * @param V
	 */
	public void DFS(Graph G, int V) {
		G.mark[V] = VISITED;
		visit(G, V);
		for( Edge e=G.firstEdge(V); G.isEdge(e); e=G.nextEdge(e) )
		{
			if ( G.mark[G.toVertex(e)]==UNVISITED )
				DFS(G, G.toVertex(e));
		}
	}
	
	/**
	 * 宽度优先搜索
	 * @param G
	 * @param V
	 */
	public void BFS(Graph G, int V) {
		Queue<Integer> Q = new Queue<Integer>();
		visit(G, V);
		G.mark[V] = VISITED;
		Q.enQueue(V);
		while (!Q.isEmpty()) {
			V = Q.deQueue();
			for (Edge e = G.firstEdge(V); G.isEdge(e); e = G.nextEdge(e))
				if (G.mark[G.toVertex(e)] == UNVISITED) {
					visit(G, G.toVertex(e));
					G.mark[G.toVertex(e)] = VISITED;
					Q.enQueue(G.toVertex(e));
				}
		}
	}
	
	public abstract Edge firstEdge(int oneVertex);  //返回与顶点相关联的第一条边
	public abstract Edge nextEdge(Edge preEdge);    //返回与指定边相关联的下一条边
	public abstract void setEdge(int from, int to, int weight);  //为图设定一条边
	public abstract void delEdge(int from, int to);  //删除一条边
	
	public boolean isEdge(Edge oneEdge) {
		if ( oneEdge.getWeight()>0 && oneEdge.getWeight()<INFINITY && oneEdge.getTo()>=0)
			return true;
		else
			return false;
	}
	
	public int fromVertex(Edge oneEdge) {
		return oneEdge.getFrom();
	}
	
	public int toVertex(Edge oneEdge) {
		return oneEdge.getTo();
	}
	
	public int weight(Edge oneEdge) {
		return oneEdge.getWeight();
	}
	
	/**
	 * @return the indegree
	 */
	public int[] getIndegree() {
		return indegree;
	}
	/**
	 * @param indegree the indegree to set
	 */
	public void setIndegree(int[] indegree) {
		this.indegree = indegree;
	}

	/**
	 * @return the mark
	 */
	public boolean[] getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(boolean[] mark) {
		this.mark = mark;
	}

	/**
	 * @return the numVertex
	 */
	public int getNumVertex() {
		return numVertex;
	}
	/**
	 * @param numVertex the numVertex to set
	 */
	public void setNumVertex(int numVertex) {
		this.numVertex = numVertex;
	}
	/**
	 * @return the numEdge
	 */
	public int getNumEdge() {
		return numEdge;
	}
	/**
	 * @param numEdge the numEdge to set
	 */
	public void setNumEdge(int numEdge) {
		this.numEdge = numEdge;
	}

	/**
	 * @return the vertices
	 */
	public Map getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(Map vertices) {
		this.vertices = vertices;
	}
	
}
