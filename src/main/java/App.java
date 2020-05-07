import parts.Background;
import parts.Column;
import parts.ColumnRows;

import java.awt.*;

public class App extends Frame {
    private int xStart;
    private int yStart;
    App() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Kursach");
        this.setSize(screenSize);
        this.setVisible(true);
        xStart = screenSize.width/ 3;
        yStart = screenSize.height / 5;

        addWindowListener(new MyWindowAdapter());
    }

    void start() {
    }

    @Override
    public void paint(Graphics g) {
        ColumnRows columnRows = new ColumnRows(180);
        columnRows.addColumns(Color.BLUE, new int[] {100, 76, 90, 31, 87, 50, 0}, "row1");
        columnRows.addColumns(Color.ORANGE, new int[] {70, 36, 57, 96, 2, 4, 1}, "row2");
        columnRows.addColumns(Color.RED, new int[] {64, 76,4 , 23, 6, 44, 3}, "row3");

        Background background = new Background(100 * Column.HEIGHT_UNIT, columnRows, xStart, yStart);

        background.paint(g, xStart + Column.PARALLELOGRAM_SHIFT, yStart - Column.PARALLELOGRAM_SHIFT);
        columnRows.paint(g, xStart, yStart);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}