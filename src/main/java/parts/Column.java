package parts;

import java.awt.*;

public class Column implements Paintable {
    public static final int PARALLELOGRAM_SHIFT = Toolkit.getDefaultToolkit().getScreenSize().height / 50;
    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 30;
    public static final int HEIGHT_UNIT = Toolkit.getDefaultToolkit().getScreenSize().height / 170;
    private int percents;
    private Color brightColor;
    private Color darkColor;
    private Polygon front;
    private Polygon right;
    private Polygon top;

    public Column(int percents, Color color) {
        front = new Polygon();
        right = new Polygon();
        top = new Polygon();
        this.percents = percents;
        this.brightColor = color.brighter();
        this.darkColor = color.darker();
    }

    public void paint(Graphics graphics, int x, int y) {
        //draw front side of column
        graphics.setColor(brightColor);
        front = new Polygon();
        front.addPoint(x, y);
        front.addPoint(x + WIDTH, y);
        front.addPoint(x + WIDTH, y + percents * HEIGHT_UNIT);
        front.addPoint(x, y + percents * HEIGHT_UNIT);
        graphics.fillPolygon(front);
//        graphics.fillRect(x, y, WIDTH, percents * HEIGHT_UNIT);

        //draw top side of column
        graphics.setColor(darkColor);
        top = new Polygon();
        top.addPoint(x, y);
        top.addPoint(x + WIDTH, y);
        top.addPoint(x + WIDTH + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT);
        top.addPoint(x + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT);
        graphics.fillPolygon(top);

        //draw right side of column
        right = new Polygon();
        right.addPoint(x + WIDTH, y);
        right.addPoint(x + WIDTH + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT);
        right.addPoint(x + WIDTH + PARALLELOGRAM_SHIFT, y - PARALLELOGRAM_SHIFT + HEIGHT_UNIT * percents);
        right.addPoint(x + WIDTH, y + HEIGHT_UNIT * percents);
        graphics.fillPolygon(right);
    }

    public int getHeight() {
        return HEIGHT_UNIT * percents;
    }

    public boolean contains(int x, int y) {
        Point point = new Point(x, y);
        return top.contains(point) || right.contains(point) || front.contains(point);
    }

    public int getValue() {
        return percents;
    }
}
