/**
 * Aug 30, 2007 2:58:28 PM
 和志刚
 */
package com.codeguru.graph;

import org.apache.log4j.Logger;

import com.codeguru.MinHeap;

/**
 * @author 和志刚
 * 图·最短路径
 */
public class ShortestPath {
	private static Logger logger = Logger.getLogger(ShortestPath.class);
	private final static boolean UNVISITED = false;
	private final static boolean VISITED = true;
	
	/**
	 * 
	 * @param G
	 * @param V
	 */
	private static void visit(Graph G, int V) {
		if (G.getVertices().containsKey(V)) {
			logger.info( "顶点序号：" + V + " " + "顶点标号：" + (String) (G.getVertices().get(V)) );
		}
	}
	
	/**
	 * 单源最短路径Dijkstra算法
	 * @param G
	 * @param s
	 * @param D
	 */
	public static void dijkstra(Graph G, int s, Dist[] D) {
		D = new Dist[G.getNumVertex()];
		for (int i=0; i<G.getNumVertex(); i++) {
			G.getMark()[i] = UNVISITED;
			D[i] = new Dist(i, Float.POSITIVE_INFINITY, s);
		}
		D[s].length = 0f;
		
		MinHeap<Dist> H = new MinHeap<Dist>(G.getNumEdge());
		H.insert(D[s]);
		for (int i=0; i<G.getNumVertex(); i++) {
			boolean found = false;
			Dist d = null;
			while(!H.isEmpty()) {				
				d = H.removeMin();
				if (G.getMark()[d.index]==UNVISITED) {
					found = true;
					break;
				}
			}
			
			if (!found) 
				break;
			
			int v = d.index;
			G.getMark()[v] = VISITED;
			visit(G, v);
			
			for(Edge e=G.firstEdge(v); G.isEdge(e); e=G.nextEdge(e) ) {
				int u = G.toVertex(e); 
				if ( (D[u].length>D[v].length+G.weight(e)) && G.getMark()[u]==UNVISITED ) {
					D[u].length = D[v].length+G.weight(e);
					D[u].pre = v;
					H.insert(D[u]);
				}
			}
		}
	}
	
	/**
	 * 每对顶点间的最短路径 - Floyd算法
	 * @param G
	 */
	public static void floyd(Graph G) {
		int i,j,v;
		int vertex_count = G.getNumVertex();
		Dist[][] D = new Dist[vertex_count][vertex_count];
		for(i=0; i<vertex_count; i++)
			for(j=0; j<vertex_count; j++) {
				D[i][j] = new Dist();
				D[i][j].length = i==j ? 0f : Float.POSITIVE_INFINITY;
				D[i][j].pre = i==j ? i : -1;
			}
		
		int tmp;
		for(v=0; v<vertex_count; v++)
			for(Edge e=G.firstEdge(v); G.isEdge(e); e = G.nextEdge(e)) {
				tmp = G.toVertex(e); 
				D[v][tmp].length = G.weight(e);
				D[v][tmp].pre = v;
			}
		
		for(v=0; v<vertex_count; v++)
			for(i=0; i<vertex_count; i++)
				for(j=0; j<vertex_count; j++) {
					if ( (D[i][v].length+D[v][j].length) < D[i][j].length ) {
						D[i][j].length = D[i][v].length + D[v][j].length;
						D[i][j].pre = v;
					}
				}
		
		for(i=0; i<vertex_count; i++)
			for(j=0; j<vertex_count; j++) {
//				G.visit(G, D[i][j].index);
				logger.info(  "长度: " + D[i][j].length + " 前驱: " + (D[i][j].pre+1));
			}
	}
}
