package haml;

import interpreter.Interpreter;
import parser.Parser;

public class Haml {
    public String process(String templatePath) {
	Parser p  = new Parser();
	Interpreter i = new Interpreter();
	
	return i.eval(p.parse(templatePath));
    }
}
