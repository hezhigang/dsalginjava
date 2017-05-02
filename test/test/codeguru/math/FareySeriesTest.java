/**
 * Oct 10, 2007 9:36:18 PM
 和志刚
 */
package test.codeguru.math;

import junit.framework.TestCase;

import com.codeguru.math.FareySeries;

/**
 * @author 和志刚
 *
 */
public class FareySeriesTest extends TestCase {

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
	 * Test method for {@link com.codeguru.math.FareySeries#buildSeries()}.
	 */
	public void testBuildSeries() {
		FareySeries.buildSeries(5);
		FareySeries.buildSeries(8);
	}

}
