package mechanics;

import java.util.HashMap;
import java.util.Map;

public class KeyLayout {

	private Map<Character, Character> qwertyToThis;
	
	private char[] domain;
	private char[] range;
	
	public KeyLayout(char[] from, char[] to) {
		qwertyToThis = new HashMap<>();
		for (int i=0; i<from.length; i++)
			qwertyToThis.put(from[i], to[i]);
		domain = from.clone();
		range = to.clone();
	}
	
	public char fromQwerty (char qwertyChar) {
		return qwertyToThis.get(qwertyChar);
	}
	
	public char fromThis (char thisChar) {
		throw new RuntimeException("unimplemented");
	}
	
	public char[] getDomain() {
		return domain.clone();
	}
	
	public char[] getRange() {
		return range.clone();
	}
}
