/**
 * Aug 1, 2007 8:41:15 PM
 和志刚
 */
package com.codeguru.graph;

/**
 * @author 和志刚
 * 图的相邻矩阵存储表示
 */
public class GraphMImpl extends Graph {
	private int[][] matrix = null;  //存储相邻矩阵的二维数组

	/**
	 * @param numVertex
	 */
	public GraphMImpl(int numVertex) {
		super(numVertex);
		matrix = new int[numVertex][numVertex];
		for(int i=0; i<numVertex; i++)
			for(int j=0; j<numVertex; j++)
				matrix[i][j] = 0;
	}

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#firstEdge(int)
	 */
	@Override
	public Edge firstEdge(int oneVertex) {
		Edge myEdge = new Edge();
		myEdge.setFrom(oneVertex);
		myEdge.setTo(-1);
		for(int i=0; i<this.getNumVertex(); i++)
		{
			if (matrix[oneVertex][i]!=0) {
				myEdge.setTo(i);
				myEdge.setWeight(matrix[oneVertex][i]);
				break;
			}
		}
		return myEdge;
	}	

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#nextEdge(com.codeguru.graph.Edge)
	 */
	@Override
	public Edge nextEdge(Edge preEdge) {
		Edge myEdge = new Edge();
		myEdge.setFrom(preEdge.getFrom());
		myEdge.setTo(-1);
		for(int i=preEdge.getTo()+1; i<this.getNumVertex(); i++) {
			if (matrix[preEdge.getFrom()][i]!=0) {
				myEdge.setTo(i);
				myEdge.setWeight(matrix[preEdge.getFrom()][i]);
				break;
			}			
		}
		return myEdge;
	}

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#setEdge(int, int, int)
	 */
	@Override
	public void setEdge(int from, int to, int weight) {
		if (matrix[from][to]<=0) {
			int eCount = this.getNumEdge();
			this.setNumEdge( ++eCount );
			int[] arr = this.getIndegree();
			int indeg = arr[to];
			arr[to] = ++indeg;
			this.setIndegree(arr);			
		}
		matrix[from][to] = weight;
	}

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#delEdge(int, int)
	 */
	@Override
	public void delEdge(int from, int to) {
		if (matrix[from][to]>0) {
			int eCount = this.getNumEdge();
			this.setNumEdge( --eCount );
			int[] arr = this.getIndegree();
			int indeg = arr[to];
			arr[to] = --indeg;
			this.setIndegree(arr);			
		}
		matrix[from][to] = 0;
	}	
}
