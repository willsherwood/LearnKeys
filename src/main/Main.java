package main;

import mechanics.KeyLayout;
import screenStates.FixedWordTest;
import sherwood.gameScreen.GameScreen;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        char[] from = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>? ".toCharArray();
        final KeyLayout keyLayout = new KeyLayout(from, from);
        SwingUtilities.invokeLater(()->GameScreen.start(new FixedWordTest(keyLayout, "asdflkjh".toCharArray(), 100), "LearnKeys - Will Sherwood"));
	}
}
