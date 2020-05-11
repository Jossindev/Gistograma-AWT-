package parts;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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

    public int getMaxValue() {
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

    public int getOverlapValue(int mouseX, int mouseY) {
        List<ColumnRow> temp = new ArrayList<>(rows);
        Collections.reverse(temp);
        for(ColumnRow row: temp) {
            for (Column column: row.getColumns()) {
                if(column.contains(mouseX, mouseY)) {
                    return column.getValue();
                }
            }
        }
        return -1;
    }
}