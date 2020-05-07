package adapters;

import screens.App;
import screens.Menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartKeyAdapter implements KeyListener {
    private Menu menu;

    public StartKeyAdapter(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (KeyEvent.VK_F == keyEvent.getKeyCode()) {
            menu.setVisible(false);
            new App();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
