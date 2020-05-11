package adapters;

import screens.App;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReenterKeyAdapter extends KeyAdapter {
    private App app;

    public ReenterKeyAdapter(App app) {
        this.app = app;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (KeyEvent.VK_R == keyEvent.getKeyCode()) {
            app.reenterValues();
;        }
    }
}
