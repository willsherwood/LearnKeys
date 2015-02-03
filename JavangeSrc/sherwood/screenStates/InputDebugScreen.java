package sherwood.screenStates;

import sherwood.gameScreen.GameScreen;
import sherwood.inputs.keyboard.control.Control;
import sherwood.inputs.keyboard.control.MixedControlKeyboardInput;

import java.awt.*;
import java.util.*;

public class InputDebugScreen extends ScreenState {

    protected BitSet keys;

    public InputDebugScreen () {
        keys = new BitSet(0);
    }

    @Override
    public void init () {
        BitSet mixed = new BitSet(Control.values().length);
        Control[] continuous = {Control.LEFT, Control.RIGHT, Control.UP, Control.DOWN};
        for (Control p : continuous)
            mixed.set(Control.getCondensed(p), true);
        GameScreen.get().requestKeyInputMechanism(new MixedControlKeyboardInput(mixed));
    }

    @Override
    public void draw (Graphics2D g) {
        g.setColor(Color.RED);
        g.drawRect(0, 0, GameScreen.WIDTH - 1, GameScreen.HEIGHT - 1);
        for (int y = 0; y < Control.values().length; y++) {
            if (keys.get(y))
                g.fillRect(5, y * 20 + 8, 15, 15);
            g.drawString(Control.values()[y].toString(), 20, y * 20 + 20);
        }
    }

    @Override
    public void step (BitSet keys) {
        this.keys = keys;
    }

}
