package screenStates;

import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import mechanics.EnglishWords;
import mechanics.KeyLayout;
import sherwood.gameScreen.GameScreen;
import sherwood.inputs.keyboard.fullKeys.FullDiscreteKeyboardInput;
import sherwood.screenStates.ScreenState;

public class WordTest extends ScreenState {
	
	private char[] domain;
	private char[] range;
	private Set<String> words;

	public WordTest(KeyLayout testingLayout) {
		this(testingLayout, testingLayout.getRange());
	}
	
	/**
	 * @param keysToTest the keys from the testing layout to test.
	 */
	public WordTest(KeyLayout testingLayout, char[] keysToTest) {
		range = keysToTest.clone();
		domain = new char[range.length];
		for (int i=0; i<domain.length; i++) {
			domain[i] = testingLayout.fromThis(range[i]);
		}
		Object o  = EnglishWords.getFilteredWords(EnglishWords.getFilteredLetterPredicate(Arrays.asList(range).stream().collect(Collectors.toSet())));
		Arrays.asList(range);
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step(BitSet keys) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init() {
		GameScreen.get().requestKeyInputMechanism(new FullDiscreteKeyboardInput());
	}

}
