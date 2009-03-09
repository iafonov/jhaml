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
}
