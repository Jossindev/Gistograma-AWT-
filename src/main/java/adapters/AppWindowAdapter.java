package adapters;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
