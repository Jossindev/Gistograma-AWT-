package parts;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColumnRows implements Paintable {
    private List<ColumnRow> rows;

    public ColumnRows() {
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

    public void paint(Graphics graphics, int x, int y) {
        int yShift = 0;
        int xShift = 0;
        for (ColumnRow row: rows) {
            row.paint(graphics, x - xShift, y + yShift);
            yShift += Column.PARALLELOGRAM_SHIFT;
            xShift += Column.PARALLELOGRAM_SHIFT;
        }
    }
}