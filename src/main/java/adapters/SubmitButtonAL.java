package adapters;

import screens.ValueSetter;

import java.awt.event.*;

public class SubmitButtonAL implements ActionListener {
    private ValueSetter valueSetter;

    public SubmitButtonAL(ValueSetter valueSetter) {
        this.valueSetter = valueSetter;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        valueSetter.submit();
        valueSetter.setVisible(false);
    }
}
