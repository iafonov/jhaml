package parser;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {   
    private Parser _p;

    @Before
    public void setUp() throws Exception {
	_p = new Parser();	
    }
    
    @Test
    public void parseList() throws Exception {	
	List<Line> parsedTemplate = _p.parse("samples/simple_list.haml");
	
	assertEquals(0, parsedTemplate.get(0).getLevel());
	assertEquals(1, parsedTemplate.get(1).getLevel());
	assertEquals(1, parsedTemplate.get(2).getLevel());
	
	assertEquals("%li One", parsedTemplate.get(1).getLine());
    }

    @Test
    public void parseNestedStruct() throws Exception {		
	List<Line> parsedTemplate = _p.parse("samples/simple_nesting.haml");
	
	assertEquals(0, parsedTemplate.get(0).getLevel());
	assertEquals(1, parsedTemplate.get(1).getLevel());
	assertEquals(2, parsedTemplate.get(2).getLevel());
	
	assertEquals("%two", parsedTemplate.get(1).getLine());
    }
}
