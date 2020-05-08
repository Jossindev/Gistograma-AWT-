package adapters;

import screens.App;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ReenterKeyAdapter implements KeyListener {
    private App app;

    public ReenterKeyAdapter(App app) {
        this.app = app;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (KeyEvent.VK_R == keyEvent.getKeyCode()) {
            app.reenterValues();
;        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
