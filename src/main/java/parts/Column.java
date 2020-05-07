package parts;

import java.awt.*;

public class Column implements Paintable {
    public static final int PARALLELOGRAM_SHIFT = Toolkit.getDefaultToolkit().getScreenSize().height / 50;
    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 30;
    public static final int HEIGHT_UNIT = Toolkit.getDefaultToolkit().getScreenSize().height / 170;
    private int percents;
    private Color brightColor;
    private Color darkColor;

    public Column(int percents, Color color) {
        this.percents = percents;
        this.brightColor = color.brighter();
        this.darkColor = color.darker();
    }

    public void paint(Graphics graphics, int x, int y) {
        Polygon parallelogram;

        //draw front side of column
        graphics.setColor(brightColor);
        graphics.fillRect(x, y, WIDTH, percents * HEIGHT_UNIT);

        //draw top side of column
        graphics.setColor(darkColor);
        parallelogram = new Polygon();
        parallelogram.addPoint(x, y);
        parallelogram.addPoint(x + WIDTH, y);
        parallelogram.addPoint(x + WIDTH + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT);
        parallelogram.addPoint(x + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT);
        graphics.fillPolygon(parallelogram);

        //draw right side of column
        parallelogram = new Polygon();
        parallelogram.addPoint(x + WIDTH, y);
        parallelogram.addPoint(x + WIDTH + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT);
        parallelogram.addPoint(x + WIDTH + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT + HEIGHT_UNIT * percents);
        parallelogram.addPoint(x + WIDTH, y + HEIGHT_UNIT * percents);
        graphics.fillPolygon(parallelogram);
    }

    public int getHeight() {
        return HEIGHT_UNIT * percents;
    }
}
