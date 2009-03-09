package parser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static final int INDENT_SIZE = 2;

    public List<Line> parse(String templatePath) {
	List<Line> result = new ArrayList<Line>();

	try {
	    FileInputStream fstream = new FileInputStream(templatePath);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));

	    String strLine;
	    while ((strLine = br.readLine()) != null) {
		result.add(new Line(strLine));
	    }
	    in.close();
	} catch (Exception e) {
	    System.err.println("Error: " + e.getMessage());
	}
	return result;
    }
}
