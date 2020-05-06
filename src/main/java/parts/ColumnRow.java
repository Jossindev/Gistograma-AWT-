package parts;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ColumnRow {
    public static final int COLUMN_GAP = 10;
    private List<Column> columns;

    public ColumnRow() {
        columns = new ArrayList<Column>();
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void paint(Graphics graphics, int xCenter, int yCenter) {
        int xShift = 0;
        for (Column column: columns) {
            column.paint(graphics, xCenter + xShift, yCenter - column.getHeight() + 100 * Column.HEIGHT_UNIT);
            xShift += Column.WIDTH + COLUMN_GAP;
        }
    }
}
