package haml;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HamlTest {
    private Haml _h;

    @Before
    public void setUp() throws Exception {
	_h = new Haml();
    }
    
    @Test
    public void processList() throws Exception {	
	assertEquals("<ul><li>One</li><li>Two</li></ul>", _h.process("samples/simple_list.haml"));
    }

    @Test
    public void processNestedStruct() throws Exception {	
	assertEquals("<one><two><three>fuck!</three></two></one>", _h.process("samples/simple_nesting.haml"));
    }	
}
