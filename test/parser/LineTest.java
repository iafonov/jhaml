package parser;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class LineTest {
    @Test
    public void testEmpty() throws Exception {
	Line l = new Line("");
	
	assertEquals("", l.stripContents());
	assertEquals("", l.stripTag());
	assertEquals("", l.stripCommand());
	assertEquals(0, l.getLevel());	
    }
    
    @Test
    public void testZeroLevel() throws Exception {
	Line l = new Line("%h1 Hello");
	
	assertEquals("Hello", l.stripContents());
	assertEquals("h1", l.stripTag());
	assertEquals("%", l.stripCommand());
	assertEquals(0, l.getLevel());	
    }
    
    @Test
    public void testFirstLevel() throws Exception {
	Line l = new Line("  %strike");
	
	assertEquals("", l.stripContents());
	assertEquals("strike", l.stripTag());
	assertEquals("%", l.stripCommand());
	assertEquals(1, l.getLevel());	
    }
    
    @Test
    public void testClassConvert() throws Exception {
	Line l = new Line("        .left.column left column contents");
	
	assertEquals("left column contents", l.stripContents());
	//TODO: should be "left column"
	assertEquals("left.column", l.stripTag()); 
	assertEquals(".", l.stripCommand());
	assertEquals(4, l.getLevel());	
    }
}
