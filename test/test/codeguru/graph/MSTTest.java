/**
 * Sep 16, 2007 8:37:59 PM
 和志刚
 */
package test.codeguru.graph;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.graph.GraphLImpl;
import com.codeguru.graph.MST;

/**
 * @author 和志刚
 *
 */
public class MSTTest extends TestCase {
	private static Logger logger = Logger.getLogger(MSTTest.class);
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

	/**
	 * Test method for {@link com.codeguru.graph.MST#kruskal(com.codeguru.graph.Graph)}.
	 */
	public void testKruskal() {
		GraphLImpl g = new GraphLImpl(6);
		Map map = new HashMap();
		map.put(0, "V1");
		map.put(1, "V2");
		map.put(2, "V3");
		map.put(3, "V4");
		map.put(4, "V5");
		map.put(5, "V6");
		g.setVertices(map);
		
		g.setEdge(0, 1, 10);
		g.setEdge(0, 4, 19);
		g.setEdge(0, 5, 21);
		
		g.setEdge(1, 0, 10);
		g.setEdge(1, 2, 5);
		g.setEdge(1, 3, 6);
		g.setEdge(1, 5, 11);
		
		g.setEdge(2, 1, 5);
		g.setEdge(2, 3, 6);
		
		g.setEdge(3, 1, 6);
		g.setEdge(3, 2, 6);
		g.setEdge(3, 4, 18);
		g.setEdge(3, 5, 14);		
		
		g.setEdge(4, 0, 19);
		g.setEdge(4, 3, 18);
		g.setEdge(4, 5, 33);
		
		g.setEdge(5, 0, 21);
		g.setEdge(5, 1, 11);
		g.setEdge(5, 3, 14);
		g.setEdge(5, 4, 33);
		
		logger.info("Kruskal MST------->");
		MST.kruskal(g);
	}
	
	/**
	 * Test method for {@link com.codeguru.graph.MST#prim(com.codeguru.graph.Graph)}.
	 */
	public void testPrim() {
		GraphLImpl g = new GraphLImpl(6);
		Map map = new HashMap();
		map.put(0, "V1");
		map.put(1, "V2");
		map.put(2, "V3");
		map.put(3, "V4");
		map.put(4, "V5");
		map.put(5, "V6");
		g.setVertices(map);
		
		g.setEdge(0, 1, 10);
		g.setEdge(0, 4, 19);
		g.setEdge(0, 5, 21);
		
		g.setEdge(1, 0, 10);
		g.setEdge(1, 2, 5);
		g.setEdge(1, 3, 6);
		g.setEdge(1, 5, 11);
		
		g.setEdge(2, 1, 5);
		g.setEdge(2, 3, 6);
		
		g.setEdge(3, 1, 6);
		g.setEdge(3, 2, 6);
		g.setEdge(3, 4, 18);
		g.setEdge(3, 5, 14);		
		
		g.setEdge(4, 0, 19);
		g.setEdge(4, 3, 18);
		g.setEdge(4, 5, 33);
		
		g.setEdge(5, 0, 21);
		g.setEdge(5, 1, 11);
		g.setEdge(5, 3, 14);
		g.setEdge(5, 4, 33);
		
		logger.info("Prim MST------->");
		MST.prim(g, 0);
	}	

}
