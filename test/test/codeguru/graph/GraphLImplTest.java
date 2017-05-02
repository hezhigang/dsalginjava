/**
 * Jul 26, 2007 10:21:36 PM
 和志刚
 */
package test.codeguru.graph;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.graph.GraphLImpl;

/**
 * @author 和志刚
 *
 */
public class GraphLImplTest extends TestCase {
	private static Logger logger = Logger.getLogger(GraphLImplTest.class);

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testTraversal() {
		logger.info("Traversal>>>>>>>>>>>>>>>>>>>>>>>>>>");
		GraphLImpl g = new GraphLImpl(5);
		Map map = new HashMap();
		map.put(0, "V1");
		map.put(1, "V2");
		map.put(2, "V3");
		map.put(3, "V4");
		map.put(4, "V5");
		g.setVertices(map);
		
		g.setEdge(0, 1, 10);
		g.setEdge(1, 0, 10);
		g.setEdge(1, 4, 10);
		g.setEdge(2, 1, 10);
		g.setEdge(2, 3, 10);
		g.setEdge(3, 1, 10);
		g.setEdge(4, 3, 10);
		g.graph_traversal(g);		
	}
	
	/**
	 * Test method for {@link com.codeguru.graph.Graph#DFS(com.codeguru.graph.Graph, int)}.
	 */
	public void testDFS() {
		logger.info("DFS>>>>>>>>>>>>>>>>>>>>>>>>>>");
		GraphLImpl g = new GraphLImpl(7);
		Map map = new HashMap();
		map.put(0, "a");
		map.put(1, "b");
		map.put(2, "c");
		map.put(3, "d");
		map.put(4, "e");
		map.put(5, "f");
		map.put(6, "g");
		g.setVertices(map);
		
		g.setEdge(0, 1, 10);
		g.setEdge(0, 3, 10);
		g.setEdge(0, 4, 10);
		g.setEdge(0, 5, 10);
		
		g.setEdge(1, 2, 10);
		
		g.setEdge(2, 5, 10);
		
		g.setEdge(3, 2, 10);
		
		g.setEdge(4, 6, 10);
		
		g.setEdge(6, 2, 10);
		g.setEdge(6, 5, 10);
		
		g.DFS(g, 0);
	}
	
	public void testBFS() {
		logger.info("BFS>>>>>>>>>>>>>>>>>>>>>>>>>>");
		GraphLImpl g = new GraphLImpl(7);
		Map map = new HashMap();
		map.put(0, "a");
		map.put(1, "b");
		map.put(2, "c");
		map.put(3, "d");
		map.put(4, "e");
		map.put(5, "f");
		map.put(6, "g");
		g.setVertices(map);
		
		g.setEdge(0, 1, 10);
		g.setEdge(0, 3, 10);
		g.setEdge(0, 4, 10);
		g.setEdge(0, 5, 10);
		
		g.setEdge(1, 2, 10);
		
		g.setEdge(4, 6, 10);
		
		g.BFS(g, 0);		
	}
	
	public void testTopsortByQueue() {
		logger.info("topological sort >>>>>>>");
		GraphLImpl g = new GraphLImpl(9);
		Map map = new HashMap();
		map.put(0, "C1");
		map.put(1, "C2");
		map.put(2, "C3");
		map.put(3, "C4");
		map.put(4, "C5");
		map.put(5, "C6");
		map.put(6, "C7");
		map.put(7, "C8");
		map.put(8, "C9");		
		g.setVertices(map);	
		
		g.setEdge(0, 2, 1);
		g.setEdge(0, 7, 1);
		
		g.setEdge(1, 2, 1);
		g.setEdge(1, 3, 1);
		g.setEdge(1, 4, 1);
		
		g.setEdge(2, 3, 1);
		
		g.setEdge(3, 5, 1);
		g.setEdge(3, 6, 1);
		
		g.setEdge(4, 5, 1);
		
		g.setEdge(7, 8, 1);
		
		g.setEdge(8, 6, 1);
		
		logger.info("TopsortByQueue >>>");
		g.topsortByQueue(g);
		logger.info("TopsortByDFS >>>");
		g.topsortByDFS(g);
	}
	
	public void testTopsortByDFS() {
	}

}
