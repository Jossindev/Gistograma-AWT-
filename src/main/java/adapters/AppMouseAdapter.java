package adapters;

import screens.App;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppMouseAdapter extends MouseAdapter {
    private App app;

    public AppMouseAdapter(App app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.setMouseVars(e.getX(), e.getY());
        app.repaint();
    }
}
