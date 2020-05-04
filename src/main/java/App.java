import java.awt.*;

class App extends Frame {
    App() {
        this.setTitle("Kursach");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);

        addWindowListener(new MyWindowAdapter());
    }

    void start() {
    }
}
