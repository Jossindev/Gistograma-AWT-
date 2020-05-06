package parts;

import java.awt.*;

public class Background {
    private static final int LEDGE = 50;
    private static final Color COLOR = Color.GRAY;
    private int height;


    public Background(int height) {
        this.height = height;
    }

    public void paint(Graphics graphics, int x, int y, int numberOfRows) {
        Polygon side;

        graphics.setColor(COLOR.darker());
        side = new Polygon();
        side.addPoint(x, y);
        side.addPoint(x, y + height);
        side.addPoint(x - Column.PARALLELOGRAM_SHIFT * numberOfRows - LEDGE, y + height + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        side.addPoint(x - Column.PARALLELOGRAM_SHIFT * numberOfRows - LEDGE, y + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        graphics.fillPolygon(side);

        graphics.setColor(COLOR);
        side = new Polygon();
        side.addPoint(x, y + height);
        side.addPoint(x + Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 6 + LEDGE, y + height);
        side.addPoint(x + Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 6 - Column.PARALLELOGRAM_SHIFT * numberOfRows, y + height + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        side.addPoint(x - Column.PARALLELOGRAM_SHIFT * numberOfRows - LEDGE, y + height + Column.PARALLELOGRAM_SHIFT * numberOfRows + LEDGE);
        graphics.fillPolygon(side);

        graphics.setColor(COLOR.brighter());
        graphics.fillRect(x, y, Column.WIDTH * 7 + ColumnRow.COLUMN_GAP * 6 + LEDGE, height);
    }
}
