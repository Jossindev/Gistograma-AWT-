package parts;

import java.awt.*;
import java.util.List;

public class Background implements Paintable{
    private static final int LEDGE = Column.WIDTH;
    private static final Color COLOR = Color.GRAY;
    private static final Font FONT = new Font(Font.MONOSPACED, Font.ITALIC, 15);
    private int height;
    private ColumnRows columnRows;
    private int xStart;
    private int yStart;


    public Background(int height, ColumnRows columnRows, int xStart, int yStart) {
        this.height = height;
        this.columnRows = columnRows;
        this.xStart = xStart;
        this.yStart = yStart;
    }

    public void paint(Graphics graphics, int x, int y) {
        Polygon side;
        int numberOfRows = columnRows.getRows().size();

        //draw left side of background
        graphics.setColor(COLOR.darker());
        side = new Polygon();
        side.addPoint(x, y);
        side.addPoint(x, y + height);
        side.addPoint(x - Column.PARALLELOGRAM_SHIFT * numberOfRows - LEDGE, y + height + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        side.addPoint(x - Column.PARALLELOGRAM_SHIFT * numberOfRows - LEDGE, y + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        graphics.fillPolygon(side);

        //draw bottom side of background
        graphics.setColor(COLOR);
        side = new Polygon();
        side.addPoint(x, y + height);
        side.addPoint(x + Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 6 + LEDGE, y + height);
        side.addPoint(x + Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 6 - Column.PARALLELOGRAM_SHIFT * numberOfRows, y + height + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        side.addPoint(x - Column.PARALLELOGRAM_SHIFT * numberOfRows - LEDGE, y + height + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        graphics.fillPolygon(side);

        //draw back side of background
        graphics.setColor(COLOR.brighter());
        graphics.fillRect(x, y, Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 6 + LEDGE, height);

        paintText(graphics);
    }

    private void paintText(Graphics graphics) {
        graphics.setFont(FONT);
        graphics.setColor(Color.BLACK);
        paintBottomText(graphics);
        paintLeftText(graphics);
        paintRightText(graphics);
    }

    private void paintBottomText(Graphics graphics) {
        int xShift = Column.WIDTH + ColumnRow.COLUMN_GAP;
        for (int i = 1; i <= 7; i++) {
            int x = xStart + xShift*(i-1) - Column.PARALLELOGRAM_SHIFT * (columnRows.getRows().size() - 1);
            int y = yStart + 100 * Column.HEIGHT_UNIT + Column.PARALLELOGRAM_SHIFT * columnRows.getRows().size();
            graphics.drawString(i + " рік", x, y);
        }
    }

    private void paintRightText(Graphics graphics) {
        List<ColumnRow> rows = columnRows.getRows();
        for (int i = 0; i < rows.size(); i++) {
            graphics.drawString(rows.get(i).getName(), xStart + Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 7 - i * Column.PARALLELOGRAM_SHIFT, yStart + 99 * Column.HEIGHT_UNIT + i * Column.PARALLELOGRAM_SHIFT);
        }
    }

    private void paintLeftText(Graphics graphics) {
        int divisions = 10;
        int maxValue = columnRows.getMaxValue();
        int yShift = 100 * Column.HEIGHT_UNIT / divisions;

        for (int i = 10; i >= 1; i--) {
            int stringShift = graphics.getFontMetrics().stringWidth(String.valueOf((int)(maxValue * 0.1 * i)));
            int x = xStart - Column.PARALLELOGRAM_SHIFT * (columnRows.getRows().size() + 1) - stringShift*2;
            int y = yStart + Column.PARALLELOGRAM_SHIFT * (columnRows.getRows().size() + 3) + yShift * (divisions - i);
            graphics.drawString(String.valueOf((int)(maxValue * 0.1 * i)), x, y);
        }
    }
}
