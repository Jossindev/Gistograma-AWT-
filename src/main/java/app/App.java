package app;

import adapters.AppWindowAdapter;
import parts.Background;
import parts.Column;
import parts.ColumnRows;
import screens.ValueSetter;

import java.awt.*;

public class App extends Frame {
    private int xStart;
    private int yStart;
    private ColumnRows columnRows;

    public App() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Kursach");
        this.setSize(screenSize);
        this.setVisible(true);
        xStart = screenSize.width/ 3;
        yStart = screenSize.height / 5;

        addWindowListener(new AppWindowAdapter());

        new ValueSetter(this);

    }

    public void setColumnRows(ColumnRows columnRows) {
        this.columnRows = columnRows;
    }

    @Override
    public void paint(Graphics g) {
        if (columnRows != null) {
            Background background = new Background(100 * Column.HEIGHT_UNIT, columnRows, xStart, yStart);

            background.paint(g, xStart + Column.PARALLELOGRAM_SHIFT, yStart - Column.PARALLELOGRAM_SHIFT);
            columnRows.paint(g, xStart, yStart);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}