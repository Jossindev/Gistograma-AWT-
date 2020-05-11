package adapters;

import screens.App;
import screens.Menu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartKeyAdapter extends KeyAdapter {
    private Menu menu;
    boolean existsAppInstance;

    public StartKeyAdapter(Menu menu) {
        this.menu = menu;
        existsAppInstance = false;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (KeyEvent.VK_F == keyEvent.getKeyCode()) {
            menu.setVisible(false);
            if (!existsAppInstance) {
                new App();
                existsAppInstance = true;
            }
        }
    }
}
