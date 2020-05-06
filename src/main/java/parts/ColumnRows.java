package parts;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColumnRows {
    private List<ColumnRow> rows;
    private int xCenter;
    private int yCenter;

    public ColumnRows(int xCenter, int yCenter) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        rows = new ArrayList<ColumnRow>();
    }

    public void addColumns(Color color, int[] percents) {
        ColumnRow columnRow = new ColumnRow();
        for (int percent: percents) {
            columnRow.addColumn(new Column(percent, color));
        }
        rows.add(columnRow);
    }

    public int getNumberOfRows() {
        return rows.size();
    }

    public void paint(Graphics graphics) {
        int yShift = 0;
        int xShift = 0;
        for (ColumnRow row: rows) {
            row.paint(graphics, xCenter - xShift, yCenter + yShift);
            yShift += Column.PARALLELOGRAM_SHIFT;
            xShift += Column.PARALLELOGRAM_SHIFT;
        }
    }
}