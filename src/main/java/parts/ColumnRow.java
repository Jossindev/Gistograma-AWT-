package parts;

import java.util.ArrayList;
import java.util.List;

public class ColumnRow {
    private List<Column> columns;
    private int xCenter;
    private int yCenter;

    public ColumnRow(int xCenter, int yCenter) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        columns = new ArrayList<Column>();
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void paint() {
        int xTemp = 0;
        for (Column column: columns) {
            xTemp += Column.WIDTH;
            column.paint(xCenter + xTemp, yCenter - column.getHeight() + 100 * Column.HEIGHT_UNIT);
        }
    }
}
