package parser;

public class Line {
    private final int _level;
    private final String _line;

    public Line(String line) {
	_level = parseLevel(line);
	_line = line.trim();
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
	int indexOf = _line.indexOf(' ');

	if (_line.length() == 0) {
	    return "";
	}

	if (indexOf == -1) {
	    return _line.substring(1);
	} else {
	    return _line.substring(1, _line.indexOf(' '));
	}
    }

    public String stripContents() {
	if (_line.indexOf(' ') != -1) {
	    return _line.substring(_line.indexOf(' ') + 1, _line.length());
	} else {
	    return "";
	}
    }

    public String stripCommand() {
	if (_line.length() == 0) {
	    return "";
	} else {
	    return _line.substring(0, 1);
	}
    }

    @Override
    public String toString() {
	return _level + ":" + _line;
    }

    public String process(String data) {
	return openTag() + data + closeTag();
    }

    private String openTag() {
	return "<" + stripTag() + ">";
    }

    private String closeTag() {
	return "</" + stripTag() + ">";
    }
}
