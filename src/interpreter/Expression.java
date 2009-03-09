package interpreter;

import java.util.List;

import parser.Line;

public interface Expression {
    String eval(List<Line> expression);
}
