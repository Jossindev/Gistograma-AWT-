package parts;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColumnRow implements Paintable {
    public static final int COLUMN_GAP = 10;
    private List<Column> columns;
    private String name;

    public ColumnRow(String name) {
        this.name = name;
        columns = new ArrayList<Column>();
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void paint(Graphics graphics, int x, int y) {
        int xShift = 0;
        for (Column column: columns) {
            int localX = x + xShift;
            int localY = y - column.getHeight() + 100 * Column.HEIGHT_UNIT;
            column.paint(graphics, localX, localY);
            xShift += Column.WIDTH + COLUMN_GAP;
        }
    }

    public String getName() {
        return name;
    }
}
