/**
 * Nov 23, 2007 9:42:50 PM
 和志刚
 */
package test.codeguru;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.codeguru.HashDict;

/**
 * @author 和志刚
 *
 */
public class HashDictTest extends TestCase {
	private static Logger logger = Logger.getLogger(HashDictTest.class);

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
	 * Test method for {@link com.codeguru.HashDict#ELFhash(char[])}.
	 */
	public void testELFhash() {
		String str = "hello world!";
		long hc = HashDict.ELFhash(str.toCharArray());
		logger.info("hashcode of " + str + " is " + hc);
	}

	/**
	 * Test method for {@link com.codeguru.HashDict#hash(java.lang.Object)}.
	 */
	public void testHash() {
		String str = "hello world!";
		logger.info("hashcode of " + str + " is " + HashDict.hash(str));
	}

}
