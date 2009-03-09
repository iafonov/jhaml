package parser;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {   
    @Before
    public void setUp() throws Exception {
	
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parseList() throws Exception {
	Parser p = new Parser("samples/simple_list.haml");
	Assert.assertEquals("<ul><li>One</li><li>Two</li></ul>", p.parse());
    }

    @Test
    public void parseNestedStruct() throws Exception {
	Parser p = new Parser("samples/simple_nesting.haml");
	Assert.assertEquals("<one><two><three>fuck!</three></two></one>", p.parse());
    }
}
