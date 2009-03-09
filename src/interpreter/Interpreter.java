package interpreter;

import java.util.List;

import parser.Line;

public class Interpreter {

    public String eval(List<Line> list) {
	String result = "";

	for (int i = 0; i < list.size(); i++) {
	    Line line = list.get(i);
	    if (hasSubExpression(list, i)) {
		result += line.process(eval(getSubexpression(list, i)));

		i += getSubExpressionSize(list, i + 1); // TODO:bullshit
	    } else {
		result += line.process(line.stripContents());
	    }
	}

	return result;
    }

    private List<Line> getSubexpression(List<Line> list, int i) {
	return list.subList(i + 1, getSubExpressionEnd(list, i + 1));
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
}
