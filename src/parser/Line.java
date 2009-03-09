package parser;

public class Line {
    private final int _level;
    private final String _line;

    public Line(String line) {
	_level = parseLevel(line);
	_line = line;
    }

    private int parseLevel(String line) {
	for (int i = 0; i < line.length(); i++) {
	    if (line.charAt(i) != ' ') {
		return (i / Parser.INDENT_SIZE);
	    }
	}

	return 0;
    }

    public int getLevel() {
	return _level;
    }

    public String getLine() {
	return _line;
    }
    
    public String stripTag() {
	int indexOf = _line.trim().indexOf(' ');
	
	if (indexOf == -1) {
	    return _line.trim().substring(1);
	} else {
	    return _line.trim().substring(1, _line.trim().indexOf(' '));
	}
    }
    
    public String stripContents() {
	return _line.trim().substring(_line.trim().indexOf(' ') + 1, _line.trim().length());
    }

    public String stripCommand() {
	return "";
    }
    
    @Override
    public String toString() {
	return _level + ":" + _line;
    }    
}
