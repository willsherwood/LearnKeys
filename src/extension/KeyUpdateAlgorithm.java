package extension;

import sherwood.gameScreen.GameScreen;
import sherwood.gameScreen.UpdateAlgorithm;
import sherwood.inputs.keyboard.KeyboardInput;
import sherwood.screenStates.ScreenState;

import java.awt.*;

public class KeyUpdateAlgorithm implements UpdateAlgorithm {

    @Override
    public void update (ScreenState screenState, Graphics2D graphics, GameScreen gameScreen, KeyboardInput input) {
        screenState.step(input.getBitSet());
        screenState.draw(graphics);
        gameScreen.paintToBuffer(null);
    }
}
