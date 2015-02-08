package mechanics;

import java.util.*;

public class KeyLayout {

    private Map<Character, Character> qwertyToThis;

    private char[] domain;
    private char[] range;

    public KeyLayout (char[] from, char[] to) {
        qwertyToThis = new HashMap<>();
        for (int i = 0; i < from.length; i++)
            qwertyToThis.put(from[i], to[i]);
        domain = from.clone();
        range = to.clone();
    }

    public Character fromQwerty (char qwertyChar) {
        return qwertyToThis.get(qwertyChar);
    }

    public char fromThis (char thisChar) {
        for (Map.Entry<Character, Character> p : qwertyToThis.entrySet())
            if (p.getValue() == thisChar)
                return p.getKey();
        throw null;
    }

    public char[] getDomain () {
        return domain.clone();
    }

    public char[] getRange () {
        return range.clone();
    }
}
