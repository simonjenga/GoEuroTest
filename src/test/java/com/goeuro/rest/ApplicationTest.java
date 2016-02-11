package com.goeuro.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test case for {@link Application}.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@RunWith(JUnit4.class)
public class ApplicationTest {

    /**
     * Test for a Valid city name.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Test
    public void testValidCityName() throws Exception {
        Application.main(new String[] { "New", "York" });
    }
	
    /**
     * Test for an Invalid city name.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Test
    public void testInValidCityName() throws Exception {
        Application.main(new String[] { "@#$?x" });
    }
	
    /**
     * Test for an Valid city name with invalid data among the names provided.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Test
    public void testValidAndInvalidInputArguments() throws Exception {
        Application.main(new String[] { "Rio", "de", null, "Janeiro", null });
    }
	
    /**
     * Test for mandatory and valid input arguments otherwise, the validation
     * mechanism with throw an {@link java.lang.IllegalArgumentException)}
     * 
     * @throws Exception If some problem inside
     */
    @Test
    public void testInvalidInputArguments() throws Exception {
        try {
            Application.main(new String[] { "", null });
            Assert.fail("Exception expected here");
        } catch (IllegalArgumentException ex) {
        	final String message = ex.getMessage();
            Assert.assertSame(message, "City name MUST be specified!");
            Assert.assertEquals(message, "City name MUST be specified!");
            Assert.assertTrue(message.equals("City name MUST be specified!"));
            Assert.assertFalse(message.equals("") || message.equals(null));
        }
    }
}
