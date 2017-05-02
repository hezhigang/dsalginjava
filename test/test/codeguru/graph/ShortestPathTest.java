/**
 * Aug 30, 2007 4:01:16 PM
 和志刚
 */
package test.codeguru.graph;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.graph.GraphLImpl;
import com.codeguru.graph.GraphMImpl;
import com.codeguru.graph.ShortestPath;

/**
 * @author 和志刚
 *
 */
public class ShortestPathTest extends TestCase {
	private static Logger logger = Logger.getLogger(ShortestPathTest.class);
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
	 * Test method for {@link com.codeguru.graph.ShortestPath#dijkstra(com.codeguru.graph.Graph, int, com.codeguru.graph.Dist[])}.
	 */
	public void testDijkstra() {
		GraphLImpl g = new GraphLImpl(6);
		Map map = new HashMap();
		map.put(0, "V1");
		map.put(1, "V2");
		map.put(2, "V3");
		map.put(3, "V4");
		map.put(4, "V5");
		map.put(5, "V6");
		g.setVertices(map);
		
		g.setEdge(0, 1, 50);
		g.setEdge(0, 2, 10);
		
		g.setEdge(1, 2, 15);
		g.setEdge(1, 4, 50);
		
		g.setEdge(2, 0, 20);
		g.setEdge(2, 3, 15);
		
		g.setEdge(3, 1, 20);
		g.setEdge(3, 4, 35);
		
		g.setEdge(4, 3, 30);
		
		g.setEdge(5, 3, 3);	
		
		ShortestPath.dijkstra(g, 0, null);
		
		logger.info("不可达顶点：");
		for(int i=0; i<g.getNumVertex(); i++)
			if (g.getMark()[i]==false)
				logger.info(i);
				
	}
	
	public void testFloyd() {
		logger.info("Floyd >>>>>>>>>>>>>>>>>>>>>>>>>>");
		GraphMImpl g = new GraphMImpl(3);
		g.setEdge(0, 1, 4);
		g.setEdge(0, 2, 11);
		
		g.setEdge(1, 0, 6);
		g.setEdge(1, 2, 2);
		
		g.setEdge(2, 0, 3);
		
		Map map = new HashMap();
		map.put(0, "V1");
		map.put(1, "V2");
		map.put(2, "V3");
		
		g.setVertices(map);		
		
		ShortestPath.floyd(g);
	}

}
