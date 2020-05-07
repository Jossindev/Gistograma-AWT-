package adapters;

import screens.ValueSetter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogWindowAdapter extends WindowAdapter {
    private ValueSetter valueSetter;

    public DialogWindowAdapter(ValueSetter valueSetter) {
        this.valueSetter = valueSetter;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        valueSetter.setVisible(false);
    }
}
