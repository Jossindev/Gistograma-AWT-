package screens;

import adapters.ExitWindowAdapter;
import adapters.StartKeyAdapter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends Frame {
    private BufferedImage image;

    public Menu() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Kursach menu");
        setSize(screenSize);

        loadImage();

        setVisible(true);
        addKeyListener(new StartKeyAdapter(this));
        addWindowListener(new ExitWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
        g.setColor(Color.WHITE);
        Font font = new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 50);
        g.setFont(font);
        String info;
        info =  "Курсова робота " + System.lineSeparator() +
                "Студента групи ПР-2-1" + System.lineSeparator() +
                "Кушпи Артема Вікторовича" + System.lineSeparator() +
                "Варіант 10" + System.lineSeparator() +
                "Об'ємна гістограма" + System.lineSeparator() +
                "Натисніть F для початку роботи";

        drawInfo(g, info, Toolkit.getDefaultToolkit().getScreenSize());
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    private void loadImage() {
        File file;
        try {
            file = new File(getClass().getClassLoader().getResource("background.jpg").getFile());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return;
        }

        try {
            image= ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawInfo(Graphics g, String text, Dimension screen) {
        int x = screen.width / 2 - (g.getFontMetrics().stringWidth(text) / 9);
        int y = screen.height / 2 - g.getFontMetrics().getHeight() * 3;
        for (String line : text.split(System.lineSeparator())) {
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }
}
