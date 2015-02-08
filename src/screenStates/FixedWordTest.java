package screenStates;

import extension.KeyUpdateAlgorithm;
import mechanics.EnglishWords;
import mechanics.KeyLayout;
import sherwood.gameScreen.GameScreen;
import sherwood.inputs.keyboard.fullKeys.FullDiscreteKeyboardInput;
import sherwood.screenStates.ScreenState;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FixedWordTest extends ScreenState {

    private char[] domain;
    private char[] range;
    private List<String> words;
    private Stack<String> test;
    private KeyLayout keyLayout;

    public FixedWordTest (KeyLayout testingLayout) {
        this(testingLayout, testingLayout.getRange(), 100);
    }

    /**
     * @param keysToTest the keys from the testing layout to test.
     */
    public FixedWordTest (KeyLayout testingLayout, char[] keysToTest, int size) {
        this.keyLayout = testingLayout;
        range = keysToTest.clone();
        domain = new char[range.length];
        for (int i = 0; i < domain.length; i++) {
            domain[i] = testingLayout.fromThis(range[i]);
        }
        Set<Character> keys = new HashSet<>();
        for (char p : keysToTest)
            keys.add(p);
        words = EnglishWords.getFilteredWords(EnglishWords.getFilteredLetterPredicate(keys));
        test = new Stack<>();
        for (int i = 0; i < size; i++)
            test.push(words.get((int) (Math.random() * words.size())));
    }

    @Override
    public void draw (Graphics2D g) {
        // TODO Auto-generated method stub
        g.setFont(new Font("consolas", Font.PLAIN, 16));
        int i = 0;
        for (String t : test) {
            g.drawString(t, (i % 8) * 100 + 15, (i / 8) * 48 + 15);
            i += 1;
        }
    }

    @Override
    public void step (BitSet keys) {
        char r = (char) keys.nextSetBit(0);
        Character p = keyLayout.fromQwerty(r);
        if (p == null) return;
        System.out.print(p);

    }

    @Override
    public void init () {
        super.init();
        GameScreen.get().requestUpdateAlgorithm(new KeyUpdateAlgorithm());
        GameScreen.get().requestKeyInputMechanism(new FullDiscreteKeyboardInput());
    }

}
