package parts;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColumnRows implements Paintable {
    private List<ColumnRow> rows;
    private int maxValue;

    public ColumnRows(int maxValue) {
        rows = new ArrayList<>();
        this.maxValue = maxValue;
    }

    public void addColumns(Color color, Integer[] percents, String name) {
        ColumnRow columnRow = new ColumnRow(name);
        for (int percent: percents) {
            columnRow.addColumn(new Column(percent * 100 / maxValue, color));
        }
        rows.add(columnRow);
    }

    public List<ColumnRow> getRows() {
        return rows;
    }

    int getMaxValue() {
        return maxValue;
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