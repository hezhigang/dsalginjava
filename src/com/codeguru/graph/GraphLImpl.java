/**
 * Jul 24, 2007 9:14:09 PM
 和志刚
 */
package com.codeguru.graph;

/**
 * @author 和志刚
 * 图的邻接表实现
 */
public class GraphLImpl extends Graph {
	private LList<ListUnit> graList[];

	public GraphLImpl(int numVertex) {
		super(numVertex);
		graList = new LList[numVertex];
		for(int i=0; i<numVertex; i++)
			graList[i] = new LList<ListUnit>();
	}

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#firstEdge(int)
	 */
	@Override
	public Edge firstEdge(int oneVertex) {
		Edge myEdge = new Edge();
		myEdge.setFrom(oneVertex);
		myEdge.setTo(-1);
		Link<ListUnit> temp =  graList[oneVertex].getHead();
		if (temp.getNext()!=null)
		{
			myEdge.setTo(temp.getNext().getElement().vertex);
			myEdge.setWeight(temp.getNext().getElement().weight);
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
		Link<ListUnit> temp =  graList[preEdge.getFrom()].getHead();
		while(temp.getNext()!=null && temp.getNext().getElement().vertex<=preEdge.getTo())
			temp = temp.getNext();
		if (temp.getNext()!=null)
		{
			temp = temp.getNext();
			myEdge.setTo(temp.getElement().vertex);
			myEdge.setWeight(temp.getElement().weight);
		}
		return myEdge;
	}

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#setEdge(int, int, int)
	 */
	@Override
	public void setEdge(int from, int to, int weight) {
		Link<ListUnit> temp =  graList[from].getHead();
		//定位边表中的位置
		while(temp.getNext()!=null && temp.getNext().getElement().vertex<to)
			temp = temp.getNext();
		if (temp.getNext()==null)
		{
			ListUnit data = new ListUnit();
			data.vertex = to;
			data.weight = weight;
			temp.setNext( new Link<ListUnit>(data, null) );
			int eCount = this.getNumEdge();
			this.setNumEdge( ++eCount );
			int[] arr = this.getIndegree();
			int indeg = arr[to];
			arr[to] = ++indeg;
			this.setIndegree(arr);
			return;
		}
		
		if (temp.getNext().getElement().vertex==to) {
			ListUnit data = temp.getNext().getElement();
			data.weight = weight;
			temp.getNext().setElement(data);
			return;
		}
		//链表的结点插入
		if (temp.getNext().getElement().vertex>to) {
			Link<ListUnit> other =  temp.getNext();
			ListUnit data = new ListUnit();
			data.vertex = to;
			data.weight = weight;
			temp.setNext( new Link<ListUnit>(data, other) );
			int eCount = this.getNumEdge();
			this.setNumEdge( ++eCount );
			int[] arr = this.getIndegree();
			int indeg = arr[to];
			arr[to] = ++indeg;
			this.setIndegree(arr);
			return;			
		}
	}

	/* (non-Javadoc)
	 * @see com.codeguru.graph.Graph#delEdge(int, int)
	 */
	@Override
	public void delEdge(int from, int to) {
		Link<ListUnit> temp =  graList[from].getHead();
		while(temp.getNext()!=null && temp.getNext().getElement().vertex<to)
			temp = temp.getNext();
		if (temp.getNext()==null || temp.getNext().getElement().vertex>to)
			return;
		if (temp.getNext().getElement().vertex==to) {
			Link<ListUnit> other =  temp.getNext().getNext();
			temp.setNext(other);
			int eCount = this.getNumEdge();
			this.setNumEdge( --eCount );
			int[] arr = this.getIndegree();
			int indeg = arr[to];
			arr[to] = --indeg;
			this.setIndegree(arr);			
			return;
		}
	}
}
