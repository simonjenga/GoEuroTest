package com.goeuro.rest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Test case for {@link Application}.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = AnnotationConfigContextLoader.class)
public class ApplicationTest {

	@Autowired
    private ApplicationContext ctx;

	/**
     * Test valid city name using {@code ApplicationContext} and {@code CommandLineRunner}.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Test
    public void testWithAppContext() throws Exception {
        CommandLineRunner runner = this.ctx.getBean(CommandLineRunner.class);
        runner.run("Melbourne");
    }
    
    /**
     * Test for an Empty city name.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Ignore
    public void testEmptyCityName() throws Exception {
        Application.main(new String[] { "" });
    }
	
	/**
     * Test for a Valid city name.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Ignore
    public void testValidCityName() throws Exception {
        Application.main(new String[] { "New", "York" });
    }
	
    /**
     * Test for an Invalid city name.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Ignore
    public void testInValidCityName() throws Exception {
        Application.main(new String[] { "@#$?x" });
    }
	
    /**
     * Test for an Valid city name with invalid data among the names provided.
     * The results for this test are logged to console.
     * 
     * @throws Exception If some problem inside
     */
    @Ignore
    public void testValidAndInvalidInputArguments() throws Exception {
        Application.main(new String[] { "Rio", "de", null, "Janeiro", null });
    }
	
    /**
     * Test for mandatory and valid input arguments otherwise, the validation
     * mechanism with throw an {@link java.lang.IllegalArgumentException)}
     * 
     * @throws Exception If some problem inside
     */
    @Ignore
    public void testInvalidInputArguments() throws Exception {
        try {
            Application.main(new String[] { "", null });
            Assert.fail("Exception expected here");
        } catch (IllegalArgumentException ex) {
            final String message = ex.getMessage();
            Assert.assertFalse(message.equals("") || message.equals(null));
            Assert.assertTrue(!message.equals("") && !message.equals(null));
            Assert.assertSame(message, "City name MUST be specified!");
            Assert.assertEquals(message, "City name MUST be specified!");
            Assert.assertTrue(message.equals("City name MUST be specified!"));
        }
    }
}
