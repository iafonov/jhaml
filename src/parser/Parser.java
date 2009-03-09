package parser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static final int INDENT_SIZE = 2;
    private List<Line> _file;

    public Parser(String fileName) {
	_file = parseFile(fileName);
    }

    public String parse() {
	return eval(_file);
    }

    private String eval(List<Line> list) {
	String result = "";

	for (int i = 0; i < list.size(); i++) {
	    Line line = list.get(i);
	    if (hasSubExpression(list, i)) {
		result +=
			"<"
				+ line.stripTag()
				+ ">"
				+ eval(list.subList(i + 1, getSubExpressionEnd(
					list, i + 1))) + "</" + line.stripTag()
				+ ">";

		i += getSubExpressionSize(list, i + 1); //TODO:bullshit
	    } else {
		result +=
			"<" + line.stripTag() + ">" + line.stripContents()
				+ "</" + line.stripTag() + ">";
	    }
	}

	return result;
    }

    private int getSubExpressionEnd(List<Line> list, int startIndex) {
	return startIndex + getSubExpressionSize(list, startIndex);
    }

    private int getSubExpressionSize(List<Line> list, int startIndex) {
	int size = 0;
	int startLevel = list.get(startIndex).getLevel();

	for (int i = startIndex; i < list.size(); i++) {
	    if (list.get(i).getLevel() < startLevel) {
		break;
	    } else {
		size++;
	    }
	}
	return size;
    }

    private boolean hasSubExpression(List<Line> list, int i) {
	return (((i + 1) < list.size()) && (list.get(i + 1).getLevel() > list
		.get(i).getLevel()));
    }

    private List<Line> parseFile(String fileName) {
	List<Line> result = new ArrayList<Line>();

	try {
	    FileInputStream fstream = new FileInputStream(fileName);
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
