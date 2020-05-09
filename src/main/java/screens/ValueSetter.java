package screens;

import adapters.DialogWindowAdapter;
import parts.ColumnRows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ValueSetter extends Frame {
    private static final float D = 0.6f;
    private App app;
    private List<Color> colors;
    private TextField[] nameFields;
    private TextField[][] valueFields;

    public ValueSetter(App app) {
        this.app = app;
        setSize(600, 600);
        setResizable(false);
        colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.ORANGE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        nameFields = new TextField[10];
        valueFields = new TextField[10][7];

        addWindowListener(new DialogWindowAdapter(this));

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        JPanel panel;

        panel = new JPanel();
        panel.setLayout(new FlowLayout() {{setAlignment(FlowLayout.LEFT);}});
        panel.add(new Label("    Назва   "));
        for (int i = 1; i < 8; i++) {
            panel.add(new Label("    Рік " + i + "    "));
        }
        add(panel);

        for (int i = 0; i < 10; i++) {
            panel = new JPanel();
            panel.setLayout(new FlowLayout() {{setAlignment(FlowLayout.LEFT);}});
            nameFields[i] = new TextField(5);
            panel.add(nameFields[i]);
            for (int j = 0; j < 7; j++) {
                valueFields[i][j] = new TextField(5);
                panel.add(valueFields[i][j]);
            }
            add(panel);
        }
        Button submit = new Button("submit");
        submit.addActionListener(actionEvent -> {submit(); setVisible(false);});
        add(submit);

        setVisible(true);
    }

    public void submit() {
        int maxValue = 0;
        List<Integer[]> values = new ArrayList<>();
        label: {
            for (TextField[] textFields : valueFields) {
                List<Integer> localValues = new ArrayList<>(7);
                for (TextField textField : textFields) {
                    try {
                        if ("".equals(textField.getText())) {
                            break label;
                        }
                        int value = (int) (Integer.parseInt(textField.getText()) * D);
                        if (maxValue < value) {
                            maxValue = value;
                        }
                        localValues.add(value);
                    } catch (NumberFormatException e) {
                        localValues.add(0);
                        System.out.println(e.getMessage());
                    }
                }
                Integer[] array = new Integer[7];
                values.add(localValues.toArray(array));
            }
        }
        ColumnRows columnRows = new ColumnRows(maxValue);
        for (Integer[] value: values) {
            Color color = colors.remove(0);
            colors.add(color);
            columnRows.addColumns(color, value, nameFields[values.indexOf(value)].getText());
        }
        app.setColumnRows(columnRows);
        app.setVisible(false);
        app.setVisible(true);
    }
}
