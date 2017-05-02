/**
 * Aug 1, 2007 9:02:01 PM
 和志刚
 */
package test.codeguru.graph;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codeguru.graph.GraphLImpl;
import com.codeguru.graph.GraphMImpl;

/**
 * @author 和志刚
 *
 */
public class GraphMImplTest extends TestCase {
	private static Logger logger = Logger.getLogger(GraphMImplTest.class);
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.codeguru.graph.Graph#graph_traversal(com.codeguru.graph.Graph)}.
	 */
	@Test
	public void testGraph_traversal() {
		logger.info("Traversal>>>>>>>>>>>>>>>>>>>>>>>>>>");
		GraphMImpl g = new GraphMImpl(5);
		g.setEdge(0, 1, 1);
		g.setEdge(1, 0, 1);
		g.setEdge(1, 4, 1);
		g.setEdge(2, 1, 1);
		g.setEdge(2, 3, 1);
		g.setEdge(3, 1, 1);
		g.setEdge(4, 3, 1);		
		Map map = new HashMap();
		map.put(0, "V1");
		map.put(1, "V2");
		map.put(2, "V3");
		map.put(3, "V4");
		map.put(4, "V5");
		g.setVertices(map);
		g.graph_traversal(g);
	}

	/**
	 * Test method for {@link com.codeguru.graph.Graph#DFS(com.codeguru.graph.Graph, int)}.
	 */
	@Test
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

	/**
	 * Test method for {@link com.codeguru.graph.Graph#BFS(com.codeguru.graph.Graph, int)}.
	 */
	@Test
	public void testBFS() {
		fail("Not yet implemented");
	}

}
