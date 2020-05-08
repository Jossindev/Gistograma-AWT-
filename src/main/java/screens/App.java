package screens;

import adapters.ExitWindowAdapter;
import adapters.ReenterKeyAdapter;
import parts.Background;
import parts.Column;
import parts.ColumnRows;

import java.awt.*;

public class App extends Frame {
    private int xStart;
    private int yStart;
    private ColumnRows columnRows;
    private ValueSetter vs;
    private Dimension screenSize;

    public App() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Kursach app");
        setSize(screenSize);
        setVisible(true);
        xStart = screenSize.width/ 3;
        yStart = screenSize.height / 5;

        addWindowListener(new ExitWindowAdapter());
        addKeyListener(new ReenterKeyAdapter(this));

        vs = new ValueSetter(this);
    }

    public void setColumnRows(ColumnRows columnRows) {
        this.columnRows = columnRows;
    }

    public void reenterValues() {
        vs = new ValueSetter(this);
    }

    @Override
    public void paint(Graphics g) {
        if (columnRows != null) {
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
            String info = "Натисніть R, щоб ввести інші значення";
            g.drawString(info, screenSize.width / 2 - g.getFontMetrics().stringWidth(info) / 2, screenSize.height / 8);
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